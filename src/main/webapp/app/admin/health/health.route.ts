import { Route } from '@angular/router';

import { JhiHealthCheckComponent } from './health.component';
import { HEALTH_CHECKS } from 'app/app.constants';

export const healthRoute: Route = {
  path: 'jhi-health',
  component: JhiHealthCheckComponent,
  data: {
    pageTitle: HEALTH_CHECKS
  }
};
