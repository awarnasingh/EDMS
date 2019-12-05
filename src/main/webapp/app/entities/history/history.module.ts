import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DownloadHistoryComponent } from './download-history/download-history.component';
import { MailHistoryComponent } from './mail-history/mail-history.component';
import { RouterModule } from '@angular/router';
import { historyState } from './history.route';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';


@NgModule({
  declarations: [DownloadHistoryComponent, MailHistoryComponent],
  imports: [
    CommonModule,
    Ng2SearchPipeModule,
    FormsModule,
    RouterModule.forChild(historyState),
    MatPaginatorModule,
    FontAwesomeModule
  ]
})
export class EdmsHistoryModule { }
