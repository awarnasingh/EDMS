import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { AccountService } from 'app/core/auth/account.service';
import { AuthServerProvider } from 'app/core/auth/auth-jwt.service';
import { SERVER_API_URL, AUTHENTICATION_TOKEN, API_DOLOGOUT, API_SEARCH_DROPDOWN, API_STATUS_DETAILS, API_EXPORT_HISTORIES_DOWNLOAD, API_EXPORT_HISTORIES_MAIL } from 'app/app.constants';
import { Router } from '@angular/router';
import { LocalStorageService, SessionStorageService } from 'ngx-webstorage';
import { BehaviorSubject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class LoginService {
  // fors dash board to search page
  public searchTypeReq = new BehaviorSubject<string>('');
  searchTypeReqData = this.searchTypeReq.asObservable();
  public searchStatusReq = new BehaviorSubject<string>('');
  searchStatusReqData = this.searchStatusReq.asObservable();
  constructor(
    private $localStorage: LocalStorageService,
    private $sessionStorage: SessionStorageService,
    private accountService: AccountService,
    private authServerProvider: AuthServerProvider,
    protected http: HttpClient,
    protected router: Router
  ) {}

  login(credentials, callback?) {
    const cb = callback || function() {};

    return new Promise((resolve, reject) => {
      this.authServerProvider.login(credentials).subscribe(
        data => {
          this.accountService.identity(true).then(account => {
            resolve(data);
          });
          return cb();
        },
        err => {
          this.logout();
          reject(err);
          return cb(err);
        }
      );
    });
  }

  loginWithToken(jwt, rememberMe) {
    return this.authServerProvider.loginWithToken(jwt, rememberMe);
  }

  doLogout() {
    this.http.get(SERVER_API_URL + API_DOLOGOUT).subscribe();
    this.$localStorage.clear(AUTHENTICATION_TOKEN);
    this.$sessionStorage.clear(AUTHENTICATION_TOKEN);
    this.accountService.authenticate(null);
    this.router.navigate(['/']);
  }

  logout() {
    this.authServerProvider.logout().subscribe(null, null, () => this.accountService.authenticate(null));
  }

  getSearchDropDown() {
    return this.http.get(SERVER_API_URL + API_SEARCH_DROPDOWN);
  }

  // Method for Getting Employee Status Data For Dash board
  getDashboardData() {
    return this.http.get(SERVER_API_URL + API_STATUS_DETAILS);
  }

  getDownloadHistoryData(loginName) {
    return this.http.get(SERVER_API_URL + API_EXPORT_HISTORIES_DOWNLOAD + loginName);
  }

  getMailHistoryData(loginName) {
    return this.http.get(SERVER_API_URL + API_EXPORT_HISTORIES_MAIL + loginName);
  }

  public getSearchTypeReqData() {
    return this.searchTypeReqData;
  }

  public setSearchTypeReqData(data: any) {
    this.searchTypeReq.next(data);
  }

}
