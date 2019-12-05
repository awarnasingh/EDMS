/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { Observable, of } from 'rxjs';

import { EdmsTestModule } from '../../../test.module';
import { SearchHistoryUpdateComponent } from 'app/entities/search-history/search-history-update.component';
import { SearchHistoryService } from 'app/entities/search-history/search-history.service';
import { SearchHistory } from 'app/shared/model/search-history.model';

describe('Component Tests', () => {
  describe('SearchHistory Management Update Component', () => {
    let comp: SearchHistoryUpdateComponent;
    let fixture: ComponentFixture<SearchHistoryUpdateComponent>;
    let service: SearchHistoryService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EdmsTestModule],
        declarations: [SearchHistoryUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(SearchHistoryUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(SearchHistoryUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(SearchHistoryService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new SearchHistory(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new SearchHistory();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
