import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LocalStorageService, SessionStorageService } from 'ngx-webstorage';

import { SERVER_API_URL, AUTHENTICATION_TOKEN, API_AUTHENTICATE, RESPONSE, AUTHORIZATION, BEARER, AUTH_JWT_SERVICE_PROMISE_REJECT } from 'app/app.constants';

@Injectable({ providedIn: 'root' })
export class AuthServerProvider {
  constructor(private http: HttpClient, private $localStorage: LocalStorageService, private $sessionStorage: SessionStorageService) {}

  getToken() {
    return this.$localStorage.retrieve(AUTHENTICATION_TOKEN) || this.$sessionStorage.retrieve(AUTHENTICATION_TOKEN);
  }

  login(credentials): Observable<any> {
    const data = {
      username: credentials.username,
      password: credentials.password,
      rememberMe: credentials.rememberMe
    };
    return this.http.post(SERVER_API_URL + API_AUTHENTICATE, data, { observe: RESPONSE }).pipe(map(authenticateSuccess.bind(this)));

    function authenticateSuccess(resp) {
      const bearerToken = resp.headers.get(AUTHORIZATION);
      if (bearerToken && bearerToken.slice(0, 7) === BEARER) {
        const jwt = bearerToken.slice(7, bearerToken.length);
        this.storeAuthenticationToken(jwt, credentials.rememberMe);
        return jwt;
      }
    }
  }

  loginWithToken(jwt, rememberMe) {
    if (jwt) {
      this.storeAuthenticationToken(jwt, rememberMe);
      return Promise.resolve(jwt);
    } else {
      return Promise.reject(AUTH_JWT_SERVICE_PROMISE_REJECT); // Put appropriate error message here
    }
  }

  storeAuthenticationToken(jwt, rememberMe) {
    if (rememberMe) {
      this.$localStorage.store(AUTHENTICATION_TOKEN, jwt);
    } else {
      this.$sessionStorage.store(AUTHENTICATION_TOKEN, jwt);
    }
  }

  logout(): Observable<any> {
    return new Observable(observer => {
      this.$localStorage.clear(AUTHENTICATION_TOKEN);
      this.$sessionStorage.clear(AUTHENTICATION_TOKEN);
      observer.complete();
    });
  }
}
