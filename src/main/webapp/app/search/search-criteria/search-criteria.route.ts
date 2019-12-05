import { Route } from '@angular/router';

import { SearchCriteriaComponent } from './search-criteria.component';

export const searchCriteriaRoute: Route = {
  path: 'search-criteria',
  component: SearchCriteriaComponent,
  data: {
    authorities: ['ROLE_USER'],
    pageTitle: 'Search-Criteria'
  }
};
