import { Routes } from '@angular/router';

import { auditsRoute, configurationRoute, docsRoute, healthRoute, logsRoute, metricsRoute, userMgmtRoute } from './';

import { UserRouteAccessService } from 'app/core';
import {mastersRoute} from "app/admin/masters/masters.route";
import {ROLE_ADMIN} from "app/app.constants";

const ADMIN_ROUTES = [auditsRoute, configurationRoute, docsRoute, healthRoute, logsRoute, ...userMgmtRoute, metricsRoute, mastersRoute];

export const adminState: Routes = [
  {
    path: '',
    data: {
      authorities: [ROLE_ADMIN]
    },
    canActivate: [UserRouteAccessService],
    children: ADMIN_ROUTES
  }
];
