import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EdmsSharedModule } from 'app/shared';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {
  ProfessionalHistoryComponent,
  ProfessionalHistoryDetailComponent,
  ProfessionalHistoryUpdateComponent,
  ProfessionalHistoryDeletePopupComponent,
  ProfessionalHistoryDeleteDialogComponent,
  professionalHistoryRoute,
  professionalHistoryPopupRoute
} from './';

const ENTITY_STATES = [...professionalHistoryRoute, ...professionalHistoryPopupRoute];

@NgModule({
  imports: [EdmsSharedModule, RouterModule.forChild(ENTITY_STATES), FontAwesomeModule ],
  declarations: [
    ProfessionalHistoryComponent,
    ProfessionalHistoryDetailComponent,
    ProfessionalHistoryUpdateComponent,
    ProfessionalHistoryDeleteDialogComponent,
    ProfessionalHistoryDeletePopupComponent
  ],
  entryComponents: [
    ProfessionalHistoryComponent,
    ProfessionalHistoryUpdateComponent,
    ProfessionalHistoryDeleteDialogComponent,
    ProfessionalHistoryDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EdmsProfessionalHistoryModule {}
