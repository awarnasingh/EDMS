import { Component, OnInit } from '@angular/core';
import { IUser, UserService } from 'app/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { HistoryService } from '../history.service';

@Component({
  selector: 'jhi-mail-history',
  templateUrl: './mail-history.component.html',
  styleUrls: ['./mail-history.component.scss']
})
export class MailHistoryComponent implements OnInit {

  users: IUser[];
  mailHistoryData: any;
  showResult = false;
  constructor(private route: ActivatedRoute, private userService: UserService, private http: HttpClient, private historyService: HistoryService) { }

  ngOnInit() {
    this.userService.query().subscribe(res => {
      this.users = res.body;
    });
  }

  mailHistroy(item) {
    this.historyService.getMailHistoryData(item).subscribe(res => {
     this.mailHistoryData = res;
     if (this.mailHistoryData.length === 0) {
      this.showResult = false;
    } else {
      this.showResult = true;
    }
    });
   }

}
