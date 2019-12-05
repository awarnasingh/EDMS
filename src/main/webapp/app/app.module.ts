import './vendor.ts';

import {NgModule} from '@angular/core';
import {NgbDatepickerConfig} from '@ng-bootstrap/ng-bootstrap';
import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {NgxWebstorageModule} from 'ngx-webstorage';
import {NgJhipsterModule} from 'ng-jhipster';

import {AuthInterceptor} from './blocks/interceptor/auth.interceptor';
import {AuthExpiredInterceptor} from './blocks/interceptor/auth-expired.interceptor';
import {ErrorHandlerInterceptor} from './blocks/interceptor/errorhandler.interceptor';
import {NotificationInterceptor} from './blocks/interceptor/notification.interceptor';
import {EdmsSharedModule} from 'app/shared';
import {EdmsCoreModule} from 'app/core';
import {EdmsAppRoutingModule} from './app-routing.module';
import {EdmsHomeModule} from './home/home.module';
import {EdmsAccountModule} from './account/account.module';
import {EdmsEntityModule} from './entities/entity.module';
import {EdmsSearchModule} from './search/search.module';
import * as moment from 'moment';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import {ErrorComponent, FooterComponent, JhiMainComponent, NavbarComponent, PageRibbonComponent} from './layouts';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material';
import {SearchCriteriaComponent} from './search/search-criteria/search-criteria.component';
import {MatDialogModule, MatFormFieldModule, MatSortModule} from '@angular/material';

export const ALERT_TIME_OUT = 5000;
export const ALERT_TOAST = false;

@NgModule({
    imports: [
        BrowserModule,
        NgxWebstorageModule.forRoot({prefix: 'jhi', separator: '-'}),
        NgJhipsterModule.forRoot({
            // set below to true to make alerts look like toast
            alertAsToast: ALERT_TOAST,
            alertTimeout: ALERT_TIME_OUT
        }),
        EdmsSharedModule.forRoot(),
        EdmsCoreModule,
        EdmsHomeModule,
        EdmsAccountModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
        EdmsEntityModule,
        EdmsSearchModule,
        EdmsAppRoutingModule,
        BrowserAnimationsModule,
        MaterialModule,
        MatDialogModule,
        MatFormFieldModule,
        MatSortModule
    ],
    declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
    entryComponents: [SearchCriteriaComponent],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthExpiredInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorHandlerInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: NotificationInterceptor,
            multi: true
        }
    ],
    bootstrap: [JhiMainComponent]
})
export class EdmsAppModule {
    constructor(private dpConfig: NgbDatepickerConfig) {
        this.dpConfig.minDate = {year: moment().year() - 100, month: 1, day: 1};
    }
}
