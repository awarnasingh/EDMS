import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SearchCriteriaComponent } from './search-criteria/search-criteria.component';
import { searchState } from './';
import { EdmsSharedModule } from 'app/shared';
import { MatTableModule, MatSortModule, MatRadioModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { MatPaginatorModule } from '@angular/material/paginator';
import { AngularDraggableModule } from 'angular2-draggable';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [SearchCriteriaComponent],
  imports: [
    EdmsSharedModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatRadioModule,
    MatFormFieldModule,
    MatInputModule,
    AngularDraggableModule,
    /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    RouterModule.forChild(searchState),FontAwesomeModule
  ]
})
export class EdmsSearchModule {}
