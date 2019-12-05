import { Component, OnInit, ViewChild } from '@angular/core';
import { IUser, UserService } from 'app/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { HistoryService } from '../history.service';
import {MatPaginator, MatSort, MatTableDataSource, PageEvent} from '@angular/material';

@Component({
  selector: 'jhi-download-history',
  templateUrl: './download-history.component.html',
  styleUrls: ['./download-history.component.scss']
})
export class DownloadHistoryComponent implements OnInit {
  users: IUser[];
  downloadHistoryData: any;
  showResult = false;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  constructor(private route: ActivatedRoute, private userService: UserService, private http: HttpClient, private historyService: HistoryService) { }

  ngOnInit() {
    this.userService.query().subscribe(res => {
      this.users = res.body;
    });
  }

  downloadHistroy(item) {
   this.historyService.getDownloadHistoryData(item).subscribe(res => {
    this.downloadHistoryData = res;
    if (this.downloadHistoryData.length === 0) {
      this.showResult = false;
    } else {
      this.showResult = true;
    }
   });
  }
  // Next pagination
  getNext(event: PageEvent) {
    const offset = event.pageSize * event.pageIndex;
}
}
