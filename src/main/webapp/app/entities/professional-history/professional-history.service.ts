import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import * as moment from 'moment';
import {DATE_FORMAT} from 'app/shared/constants/input.constants';
import {map} from 'rxjs/operators';

import {
    API_PROFESSIONAL_HISTORIES_BY_PID_URL,
    API_PROFESSIONAL_HISTORIES_URL,
    RESPONSE,
    SERVER_API_URL
} from 'app/app.constants';
import {createRequestOption} from 'app/shared';
import {IProfessionalHistory} from 'app/shared/model/professional-history.model';

type EntityResponseType = HttpResponse<IProfessionalHistory>;
type EntityArrayResponseType = HttpResponse<IProfessionalHistory[]>;

@Injectable({providedIn: 'root'})
export class ProfessionalHistoryService {
    public resourceUrl = SERVER_API_URL + API_PROFESSIONAL_HISTORIES_URL;
    public resourceUrlHistory = SERVER_API_URL + API_PROFESSIONAL_HISTORIES_BY_PID_URL;

    constructor(protected http: HttpClient) {
    }

    create(professionalHistory: IProfessionalHistory): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(professionalHistory);
        return this.http
            .post<IProfessionalHistory>(this.resourceUrl, copy, {observe: RESPONSE})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(professionalHistory: IProfessionalHistory): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(professionalHistory);
        return this.http
            .put<IProfessionalHistory>(this.resourceUrl, copy, {observe: RESPONSE})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IProfessionalHistory>(`${this.resourceUrl}/${id}`, {observe: RESPONSE})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    findbyPid(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IProfessionalHistory>(`${this.resourceUrlHistory}/${id}`, {observe: RESPONSE})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IProfessionalHistory[]>(this.resourceUrl, {params: options, observe: RESPONSE})
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, {observe: RESPONSE});
    }

    protected convertDateFromClient(professionalHistory: IProfessionalHistory): IProfessionalHistory {
        const copy: IProfessionalHistory = Object.assign({}, professionalHistory, {
            currentProjectStartDate:
                professionalHistory.currentProjectStartDate != null && professionalHistory.currentProjectStartDate.isValid()
                    ? professionalHistory.currentProjectStartDate.format(DATE_FORMAT)
                    : null,
            currentProjectEndDate:
                professionalHistory.currentProjectEndDate != null && professionalHistory.currentProjectEndDate.isValid()
                    ? professionalHistory.currentProjectEndDate.format(DATE_FORMAT)
                    : null,
            createdDate:
                professionalHistory.createdDate != null && professionalHistory.createdDate.isValid()
                    ? professionalHistory.createdDate.format(DATE_FORMAT)
                    : null,
            updatedDate:
                professionalHistory.updatedDate != null && professionalHistory.updatedDate.isValid()
                    ? professionalHistory.updatedDate.format(DATE_FORMAT)
                    : null
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.currentProjectStartDate = res.body.currentProjectStartDate != null ? moment(res.body.currentProjectStartDate) : null;
            res.body.currentProjectEndDate = res.body.currentProjectEndDate != null ? moment(res.body.currentProjectEndDate) : null;
            res.body.createdDate = res.body.createdDate != null ? moment(res.body.createdDate) : null;
            res.body.updatedDate = res.body.updatedDate != null ? moment(res.body.updatedDate) : null;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((professionalHistory: IProfessionalHistory) => {
                professionalHistory.currentProjectStartDate =
                    professionalHistory.currentProjectStartDate != null ? moment(professionalHistory.currentProjectStartDate) : null;
                professionalHistory.currentProjectEndDate =
                    professionalHistory.currentProjectEndDate != null ? moment(professionalHistory.currentProjectEndDate) : null;
                professionalHistory.createdDate = professionalHistory.createdDate != null ? moment(professionalHistory.createdDate) : null;
                professionalHistory.updatedDate = professionalHistory.updatedDate != null ? moment(professionalHistory.updatedDate) : null;
            });
        }
        return res;
    }
}
