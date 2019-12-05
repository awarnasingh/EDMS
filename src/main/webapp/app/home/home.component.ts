import {Component, OnInit} from '@angular/core';
import {JhiEventManager} from 'ng-jhipster';

import {Account, AccountService, LoginModalService} from 'app/core';
import {Router} from '@angular/router';
import {LoginService} from 'app/core/login/login.service';
import {StateStorageService} from 'app/core/auth/state-storage.service';
import {
    AUTHENTICATION_SUCCESS,
    BLANK,
    DASHBOARD_URL,
    REGISTER_URL,
    REQUEST_URL,
    REST,
    SEND_AUTH_SUCCESS
} from 'app/app.constants';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
    authenticationError: boolean;

    username: String;
    password: String;
    account: Account;

    constructor(
        private accountService: AccountService,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private loginService: LoginService,
        private stateStorageService: StateStorageService,
        private router: Router,
    ) {
    }

    ngOnInit() {
        this.accountService.identity().then((account: Account) => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
    }

    // If Registeration is success
    registerAuthenticationSuccess() {
        this.eventManager.subscribe(AUTHENTICATION_SUCCESS, message => {
            this.accountService.identity().then(account => {
                this.account = account;
            });
        });
    }

    cancel() {
        this.authenticationError = false;
        this.username = '';
        this.password = '';
    }

    // login
    login() {
        this.loginService
            .login(this.getCrendiential())
            .then(() => {
                this.authenticationError = false;
                this.navigationBasedOnCreditial();
                this.eventManager.broadcast(this.getEvent());
                // previousState was set in the authExpiredInterceptor before being redirected to login modal.
                // since login is successful, go to stored previousState and clear previousState
                const redirect = this.stateStorageService.getUrl();
                this.redirectToLogin(redirect);
            })
            .catch(() => {
                this.setDataBasedOnError();
            });
    }

    // Error based on credential
    private setDataBasedOnError() {
        this.authenticationError = true;
        this.username = BLANK;
        this.password = BLANK;
    }

    private redirectToLogin(redirect) {
        if (redirect) {
            this.stateStorageService.storeUrl(null);
            this.router.navigateByUrl(redirect);
        }
    }

    private getEvent() {
        return {
            name: AUTHENTICATION_SUCCESS,
            content: SEND_AUTH_SUCCESS
        };
    }

    // Navigate to dashboard after login
    private navigationBasedOnCreditial() {
        this.router.navigate([DASHBOARD_URL]);
        if (this.router.url === REGISTER_URL || /^\/activate\//.test(this.router.url) || /^\/reset\//.test(this.router.url)) {
            this.router.navigate(['']);
        }
    }

    // Getting credential for login
    private getCrendiential() {
        return {
            username: this.username,
            password: this.password,
            rememberMe: true
        };
    }

    // Navigate to register page
    register() {
        this.router.navigate([REGISTER_URL]);
    }

    // Request Reset Password
    requestResetPassword() {
        this.router.navigate([REST, REQUEST_URL]);
    }
}
