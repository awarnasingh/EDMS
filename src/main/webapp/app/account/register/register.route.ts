import { Route } from '@angular/router';
import { RegisterComponent } from './register.component';
import { REGISTRATION } from 'app/app.constants';

export const registerRoute: Route = {
  path: 'register',
  component: RegisterComponent,
  data: {
    authorities: [],
    pageTitle: REGISTRATION
  }
};
