import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';

import {RESPONSE, SERVER_API_URL} from 'app/app.constants';
import {createRequestOption} from 'app/shared';
import {ISearchHistory} from 'app/shared/model/search-history.model';

type EntityResponseType = HttpResponse<ISearchHistory>;
type EntityArrayResponseType = HttpResponse<ISearchHistory[]>;

@Injectable({providedIn: 'root'})
export class SearchHistoryService {

    public resourceUrl = SERVER_API_URL + 'api/search-histories';

    constructor(protected http: HttpClient) {
    }

    create(searchHistory: ISearchHistory): Observable<EntityResponseType> {
        return this.http.post<ISearchHistory>(this.resourceUrl, searchHistory, {observe: RESPONSE});
    }

    update(searchHistory: ISearchHistory): Observable<EntityResponseType> {
        return this.http.put<ISearchHistory>(this.resourceUrl, searchHistory, {observe: RESPONSE});
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ISearchHistory>(`${this.resourceUrl}/${id}`, {observe: RESPONSE});
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ISearchHistory[]>(this.resourceUrl, {params: options, observe: RESPONSE});
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, {observe: RESPONSE});
    }
}
