import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {JhiAlertService, JhiEventManager} from 'ng-jhipster';

import {ISearchHistory} from 'app/shared/model/search-history.model';
import {AccountService} from 'app/core';
import {SearchHistoryService} from './search-history.service';
import {SEARCH_HISTORY_LIST_MODIFICATION} from 'app/app.constants';

@Component({
    selector: 'jhi-search-history',
    templateUrl: './search-history.component.html'
})
export class SearchHistoryComponent implements OnInit, OnDestroy {
    searchHistories: ISearchHistory[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected searchHistoryService: SearchHistoryService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {
    }

    loadAll() {
        this.searchHistoryService
            .query()
            .pipe(
                filter((res: HttpResponse<ISearchHistory[]>) => res.ok),
                map((res: HttpResponse<ISearchHistory[]>) => res.body)
            )
            .subscribe(
                (res: ISearchHistory[]) => {
                    this.searchHistories = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInSearchHistories();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ISearchHistory) {
        return item.id;
    }

    registerChangeInSearchHistories() {
        this.eventSubscriber = this.eventManager.subscribe(SEARCH_HISTORY_LIST_MODIFICATION, response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
