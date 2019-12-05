import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AccountService } from 'app/core';
import { Account } from 'app/core/user/account.model';
import { EN, OK, ERROR_, FIRST_NAME, LAST_NAME, EMAIL_LOWER_CASE, ACTIVATED, AUTHORITIES, LANG_KEY, LOGIN_LOWER_CASE, IMAGE_URL } from 'app/app.constants';

@Component({
  selector: 'jhi-settings',
  templateUrl: './settings.component.html'
})
export class SettingsComponent implements OnInit {
  error: string;
  success: string;
  languages: any[];
  settingsForm = this.fb.group({
    firstName: [undefined, [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    lastName: [undefined, [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    email: [undefined, [Validators.required, Validators.minLength(5), Validators.maxLength(254), Validators.email]],
    activated: [false],
    authorities: [[]],
    langKey: [EN],
    login: [],
    imageUrl: []
  });

  constructor(private accountService: AccountService, private fb: FormBuilder) {}

  ngOnInit() {
    this.accountService.identity().then(account => {
      this.updateForm(account);
    });
  }

  save() {
    const settingsAccount = this.accountFromForm();
    this.accountService.save(settingsAccount).subscribe(
      () => {
        this.error = null;
        this.success = OK;
        this.accountService.identity(true).then(account => {
          this.updateForm(account);
        });
      },
      () => {
        this.success = null;
        this.error = ERROR_;
      }
    );
  }

  private accountFromForm(): any {
    const account = {};
    return {
      ...account,
      firstName: this.settingsForm.get(FIRST_NAME).value,
      lastName: this.settingsForm.get(LAST_NAME).value,
      email: this.settingsForm.get(EMAIL_LOWER_CASE).value,
      activated: this.settingsForm.get(ACTIVATED).value,
      authorities: this.settingsForm.get(AUTHORITIES).value,
      langKey: this.settingsForm.get(LANG_KEY).value,
      login: this.settingsForm.get(LOGIN_LOWER_CASE).value,
      imageUrl: this.settingsForm.get(IMAGE_URL).value
    };
  }

  updateForm(account: any): void {
    this.settingsForm.patchValue({
      firstName: account.firstName,
      lastName: account.lastName,
      email: account.email,
      activated: account.activated,
      authorities: account.authorities,
      langKey: account.langKey,
      login: account.login,
      imageUrl: account.imageUrl
    });
  }
}
