import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import * as moment from 'moment';
import {DATE_FORMAT} from 'app/shared/constants/input.constants';
import {map} from 'rxjs/operators';
import {
    DOWNLOAD_EXCEL_URL,
    MAIL_API_URL, PROFESSIONAL_API_URL,
    REPORT_SEND_SUCCESSFULLY_MSG,
    RESPONSE,
    SEARCH_API_URL,
    SERVER_API_URL,
    STATUS_400,
    UNABLE_SEND_REPORT_MSG, UPDATE_DROP_DOWN_URL
} from 'app/app.constants';
import {createRequestOption} from 'app/shared';
import {IProfessional} from 'app/shared/model/professional.model';

type EntityResponseType = HttpResponse<IProfessional>;
type EntityArrayResponseType = HttpResponse<IProfessional[]>;

@Injectable({providedIn: 'root'})
export class ProfessionalService {
    public resourceUrl = SERVER_API_URL + PROFESSIONAL_API_URL;

    constructor(protected http: HttpClient) {
    }

    create(professional: IProfessional): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(professional);
        return this.http
            .post<IProfessional>(this.resourceUrl, copy, {observe: RESPONSE})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(professional: IProfessional): Observable<EntityResponseType> {
         const copy = this.convertDateFromClient(professional);
        // cpd  = (professional.currentProjectStartDate).toString;
        return this.http
            .put<IProfessional>(this.resourceUrl, copy, {observe: RESPONSE})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IProfessional>(`${this.resourceUrl}/${id}`, {observe: RESPONSE})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IProfessional[]>(this.resourceUrl, {params: options, observe: RESPONSE})
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, {observe: RESPONSE});
    }

    protected convertDateFromClient(professional: IProfessional): IProfessional {
        const copy: IProfessional = Object.assign({}, professional, {
            currentProjectStartDate:
                professional.currentProjectStartDate != null && moment(professional.currentProjectStartDate).isValid()
                    ? moment(professional.currentProjectStartDate).format(DATE_FORMAT)
                    : null,
            currentProjectEndDate:
                professional.currentProjectEndDate != null && moment(professional.currentProjectEndDate).isValid()
                    ? moment(professional.currentProjectEndDate).format(DATE_FORMAT)
                    : null,
            createdDate:
                professional.createdDate != null && moment(professional.createdDate).isValid() ? moment(professional.createdDate).format(DATE_FORMAT) : null,
            updatedDate:
                professional.updatedDate != null && moment(professional.updatedDate).isValid() ? moment(professional.updatedDate).format(DATE_FORMAT) : null
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.currentProjectStartDate = res.body.currentProjectStartDate != null ? res.body.currentProjectStartDate : null;
            res.body.currentProjectEndDate = res.body.currentProjectEndDate != null ? res.body.currentProjectEndDate : null;
            res.body.createdDate = res.body.createdDate != null ? res.body.createdDate : null;
            res.body.updatedDate = res.body.updatedDate != null ? res.body.updatedDate : null;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((professional: IProfessional) => {
                professional.currentProjectStartDate =
                    professional.currentProjectStartDate != null ? moment(professional.currentProjectStartDate) : null;
                professional.currentProjectEndDate = professional.currentProjectEndDate != null ? moment(professional.currentProjectEndDate) : null;
                professional.createdDate = professional.createdDate != null ? moment(professional.createdDate) : null;
                professional.updatedDate = professional.updatedDate != null ? moment(professional.updatedDate) : null;
            });
        }
        return res;
    }

    dropDown() {
        return this.http.get(SERVER_API_URL + UPDATE_DROP_DOWN_URL);
    }

    getEmployee(result) {
        return this.http.post(SERVER_API_URL + SEARCH_API_URL, result);
    }

    // Method for Generating Searched Employee Details To Excel
    exportasExcel(requestObject, columns) {
        // tslint:disable-next-line:prefer-const
        let object = {};
        object['searchVm'] = requestObject;
        object['colunm'] = columns;
        return this.http.post(SERVER_API_URL + DOWNLOAD_EXCEL_URL, object, {
            responseType: 'blob' as 'json'
        });
    }

    // Method for Generating Searched Employee Details To Gmail
    exportMail(requestObject, columns) {
        // tslint:disable-next-line:prefer-const
        let Robject = {};
        Robject['searchVm'] = requestObject;
        Robject['colunm'] = columns;
        return this.http
            .post(SERVER_API_URL + MAIL_API_URL, Robject, {
                responseType: 'blob' as 'json'
            })
            .subscribe(
                (result: any) => {
                    alert(REPORT_SEND_SUCCESSFULLY_MSG);
                },
                error => {
                    if (error.status === STATUS_400) {
                        alert(UNABLE_SEND_REPORT_MSG);
                    }
                }
            );
    }
}
