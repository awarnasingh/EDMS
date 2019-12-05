import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL, KEY, API_ACTIVATE } from 'app/app.constants';

@Injectable({ providedIn: 'root' })
export class ActivateService {
  constructor(private http: HttpClient) {}

  get(key: string): Observable<any> {
    return this.http.get(SERVER_API_URL + API_ACTIVATE, {
      params: new HttpParams().set(KEY, key)
    });
  }
}
