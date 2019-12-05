import {Route} from '@angular/router';

import {DashboardComponent} from './dashboard.component';
import {UserRouteAccessService} from 'app/core';
import {DASHBOARD, ROLE_USER} from 'app/app.constants';

export const DASHBOARD_ROUTE: Route = {
    path: DASHBOARD,
    component: DashboardComponent,
    data: {
        authorities: [ROLE_USER],
        pageTitle: DASHBOARD
    },
    canActivate: [UserRouteAccessService]
};
