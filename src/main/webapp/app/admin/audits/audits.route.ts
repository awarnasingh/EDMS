import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Route } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';

import { AuditsComponent } from './audits.component';
import { AUDITS, AUDIT_EVENTDATE_DESC } from 'app/app.constants';

export const auditsRoute: Route = {
  path: 'audits',
  component: AuditsComponent,
  resolve: {
    pagingParams: JhiResolvePagingParams
  },
  data: {
    pageTitle: AUDITS,
    defaultSort: AUDIT_EVENTDATE_DESC
  }
};
