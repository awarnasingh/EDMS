import {Injectable} from '@angular/core';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes} from '@angular/router';
import {UserRouteAccessService} from 'app/core';
import {Observable, of} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {ISearchHistory, SearchHistory} from 'app/shared/model/search-history.model';
import {SearchHistoryService} from './search-history.service';
import {SearchHistoryComponent} from './search-history.component';
import {SearchHistoryDetailComponent} from './search-history-detail.component';
import {SearchHistoryUpdateComponent} from './search-history-update.component';
import {SearchHistoryDeletePopupComponent} from './search-history-delete-dialog.component';
import {
    BLANK,
    DELETE_BY_ID_URL,
    EDIT_BY_ID_URL,
    ID,
    NEW_URL,
    POPUP,
    ROLE_USER,
    SEARCH_HISTORIES,
    VIEW_BY_ID_URL
} from 'app/app.constants';

@Injectable({providedIn: 'root'})
export class SearchHistoryResolve implements Resolve<ISearchHistory> {
    constructor(private service: SearchHistoryService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ISearchHistory> {
        const id = route.params[ID] ? route.params[ID] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<SearchHistory>) => response.ok),
                map((searchHistory: HttpResponse<SearchHistory>) => searchHistory.body)
            );
        }
        return of(new SearchHistory());
    }
}

export const searchHistoryRoute: Routes = [
    {
        path: BLANK,
        component: SearchHistoryComponent,
        data: {
            authorities: [ROLE_USER],
            pageTitle: SEARCH_HISTORIES
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: VIEW_BY_ID_URL,
        component: SearchHistoryDetailComponent,
        resolve: {
            searchHistory: SearchHistoryResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: SEARCH_HISTORIES
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: NEW_URL,
        component: SearchHistoryUpdateComponent,
        resolve: {
            searchHistory: SearchHistoryResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: SEARCH_HISTORIES
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: EDIT_BY_ID_URL,
        component: SearchHistoryUpdateComponent,
        resolve: {
            searchHistory: SearchHistoryResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: SEARCH_HISTORIES
        },
        canActivate: [UserRouteAccessService]
    }
];

export const searchHistoryPopupRoute: Routes = [
    {
        path: DELETE_BY_ID_URL,
        component: SearchHistoryDeletePopupComponent,
        resolve: {
            searchHistory: SearchHistoryResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: SEARCH_HISTORIES
        },
        canActivate: [UserRouteAccessService],
        outlet: POPUP
    }
];
