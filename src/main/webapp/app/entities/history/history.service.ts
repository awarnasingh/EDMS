import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SERVER_API_URL } from 'app/app.constants';

@Injectable({ providedIn: 'root' })
export class HistoryService {

  constructor( protected http: HttpClient ) {}

  getDownloadHistoryData(loginName) {
    return this.http.get(SERVER_API_URL + 'api/export-histories/download/' + loginName);
  }

  getMailHistoryData(loginName) {
    return this.http.get(SERVER_API_URL + 'api/export-histories/mail/' + loginName);
  }

}
