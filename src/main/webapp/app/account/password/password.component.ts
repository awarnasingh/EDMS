import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AccountService } from 'app/core';
import { PasswordService } from './password.service';
import { NEW_PASSWORD, CONFIRM_PASSWORD, ERROR_, CURRENT_PASSWORD, OK } from 'app/app.constants';

@Component({
  selector: 'jhi-password',
  templateUrl: './password.component.html'
})
export class PasswordComponent implements OnInit {
  doNotMatch: string;
  error: string;
  success: string;
  account: any;
  passwordForm = this.fb.group({
    currentPassword: ['', [Validators.required]],
    newPassword: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
    confirmPassword: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]]
  });

  constructor(private passwordService: PasswordService, private accountService: AccountService, private fb: FormBuilder) {}

  ngOnInit() {
    this.accountService.identity().then(account => {
      this.account = account;
    });
  }

  changePassword() {
    const newPassword = this.passwordForm.get([NEW_PASSWORD]).value;
    if (newPassword !== this.passwordForm.get([CONFIRM_PASSWORD]).value) {
      this.error = null;
      this.success = null;
      this.doNotMatch = ERROR_;
    } else {
      this.doNotMatch = null;
      this.passwordService.save(newPassword, this.passwordForm.get([CURRENT_PASSWORD]).value).subscribe(
        () => {
          this.error = null;
          this.success = OK;
        },
        () => {
          this.success = null;
          this.error = ERROR_;
        }
      );
    }
  }
}
