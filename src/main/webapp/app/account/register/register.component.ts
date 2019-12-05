import { Component, OnInit, AfterViewInit, Renderer, ElementRef } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

import { EMAIL_ALREADY_USED_TYPE, LOGIN_ALREADY_USED_TYPE } from 'app/shared';
import { LoginModalService } from 'app/core';
import { Register } from './register.service';
import { ALPHABET_NUMBER_PATTERN, LOGIN, FOCUS, LOGIN_LOWER_CASE, EMAIL_LOWER_CASE, PASSWORD_LOWER_CASE, CONFIRM_PASSWORD, ERROR_, EN } from 'app/app.constants';

@Component({
  selector: 'jhi-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit, AfterViewInit {
  doNotMatch: string;
  error: string;
  errorEmailExists: string;
  errorUserExists: string;
  success: boolean;
  modalRef: NgbModalRef;

  registerForm = this.fb.group({
    login: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(50), Validators.pattern(ALPHABET_NUMBER_PATTERN)]],
    email: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(254), Validators.email]],
    password: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
    confirmPassword: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]]
  });

  constructor(
    private loginModalService: LoginModalService,
    private registerService: Register,
    private elementRef: ElementRef,
    private renderer: Renderer,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.success = false;
  }

  ngAfterViewInit() {
    this.renderer.invokeElementMethod(this.elementRef.nativeElement.querySelector(LOGIN), FOCUS, []);
  }

  register() {
    let registerAccount = {};
    const login = this.registerForm.get([LOGIN_LOWER_CASE]).value;
    const email = this.registerForm.get([EMAIL_LOWER_CASE]).value;
    const password = this.registerForm.get([PASSWORD_LOWER_CASE]).value;
    if (password !== this.registerForm.get([CONFIRM_PASSWORD]).value) {
      this.doNotMatch = ERROR_;
    } else {
      registerAccount = { ...registerAccount, login, email, password };
      this.doNotMatch = null;
      this.error = null;
      this.errorUserExists = null;
      this.errorEmailExists = null;
      registerAccount = { ...registerAccount, langKey: EN };

      this.registerService.save(registerAccount).subscribe(
        () => {
          this.success = true;
        },
        response => this.processError(response)
      );
    }
  }

  openLogin() {
    this.modalRef = this.loginModalService.open();
  }

  private processError(response: HttpErrorResponse) {
    this.success = null;
    if (response.status === 400 && response.error.type === LOGIN_ALREADY_USED_TYPE) {
      this.errorUserExists = ERROR_;
    } else if (response.status === 400 && response.error.type === EMAIL_ALREADY_USED_TYPE) {
      this.errorEmailExists = ERROR_;
    } else {
      this.error = ERROR_;
    }
  }
}
