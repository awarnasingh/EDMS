/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { EdmsTestModule } from '../../../test.module';
import { SearchHistoryDeleteDialogComponent } from 'app/entities/search-history/search-history-delete-dialog.component';
import { SearchHistoryService } from 'app/entities/search-history/search-history.service';

describe('Component Tests', () => {
  describe('SearchHistory Management Delete Component', () => {
    let comp: SearchHistoryDeleteDialogComponent;
    let fixture: ComponentFixture<SearchHistoryDeleteDialogComponent>;
    let service: SearchHistoryService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EdmsTestModule],
        declarations: [SearchHistoryDeleteDialogComponent]
      })
        .overrideTemplate(SearchHistoryDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(SearchHistoryDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(SearchHistoryService);
      mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
      mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});
