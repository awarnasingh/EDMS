import { Route } from '@angular/router';

import { PasswordResetFinishComponent } from './password-reset-finish.component';
import { PASSWORD } from 'app/app.constants';

export const passwordResetFinishRoute: Route = {
  path: 'reset/finish',
  component: PasswordResetFinishComponent,
  data: {
    authorities: [],
    pageTitle: PASSWORD
  }
};
