import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EdmsSharedModule } from 'app/shared';
import {
  ProfessionalComponent,
  ProfessionalDetailComponent,
  ProfessionalUpdateComponent,
  ProfessionalDeletePopupComponent,
  ProfessionalDeleteDialogComponent,
  professionalRoute,
  professionalPopupRoute
} from './';
import {MatCardModule, MatDatepickerModule, MatFormFieldModule} from '@angular/material';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

const ENTITY_STATES = [...professionalRoute, ...professionalPopupRoute];

@NgModule({
    imports: [EdmsSharedModule, RouterModule.forChild(ENTITY_STATES), MatDatepickerModule, MatFormFieldModule, MatCardModule, FontAwesomeModule],
  declarations: [
    ProfessionalComponent,
    ProfessionalDetailComponent,
    ProfessionalUpdateComponent,
    ProfessionalDeleteDialogComponent,
    ProfessionalDeletePopupComponent,
    ],
  entryComponents: [
    ProfessionalComponent,
    ProfessionalUpdateComponent,
    ProfessionalDeleteDialogComponent,
    ProfessionalDeletePopupComponent,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EdmsProfessionalModule {}
