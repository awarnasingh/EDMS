import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EdmsSharedModule } from 'app/shared';
import { HOME_ROUTE, HomeComponent } from './';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DASHBOARD_ROUTE } from './dashboard/dashboard.route';
import { ChartModule } from 'angular-highcharts';

@NgModule({
  imports: [EdmsSharedModule, RouterModule.forChild([HOME_ROUTE, DASHBOARD_ROUTE]), ChartModule],
  declarations: [HomeComponent, DashboardComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EdmsHomeModule {}
