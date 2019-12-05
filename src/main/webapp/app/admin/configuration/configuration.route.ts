import { Route } from '@angular/router';

import { JhiConfigurationComponent } from './configuration.component';
import { CONFIGURATION } from 'app/app.constants';

export const configurationRoute: Route = {
  path: 'jhi-configuration',
  component: JhiConfigurationComponent,
  data: {
    pageTitle: CONFIGURATION
  }
};
