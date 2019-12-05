import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { SettingsComponent } from './settings.component';
import { ROLE_USER, SETTINGS } from 'app/app.constants';

export const settingsRoute: Route = {
  path: 'settings',
  component: SettingsComponent,
  data: {
    authorities: [ROLE_USER],
    pageTitle: SETTINGS
  },
  canActivate: [UserRouteAccessService]
};
