import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { createRequestOption } from 'app/shared';
import { SERVER_API_URL, FROM_DATE, TO_DATE, RESPONSE, MANAGEMENT_AUDITS, MANAGEMENT_USERTRANS } from 'app/app.constants';
import { Audit } from './audit.model';

@Injectable({ providedIn: 'root' })
export class AuditsService {
  constructor(private http: HttpClient) {}

  query(req: any): Observable<HttpResponse<Audit[]>> {
    const params: HttpParams = createRequestOption(req);
    params.set(FROM_DATE, req.fromDate);
    params.set(TO_DATE, req.toDate);

    const requestURL = SERVER_API_URL + MANAGEMENT_AUDITS;

    return this.http.get<Audit[]>(requestURL, {
      params,
      observe: RESPONSE
    });
  }

  find() {
    return this.http.get(SERVER_API_URL + MANAGEMENT_USERTRANS);
  }
}
