/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { EdmsTestModule } from '../../../test.module';
import { SearchHistoryDetailComponent } from 'app/entities/search-history/search-history-detail.component';
import { SearchHistory } from 'app/shared/model/search-history.model';

describe('Component Tests', () => {
  describe('SearchHistory Management Detail Component', () => {
    let comp: SearchHistoryDetailComponent;
    let fixture: ComponentFixture<SearchHistoryDetailComponent>;
    const route = ({ data: of({ searchHistory: new SearchHistory(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EdmsTestModule],
        declarations: [SearchHistoryDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(SearchHistoryDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(SearchHistoryDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.searchHistory).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
