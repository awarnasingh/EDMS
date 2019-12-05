import {Injectable} from '@angular/core';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes} from '@angular/router';
import {UserRouteAccessService} from 'app/core';
import {Observable, of} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {IProfessionalHistory, ProfessionalHistory} from 'app/shared/model/professional-history.model';
import {ProfessionalHistoryService} from './professional-history.service';
import {ProfessionalHistoryComponent} from './professional-history.component';
import {ProfessionalHistoryDetailComponent} from './professional-history-detail.component';
import {ProfessionalHistoryDeletePopupComponent} from './professional-history-delete-dialog.component';
import {
    DELETE_BY_ID_URL,
    ID,
    ID_URL,
    POPUP,
    PROFESSIONAL_HISTORIES,
    ROLE_ADMIN,
    ROLE_USER,
    VIEW_BY_ID_URL
} from 'app/app.constants';

@Injectable({providedIn: 'root'})
export class ProfessionalHistoryResolve implements Resolve<IProfessionalHistory> {
    constructor(private service: ProfessionalHistoryService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IProfessionalHistory> {
        const id = route.params[ID] ? route.params[ID] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<ProfessionalHistory>) => response.ok),
                map((professionalHistory: HttpResponse<ProfessionalHistory>) => professionalHistory.body)
            );
        }
        return of(new ProfessionalHistory());
    }
}

export const professionalHistoryRoute: Routes = [
    {
        path: ID_URL,
        component: ProfessionalHistoryComponent,
        data: {
            authorities: [ROLE_ADMIN],
            pageTitle: PROFESSIONAL_HISTORIES
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: VIEW_BY_ID_URL,
        component: ProfessionalHistoryDetailComponent,
        resolve: {
            professionalHistory: ProfessionalHistoryResolve
        },
        data: {
            authorities: [ROLE_ADMIN],
            pageTitle: PROFESSIONAL_HISTORIES
        },
        canActivate: [UserRouteAccessService]
    }
    // ,
    // {
    //   path: 'new',
    //   component: ProfessionalHistoryUpdateComponent,
    //   resolve: {
    //     professionalHistory: ProfessionalHistoryResolve
    //   },
    //   data: {
    //     authorities: ['ROLE_USER'],
    //     pageTitle: 'ProfessionalHistories'
    //   },
    //   canActivate: [UserRouteAccessService]
    // },
    // {
    //   path: ':id/edit',
    //   component: ProfessionalHistoryUpdateComponent,
    //   resolve: {
    //     professionalHistory: ProfessionalHistoryResolve
    //   },
    //   data: {
    //     authorities: ['ROLE_USER'],
    //     pageTitle: 'ProfessionalHistories'
    //   },
    //   canActivate: [UserRouteAccessService]
    // }
];

export const professionalHistoryPopupRoute: Routes = [
    {
        path: DELETE_BY_ID_URL,
        component: ProfessionalHistoryDeletePopupComponent,
        resolve: {
            professionalHistory: ProfessionalHistoryResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: PROFESSIONAL_HISTORIES
        },
        canActivate: [UserRouteAccessService],
        outlet: POPUP
    }
];
