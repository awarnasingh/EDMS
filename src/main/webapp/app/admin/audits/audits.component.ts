import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { JhiParseLinks, JhiAlertService } from 'ng-jhipster';

import { ITEMS_PER_PAGE } from 'app/shared';
import { Audit } from './audit.model';
import { AuditsService } from './audits.service';
import { YYYY_MM_DD, ID, ASC, DESC, DATA, PAGING_PARAMS, ADMIN_AUDITS } from 'app/app.constants';

@Component({
  selector: 'jhi-audit',
  templateUrl: './audits.component.html'
})
export class AuditsComponent implements OnInit, OnDestroy {
  audits: Audit[];
  fromDate: string;
  itemsPerPage: any;
  links: any;
  page: number;
  routeData: any;
  predicate: any;
  previousPage: any;
  reverse: boolean;
  toDate: string;
  totalItems: number;
  userTransactions: any;

  constructor(
    private auditsService: AuditsService,
    private alertService: JhiAlertService,
    private parseLinks: JhiParseLinks,
    private activatedRoute: ActivatedRoute,
    private datePipe: DatePipe,
    private router: Router
  ) {
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.routeData = this.activatedRoute.data.subscribe(data => {
      this.page = data[PAGING_PARAMS].page;
      this.previousPage = data[PAGING_PARAMS].page;
      this.reverse = data[PAGING_PARAMS].ascending;
      this.predicate = data[PAGING_PARAMS].predicate;
    });
  }

  ngOnInit() {
    this.today();
    this.previousMonth();
    this.loadAll();
  }

  ngOnDestroy() {
    this.routeData.unsubscribe();
  }

  previousMonth() {
    const dateFormat = YYYY_MM_DD;
    let fromDate: Date = new Date();

    if (fromDate.getMonth() === 0) {
      fromDate = new Date(fromDate.getFullYear() - 1, 11, fromDate.getDate());
    } else {
      fromDate = new Date(fromDate.getFullYear(), fromDate.getMonth() - 1, fromDate.getDate());
    }

    this.fromDate = this.datePipe.transform(fromDate, dateFormat);
  }

  today() {
    const dateFormat = YYYY_MM_DD;
    // Today + 1 day - needed if the current day must be included
    const today: Date = new Date();
    today.setDate(today.getDate() + 1);
    const date = new Date(today.getFullYear(), today.getMonth(), today.getDate());
    this.toDate = this.datePipe.transform(date, dateFormat);
  }

  loadAll() {
    this.auditsService.find().subscribe(res => this.onSuccess(res), (res: HttpResponse<any>) => this.onError(res));
    // .query({
    //   page: this.page - 1,
    //   size: this.itemsPerPage,
    //   sort: this.sort(),
    //   fromDate: this.fromDate,
    //   toDate: this.toDate
    // })
    // .subscribe((res: HttpResponse<Audit[]>) => this.onSuccess(res.body, res.headers), (res: HttpResponse<any>) => this.onError(res.body));
  }

  sort() {
    const result = [this.predicate + ',' + (this.reverse ? ASC : DESC)];
    if (this.predicate !== ID) {
      result.push(ID);
    }
    return result;
  }

  loadPage(page: number) {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }

  transition() {
    this.router.navigate([ADMIN_AUDITS], {
      queryParams: {
        page: this.page,
        sort: this.predicate + ',' + (this.reverse ? ASC : DESC)
      }
    });
    this.loadAll();
  }

  private onSuccess(data) {
    // this.links = this.parseLinks.parse(headers.get('link'));
    //  this.totalItems = headers.get('X-Total-Count');
    console.log(DATA, data);
    this.userTransactions = data;
  }

  private onError(error) {
    this.alertService.error(error.error, error.message, null);
  }
}
