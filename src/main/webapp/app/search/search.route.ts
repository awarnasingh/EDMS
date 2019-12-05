import { Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { searchCriteriaRoute } from './search-criteria/search-criteria.route';

const SEARCH_ROUTES = [searchCriteriaRoute];

export const searchState: Routes = [
  {
    path: '',
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Search'
    },
    canActivate: [UserRouteAccessService],
    children: SEARCH_ROUTES
  }
];
