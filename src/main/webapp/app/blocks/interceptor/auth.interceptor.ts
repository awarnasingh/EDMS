import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LocalStorageService, SessionStorageService } from 'ngx-webstorage';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';

import { SERVER_API_URL, AUTHENTICATION_TOKEN, BEARER } from 'app/app.constants';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private localStorage: LocalStorageService, private sessionStorage: SessionStorageService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (!request || !request.url || (/^http/.test(request.url) && !(SERVER_API_URL && request.url.startsWith(SERVER_API_URL)))) {
      return next.handle(request);
    }

    const token = this.localStorage.retrieve(AUTHENTICATION_TOKEN) || this.sessionStorage.retrieve(AUTHENTICATION_TOKEN);
    if (!!token) {
      request = request.clone({
        setHeaders: {
          Authorization: BEARER + token
        }
      });
    }
    return next.handle(request);
  }
}
