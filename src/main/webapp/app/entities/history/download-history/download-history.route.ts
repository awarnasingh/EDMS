import { Route } from '@angular/router';

import { DownloadHistoryComponent } from './download-history.component';

export const downloadHistoryRoute: Route = {
  path: 'download-history',
  component: DownloadHistoryComponent,
  data: {
    pageTitle: 'Download History'
  }
};
