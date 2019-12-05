import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

export const PROFESSIONAL = 'professional';
export const SEARCH_HISTORY = 'search-history';
export const PRFESSIONAL_HISTORY = 'professional-history';
export const HISTORY = 'history';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: PROFESSIONAL,
                loadChildren: './professional/professional.module#EdmsProfessionalModule'
            },
            {
                path: SEARCH_HISTORY,
                loadChildren: './search-history/search-history.module#EdmsSearchHistoryModule'
            },
            {
                path: PRFESSIONAL_HISTORY,
                loadChildren: './professional-history/professional-history.module#EdmsProfessionalHistoryModule'
            },
            {
                path: HISTORY,
                loadChildren: './history/history.module#EdmsHistoryModule'
            }

            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EdmsEntityModule {
}
