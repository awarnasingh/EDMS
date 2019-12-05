import { Route } from '@angular/router';

import { LogsComponent } from './logs.component';
import { LOGS } from 'app/app.constants';

export const logsRoute: Route = {
  path: 'logs',
  component: LogsComponent,
  data: {
    pageTitle: LOGS
  }
};
