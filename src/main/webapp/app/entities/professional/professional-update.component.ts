import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {IProfessional, Professional} from 'app/shared/model/professional.model';
import {ProfessionalService} from './professional.service';
import {Employee, IEmployee} from 'app/shared/model/employee.model';
import {
    BASHBOARD_URL,
    BLANK,
    DATE_BIRTH_MSG,
    EMPLOYEE_SUCCESS_MSG,
    EMPLOYEE_UPDATE_MSG,
    ID,
    SERVER_API_URL,
    SUCCESS,
    UPDATE_DROP_DOWN_URL,
    WARNING
} from 'app/app.constants';
import Swal from 'sweetalert2';
import {Configure, IConfigure} from 'app/shared/model/configure.model';
import moment = require('moment');

@Component({
    selector: 'jhi-professional-update',
    templateUrl: './professional-update.component.html',
    styleUrls: ['./professional-update.component.scss']
})
export class ProfessionalUpdateComponent implements OnInit {
    professional: IProfessional;
    employee: IEmployee;
    isSaving: boolean;
    public id: any;
    dropDown: any;
    domainList: IConfigure[];
    locationList: IConfigure[];
    statusList: IConfigure[];
    endClientList: IConfigure[];
    modeList: IConfigure[];
    employerList: IConfigure[];
    primeVendorList: IConfigure[];
    workAuthorizationList: IConfigure[];
    payTypeList: IConfigure[];
    empTypeList: IConfigure[];
    jobTitleList: IConfigure[];

    // editForm not using but Dont delete because using in test
    editForm = this.fb.group({
        id: [],
        location: [null, [Validators.required]],
        totalExperience: [null, [Validators.required]],
        jobTitle: [],
        typeOfRole: [],
        skillCategory: [],
        specificSkills: [],
        generalSkills: [],
        clientDomain: [null, [Validators.required]],
        mode: [],
        employer: [null, [Validators.required]],
        primeVendor: [null, [Validators.required]],
        endClient: [null, [Validators.required]],
        currentProjectStartDate: [],
        currentProjectEndDate: [],
        remarks: [],
        createdBy: [],
        createdDate: [],
        updatedBy: [],
        updatedDate: [],
        employee: []
    });

    constructor(
        protected professionalService: ProfessionalService,
        protected activatedRoute: ActivatedRoute,
        public router: Router,
        public http: HttpClient,
        private fb: FormBuilder
    ) {
    }

    ngOnInit() {
        this.getDataFromUpdateFropDownUrl();
        this.isSaving = false;
        this.id = this.activatedRoute.snapshot.paramMap.get(ID);
        if (this.id !== undefined && this.id !== null) {
            this.professionalService.find(this.id).subscribe(res => {
                this.professional = res.body;
            });
        } else {
            this.professional = new Professional();
            this.professional.employee = new Employee();
            this.professional.employee.empType = new Configure();
            this.professional.employee.status = new Configure();
            this.professional.workAuthorization = new Configure();
            this.professional.jobTitle = new Configure();
            this.professional.location = new Configure();
            this.professional.mode = new Configure();
            this.professional.payType = new Configure();
            this.professional.clientDomain = new Configure();
            this.professional.endClient = new Configure();
            this.professional.employer = new Configure();
            this.professional.primeVendor = new Configure();

        }
    }

    // Getting Data from Dropdown from back end
    private getDataFromUpdateFropDownUrl() {
        this.http.get(SERVER_API_URL + UPDATE_DROP_DOWN_URL).subscribe(res => {
            // console.log('dropdowns  ', res);
            this.setDataFromUpdateDropDownurlResponse(res);
        });
    }

    // Data from Update Dropdown
    private setDataFromUpdateDropDownurlResponse(res) {
        this.dropDown = res;
        this.domainList = this.dropDown.domainList;
        this.locationList = this.dropDown.location;
        this.jobTitleList = this.dropDown.jobTitle;
        this.statusList = this.dropDown.status;
        this.endClientList = this.dropDown.endClient;
        this.empTypeList = this.dropDown.empType;
        this.modeList = this.dropDown.mode;
        this.employerList = this.dropDown.employer;
        this.primeVendorList = this.dropDown.primeVendor;
        this.workAuthorizationList = this.dropDown.workAuthorization;
        this.payTypeList = this.dropDown.payType;
    }

// updateForm not using but dont delete using in test
    // This method is un-used for now.
    updateForm(professional: IProfessional) {
        this.editForm.patchValue({
            id: professional.id,
            location: professional.location,
            totalExperience: professional.totalExperience,
            title: professional.jobTitle,
            typeOfRole: professional.typeOfRole,
            skillCategory: professional.skillCategory,
            specificSkills: professional.specificSkills,
            generalSkills: professional.generalSkills,
            clientDomain: professional.clientDomain,
            mode: professional.mode,
            employer: professional.employer,
            primeVendor: professional.primeVendor,
            endClient: professional.endClient,
            currentProjectStartDate: professional.currentProjectStartDate,
            currentProjectEndDate: professional.currentProjectEndDate,
            remarks: professional.remarks,
            createdBy: professional.createdBy,
            createdDate: professional.createdDate,
            updatedBy: professional.updatedBy,
            updatedDate: professional.updatedDate,
            employee: professional.employee
        });
    }

    // Back to previous page
    previousState() {
        window.history.back();
    }

    // Checking Date of Birth and saving
    save() {
        if (this.checkDob()) {
            return;
        }
        this.isSaving = true;
        if (this.professional.id !== undefined) {
            this.subscribeToEditResponse(this.professionalService.update(this.professional));
        } else {
            // console.log('create', this.professional);
            this.subscribeToSaveResponse(this.professionalService.create(this.professional));
        }
    }

    // checks Date of Birth it should not accept future date
    private checkDob() {
        if (this.professional.employee.dob !== null || this.professional.employee.dob !== undefined) {
            if (moment(this.professional.employee.dob).isAfter(moment())) {
                // alert(DATE_BIRTH_MSG);
                Swal.fire('Oops...', DATE_BIRTH_MSG, WARNING);
                return true;
            }
        }
        return false;
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IProfessional>>) {
        result.subscribe((res: HttpResponse<IProfessional>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected subscribeToEditResponse(result: Observable<HttpResponse<IProfessional>>) {
        result.subscribe((res: HttpResponse<IProfessional>) => {
            console.log('result', res);
            this.onEditSuccess(); },
        (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        // alert(EMPLOYEE_SUCCESS_MSG);
        Swal.fire(BLANK, EMPLOYEE_SUCCESS_MSG, SUCCESS);
        this.professional = new Professional();
        this.professional.employee = new Employee();
        this.isSaving = false;
        this.router.navigate([BASHBOARD_URL]);
    }

    protected onEditSuccess() {
        // alert(EMPLOYEE_UPDATE_MSG);
        Swal.fire(BLANK, EMPLOYEE_UPDATE_MSG, SUCCESS);
        this.isSaving = false;
        this.router.navigate([BASHBOARD_URL]);
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
