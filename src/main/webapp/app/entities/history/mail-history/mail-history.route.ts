import { Route } from '@angular/router';

import { MailHistoryComponent } from './mail-history.component';

export const mailHistoryRoute: Route = {
  path: 'mail-history',
  component: MailHistoryComponent,
  data: {
    pageTitle: 'Mail History'
  }
};
