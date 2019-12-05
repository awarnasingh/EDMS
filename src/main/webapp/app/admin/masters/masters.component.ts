import { Component, OnInit } from '@angular/core';
import { LOCATION, SERVER_API_URL, WARNING, OOPS, DATA_IS, ASDFAF, API_LOCATIONS, EMP_TYPE, API_EMPTYPES, CLIENT_DOMAIN, CLIENT_DOMAINS, END_CLIENT, API_ENDCLIENTS, WORK_AUTHORIZATION, WORK_AUTHORIZATIONS, PRIME_VENDOR, API_PRIMEVENDORS, JOB_TITLE, MODE, API_JOBTITLES, API_MODES, PAY_TYPE, API_PAYTYPES, EMPLOYER, API_EMPLOYERS, STATUS, API_STATUS } from 'app/app.constants';
import { Configure, IConfigure } from 'app/shared/model/configure.model';
import { MastersService } from 'app/admin/masters/masters.service';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';
import {
    MASTER_SUCCESS_MSG,
    MASTER_UPDATE_MSG,
    MASTER_ERROR_MSG,
    MASTER_EXIST_ERROR_MSG,
    SLACE, BLANK, INFO, ERROR, SUCCESS
} from 'app/app.constants';
@Component({
   selector: 'jhi-masters',
   templateUrl: './masters.component.html',
   styleUrls: ['masters.component.scss']
})
export class MastersComponent implements OnInit {
   selectionElement: string;
   inputData = '';
   configureData: IConfigure;
   masters: any;
   private url: string;
   helper: any;
   elementName: '';
   elementid: any;
   // mastersDrpdwn = ['Location', 'Mode', 'PayType', 'Employer', 'ClientDomain', 'EndDomain', 'Status'];

   constructor(private masterService: MastersService, private route: Router, private modalService: NgbModal) {
   }

   ngOnInit() {
       this.selectionElement = LOCATION;
       this.selection(this.selectionElement);
   }

   selectedId(data) {
        this.elementName = data.name;
        this.elementid = data.id;
   }

   selection(selectionElement: string) {
       this.selectionElement = selectionElement;
       this.url = this.getUrlBasedConfigureType(this.selectionElement);
       this.masterService.query(this.url).subscribe(res => {
           this.masters = res.body;
       });
   }

   updateData(data) {
        this.configureData = new Configure();
        this.configureData.id = this.elementid;
        this.configureData.name = data;
        this.url = this.getUrlBasedConfigureType(this.selectionElement);
        this.masterService.update(this.url, this.configureData).subscribe(res => {
            if (res.status === 200) {
                Swal.fire(BLANK, MASTER_UPDATE_MSG, SUCCESS);
                this.selection(this.selectionElement);
            }
        }, err => {
            Swal.fire(OOPS, MASTER_EXIST_ERROR_MSG, WARNING);
        });
    }

   saveData() {
       if (this.inputData === null || this.inputData === '') {
           Swal.fire(BLANK, MASTER_ERROR_MSG, ERROR);
           return;
       }

       this.configureData = new Configure();
       this.configureData.name = this.inputData;
       this.url = this.getUrlBasedConfigureType(this.selectionElement);
       console.log(DATA_IS + this.url);
       this.masterService.save(this.url, this.configureData).subscribe(res => {
           console.log(ASDFAF, res);
            if (res.status === 201) {
                Swal.fire(BLANK, MASTER_SUCCESS_MSG, SUCCESS);
                this.selection(this.selectionElement);
            } else {
                Swal.fire(OOPS, MASTER_ERROR_MSG, ERROR);
            }
       }, error1 => {
            Swal.fire(OOPS, MASTER_EXIST_ERROR_MSG, WARNING);
           this.inputData = '';
       });
       this.inputData = '';
   }

   private getUrlBasedConfigureType(selection: string): string {
       if (selection === LOCATION) {
           return SERVER_API_URL + API_LOCATIONS;
       } else if (selection === EMP_TYPE) {
           return SERVER_API_URL + API_EMPTYPES;
       } else if (selection === CLIENT_DOMAIN) {
           return SERVER_API_URL + CLIENT_DOMAINS;
       } else if (selection === END_CLIENT) {
           return SERVER_API_URL + API_ENDCLIENTS;
       } else if (selection === WORK_AUTHORIZATION) {
           return SERVER_API_URL +  WORK_AUTHORIZATIONS;
       } else if (selection === PRIME_VENDOR) {
           return SERVER_API_URL + API_PRIMEVENDORS;
       } else if (selection === JOB_TITLE) {
           return SERVER_API_URL + API_JOBTITLES;
       } else if (selection ===  MODE) {
           return SERVER_API_URL + API_MODES;
       } else if (selection === PAY_TYPE) {
           return SERVER_API_URL + API_PAYTYPES;
       } else if (selection === EMPLOYER) {
           return SERVER_API_URL + API_EMPLOYERS;
       } else if (selection === STATUS) {
           return SERVER_API_URL + API_STATUS;
       }
   }
}
