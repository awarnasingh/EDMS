import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {NgbActiveModal, NgbModal, NgbModalOptions, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {JhiEventManager} from 'ng-jhipster';

import {IProfessionalHistory} from 'app/shared/model/professional-history.model';
import {ProfessionalHistoryService} from './professional-history.service';
import {
    CANCEL,
    DELETED_PROFESSIONAL_HISTORY,
    PROFESSIONAL_HISTORY_LIST_MODIFICATION,
    PROFESSIONAL_HISTORY_URL,
    SIZE_LG,
    STATIC_STRING
} from 'app/app.constants';

@Component({
    selector: 'jhi-professional-history-delete-dialog',
    templateUrl: './professional-history-delete-dialog.component.html'
})
export class ProfessionalHistoryDeleteDialogComponent {
    professionalHistory: IProfessionalHistory;

    constructor(
        protected professionalHistoryService: ProfessionalHistoryService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss(CANCEL);
    }

    confirmDelete(id: number) {
        this.professionalHistoryService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: PROFESSIONAL_HISTORY_LIST_MODIFICATION,
                content: DELETED_PROFESSIONAL_HISTORY
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-professional-history-delete-popup',
    template: ''
})
export class ProfessionalHistoryDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    optionForProfessionalDelDialogComponent: NgbModalOptions = {size: SIZE_LG, backdrop: STATIC_STRING};

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {
    }

    ngOnInit() {
        this.activatedRoute.data.subscribe(({professionalHistory}) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(ProfessionalHistoryDeleteDialogComponent as Component, this.optionForProfessionalDelDialogComponent);
                this.ngbModalRef.componentInstance.professionalHistory = professionalHistory;
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
        this.router.navigate([PROFESSIONAL_HISTORY_URL, {outlets: {popup: null}}]);
        this.ngbModalRef = null;
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
