import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {IConfigure} from 'app/shared/model/configure.model';
import {RESPONSE} from 'app/app.constants';
import {Observable} from 'rxjs';

type EntityResponseType = HttpResponse<IConfigure>;
type EntityArrayResponseType = HttpResponse<IConfigure>;

@Injectable({
    providedIn: 'root'
})
export class MastersService {

    constructor(protected http: HttpClient) {
    }

    save(url: string, configure: IConfigure): Observable<EntityResponseType> {
        return this.http.post<IConfigure>(url, configure, {observe: RESPONSE});
    }

    update(url: string, configure: IConfigure): Observable<EntityResponseType> {
        return this.http.put<IConfigure>(url, configure, {observe: RESPONSE});
    }

    find(url: string, id: number): Observable<EntityResponseType> {
        return this.http.get<IConfigure>(`${url}/${id}`, {observe: RESPONSE});
    }

    query(url: string): Observable<HttpResponse<IConfigure[]>> {
        const options = null;
        return this.http.get<IConfigure[]>(url, {params: options, observe: RESPONSE});
    }

    delete(url: string, id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${url}/${id}`, {observe: RESPONSE});
    }

}
