import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';
import {ActivatedRoute, Router} from '@angular/router';

import { IProfessionalHistory } from 'app/shared/model/professional-history.model';
import { AccountService } from 'app/core';
import { ProfessionalHistoryService } from './professional-history.service';
import {ID, PROFESSIONAL_HISTORY_LIST_MODIFICATION} from 'app/app.constants';

@Component({
  selector: 'jhi-professional-history',
  templateUrl: './professional-history.component.html',
  styleUrls: ['./professional-history.component.scss']
})
export class ProfessionalHistoryComponent implements OnInit, OnDestroy {
  professionalHistories: IProfessionalHistory;
  currentAccount: any;
  eventSubscriber: Subscription;
  public id: any;
  errorMessage: any;
  constructor(
    protected professionalHistoryService: ProfessionalHistoryService,
    protected jhiAlertService: JhiAlertService,
    protected eventManager: JhiEventManager,
    protected accountService: AccountService,
    protected activatedRoute: ActivatedRoute,

  ) {}

  loadAll() {
    this.professionalHistoryService.findbyPid(this.id).subscribe
        (res => {
          if (res.body[0] !== undefined) {
            this.errorMessage = false;
            this.professionalHistories = res.body;
          } else {
            this.errorMessage = true;
          }
        });
  }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.paramMap.get(ID);

    this.loadAll();
    this.accountService.identity().then(account => {
      this.currentAccount = account;
    });
    this.registerChangeInProfessionalHistories();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: IProfessionalHistory) {
    return item.id;
  }

  registerChangeInProfessionalHistories() {
    this.eventSubscriber = this.eventManager.subscribe(PROFESSIONAL_HISTORY_LIST_MODIFICATION, response => this.loadAll());
  }

  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}
