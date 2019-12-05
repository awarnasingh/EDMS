import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EdmsSharedModule } from 'app/shared';
import {
  SearchHistoryComponent,
  SearchHistoryDetailComponent,
  SearchHistoryUpdateComponent,
  SearchHistoryDeletePopupComponent,
  SearchHistoryDeleteDialogComponent,
  searchHistoryRoute,
  searchHistoryPopupRoute
} from './';

const ENTITY_STATES = [...searchHistoryRoute, ...searchHistoryPopupRoute];

@NgModule({
  imports: [EdmsSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    SearchHistoryComponent,
    SearchHistoryDetailComponent,
    SearchHistoryUpdateComponent,
    SearchHistoryDeleteDialogComponent,
    SearchHistoryDeletePopupComponent
  ],
  entryComponents: [
    SearchHistoryComponent,
    SearchHistoryUpdateComponent,
    SearchHistoryDeleteDialogComponent,
    SearchHistoryDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EdmsSearchHistoryModule {}
