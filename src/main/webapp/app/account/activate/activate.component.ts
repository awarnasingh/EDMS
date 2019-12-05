import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';

import { LoginModalService } from 'app/core';
import { ActivateService } from './activate.service';
import { KEY, OK, ERROR_ } from 'app/app.constants';

@Component({
  selector: 'jhi-activate',
  templateUrl: './activate.component.html'
})
export class ActivateComponent implements OnInit {
  error: string;
  success: string;
  modalRef: NgbModalRef;

  constructor(private activateService: ActivateService, private loginModalService: LoginModalService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.activateService.get(params[KEY]).subscribe(
        () => {
          this.error = null;
          this.success = OK;
        },
        () => {
          this.success = null;
          this.error = ERROR_;
        }
      );
    });
  }

  login() {
    this.modalRef = this.loginModalService.open();
  }
}
