import { Route } from '@angular/router';

import { PasswordResetInitComponent } from './password-reset-init.component';
import { PASSWORD } from 'app/app.constants';

export const passwordResetInitRoute: Route = {
  path: 'reset/request',
  component: PasswordResetInitComponent,
  data: {
    authorities: [],
    pageTitle: PASSWORD
  }
};
