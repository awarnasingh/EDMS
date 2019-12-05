/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import { SearchHistoryService } from 'app/entities/search-history/search-history.service';
import { ISearchHistory, SearchHistory } from 'app/shared/model/search-history.model';

describe('Service Tests', () => {
  describe('SearchHistory Service', () => {
    let injector: TestBed;
    let service: SearchHistoryService;
    let httpMock: HttpTestingController;
    let elemDefault: ISearchHistory;
    let expectedResult;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = {};
      injector = getTestBed();
      service = injector.get(SearchHistoryService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new SearchHistory(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
        service
          .find(123)
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: elemDefault });
      });

      it('should create a SearchHistory', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        service
          .create(new SearchHistory(null))
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: expected });
      });

      it('should update a SearchHistory', async () => {
        const returnedFromService = Object.assign(
          {
            userID: 'BBBBBB',
            searchName: 'BBBBBB',
            empType: 'BBBBBB',
            domain: 'BBBBBB',
            fromExperience: 1,
            toExperience: 1,
            location: 'BBBBBB',
            status: 'BBBBBB',
            endClient: 'BBBBBB',
            skills: 'BBBBBB',
            employeeName: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);
        service
          .update(expected)
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));
        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: expected });
      });

      it('should return a list of SearchHistory', async () => {
        const returnedFromService = Object.assign(
          {
            userID: 'BBBBBB',
            searchName: 'BBBBBB',
            empType: 'BBBBBB',
            domain: 'BBBBBB',
            fromExperience: 1,
            toExperience: 1,
            location: 'BBBBBB',
            status: 'BBBBBB',
            endClient: 'BBBBBB',
            skills: 'BBBBBB',
            employeeName: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        service
          .query(expected)
          .pipe(
            take(1),
            map(resp => resp.body)
          )
          .subscribe(body => (expectedResult = body));
        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a SearchHistory', async () => {
        const rxPromise = service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
