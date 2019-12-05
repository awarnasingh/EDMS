import { Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { downloadHistoryRoute } from './download-history/download-history.route';
import { mailHistoryRoute } from './mail-history/mail-history.route';

const HISTORY_ROUTES = [downloadHistoryRoute, mailHistoryRoute ];

export const historyState: Routes = [
  {
    path: '',
    data: {
      authorities: ['ROLE_ADMIN'],
      pageTitle: 'History'
    },
    canActivate: [UserRouteAccessService],
    children: HISTORY_ROUTES
  }
];
