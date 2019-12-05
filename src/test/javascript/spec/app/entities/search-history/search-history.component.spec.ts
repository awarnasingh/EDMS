/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { EdmsTestModule } from '../../../test.module';
import { SearchHistoryComponent } from 'app/entities/search-history/search-history.component';
import { SearchHistoryService } from 'app/entities/search-history/search-history.service';
import { SearchHistory } from 'app/shared/model/search-history.model';

describe('Component Tests', () => {
  describe('SearchHistory Management Component', () => {
    let comp: SearchHistoryComponent;
    let fixture: ComponentFixture<SearchHistoryComponent>;
    let service: SearchHistoryService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EdmsTestModule],
        declarations: [SearchHistoryComponent],
        providers: []
      })
        .overrideTemplate(SearchHistoryComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(SearchHistoryComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(SearchHistoryService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new SearchHistory(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.searchHistories[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
