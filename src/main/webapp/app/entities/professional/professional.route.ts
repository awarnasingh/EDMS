import {Injectable} from '@angular/core';
import {HttpResponse} from '@angular/common/http';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes} from '@angular/router';
import {UserRouteAccessService} from 'app/core';
import {Observable, of} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {IProfessional, Professional} from 'app/shared/model/professional.model';
import {ProfessionalService} from './professional.service';
import {ProfessionalComponent} from './professional.component';
import {ProfessionalDetailComponent} from './professional-detail.component';
import {ProfessionalUpdateComponent} from './professional-update.component';
import {ProfessionalDeletePopupComponent} from './professional-delete-dialog.component';
import {
    BLANK,
    DELETE_BY_ID_URL,
    EDIT_BY_ID_URL,
    ID,
    NEW_URL,
    PROFESSIONALS,
    ROLE_USER,
    VIEW_BY_ID_URL
} from 'app/app.constants';

@Injectable({providedIn: 'root'})
export class ProfessionalResolve implements Resolve<IProfessional> {
    constructor(private service: ProfessionalService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IProfessional> {
        const id = route.params[ID] ? route.params[ID] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Professional>) => response.ok),
                map((professional: HttpResponse<Professional>) => professional.body)
            );
        }
        return of(new Professional());
    }
}

export const professionalRoute: Routes = [
    {
        path: BLANK,
        component: ProfessionalComponent,
        data: {
            authorities: [ROLE_USER],
            pageTitle: PROFESSIONALS
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: VIEW_BY_ID_URL,
        component: ProfessionalDetailComponent,
        resolve: {
            professional: ProfessionalResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: PROFESSIONALS
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: NEW_URL,
        component: ProfessionalUpdateComponent,
        resolve: {
            professional: ProfessionalResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: PROFESSIONALS
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: EDIT_BY_ID_URL,
        component: ProfessionalUpdateComponent,
        resolve: {
            professional: ProfessionalResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: PROFESSIONALS
        },
        canActivate: [UserRouteAccessService]
    }
];

export const professionalPopupRoute: Routes = [
    {
        path: DELETE_BY_ID_URL,
        component: ProfessionalDeletePopupComponent,
        resolve: {
            professional: ProfessionalResolve
        },
        data: {
            authorities: [ROLE_USER],
            pageTitle: PROFESSIONALS
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
