import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core';
import { PasswordComponent } from './password.component';
import { ROLE_USER, PASSWORD } from 'app/app.constants';

export const passwordRoute: Route = {
  path: 'password',
  component: PasswordComponent,
  data: {
    authorities: [ROLE_USER],
    pageTitle: PASSWORD
  },
  canActivate: [UserRouteAccessService]
};
