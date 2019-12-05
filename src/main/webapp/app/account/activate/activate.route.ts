import { Route } from '@angular/router';

import { ActivateComponent } from './activate.component';
import { ACTIVATION } from 'app/app.constants';

export const activateRoute: Route = {
  path: 'activate',
  component: ActivateComponent,
  data: {
    authorities: [],
    pageTitle: ACTIVATION
  }
};
