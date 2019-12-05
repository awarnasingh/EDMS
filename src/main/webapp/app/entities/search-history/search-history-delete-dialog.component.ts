import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {NgbActiveModal, NgbModal, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {JhiEventManager} from 'ng-jhipster';

import {ISearchHistory} from 'app/shared/model/search-history.model';
import {SearchHistoryService} from './search-history.service';
import {
    CANCEL,
    DELETED_SEARCH_HISTORY,
    SEARCH_HISTORY_LIST_MODIFICATION,
    SEARCH_HISTORY_URL,
    SIZE_LG,
    STATIC_STRING
} from 'app/app.constants';

@Component({
    selector: 'jhi-search-history-delete-dialog',
    templateUrl: './search-history-delete-dialog.component.html'
})
export class SearchHistoryDeleteDialogComponent {
    searchHistory: ISearchHistory;

    constructor(
        protected searchHistoryService: SearchHistoryService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss(CANCEL);
    }

    confirmDelete(id: number) {
        this.searchHistoryService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: SEARCH_HISTORY_LIST_MODIFICATION,
                content: DELETED_SEARCH_HISTORY
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-search-history-delete-popup',
    template: ''
})
export class SearchHistoryDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {
    }

    ngOnInit() {
        this.activatedRoute.data.subscribe(({searchHistory}) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(SearchHistoryDeleteDialogComponent as Component, {
                    size: SIZE_LG,
                    backdrop: STATIC_STRING
                });
                this.ngbModalRef.componentInstance.searchHistory = searchHistory;
                this.ngbModalRef.result.then(
                    result => {
                        this.navigationBasedOnResponse();
                    },
                    reason => {
                        this.navigationBasedOnResponse();
                    }
                );
            }, 0);
        });
    }

    private navigationBasedOnResponse() {
        this.router.navigate([SEARCH_HISTORY_URL, {outlets: {popup: null}}]);
        this.ngbModalRef = null;
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
