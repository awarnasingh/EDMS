import {AfterViewInit, Component, ElementRef, OnInit, Renderer} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {LoginModalService} from 'app/core';
import {PasswordResetFinishService} from './password-reset-finish.service';
import {_PASSWORD, CONFIRM_PASSWORD, ERROR_, KEY, NEW_PASSWORD, OK} from 'app/app.constants';

@Component({
    selector: 'jhi-password-reset-finish',
    templateUrl: './password-reset-finish.component.html'
})
export class PasswordResetFinishComponent implements OnInit, AfterViewInit {
    doNotMatch: string;
    error: string;
    keyMissing: boolean;
    success: string;
    modalRef: NgbModalRef;
    key: string;

    passwordForm = this.fb.group({
        newPassword: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
        confirmPassword: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]]
    });

    constructor(
        private passwordResetFinishService: PasswordResetFinishService,
        private router: Router,
        private loginModalService: LoginModalService,
        private route: ActivatedRoute,
        private elementRef: ElementRef,
        private renderer: Renderer,
        private fb: FormBuilder
    ) {
    }

    ngOnInit() {
        this.route.queryParams.subscribe(params => {
            this.key = params[KEY];
        });
        this.keyMissing = !this.key;
    }

    ngAfterViewInit() {
        if (this.elementRef.nativeElement.querySelector(_PASSWORD) != null) {
            this.renderer.invokeElementMethod(this.elementRef.nativeElement.querySelector(_PASSWORD), 'focus', []);
        }
    }

    finishReset() {
        this.doNotMatch = null;
        this.error = null;
        const password = this.passwordForm.get([NEW_PASSWORD]).value;
        const confirmPassword = this.passwordForm.get([CONFIRM_PASSWORD]).value;
        if (password !== confirmPassword) {
            this.doNotMatch = ERROR_;
        } else {
            this.passwordResetFinishService.save({key: this.key, newPassword: password}).subscribe(
                () => {
                    this.success = OK;
                },
                () => {
                    this.success = null;
                    this.error = ERROR_;
                }
            );
        }
    }

    login() {
        this.router.navigate(['/']);
    }
}
