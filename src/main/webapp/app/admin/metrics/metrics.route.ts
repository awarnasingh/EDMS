import { Route } from '@angular/router';

import { JhiMetricsMonitoringComponent } from './metrics.component';
import { APPLICATION_METRICS } from 'app/app.constants';

export const metricsRoute: Route = {
  path: 'jhi-metrics',
  component: JhiMetricsMonitoringComponent,
  data: {
    pageTitle: APPLICATION_METRICS
  }
};
