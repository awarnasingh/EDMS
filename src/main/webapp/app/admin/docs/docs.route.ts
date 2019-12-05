import { Route } from '@angular/router';

import { JhiDocsComponent } from './docs.component';
import { API } from 'app/app.constants';

export const docsRoute: Route = {
  path: 'docs',
  component: JhiDocsComponent,
  data: {
    pageTitle: API
  }
};
