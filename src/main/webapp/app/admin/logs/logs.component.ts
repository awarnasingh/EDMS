import { Component, OnInit } from '@angular/core';

import { Log } from './log.model';
import { LogsService } from './logs.service';
import { NAME, EFFECTIVE_LEVEL } from 'app/app.constants';

@Component({
  selector: 'jhi-logs',
  templateUrl: './logs.component.html'
})
export class LogsComponent implements OnInit {
  loggers: Log[];
  filter: string;
  orderProp: string;
  reverse: boolean;

  constructor(private logsService: LogsService) {
    this.filter = '';
    this.orderProp = NAME;
    this.reverse = false;
  }

  ngOnInit() {
    this.logsService.findAll().subscribe(response => this.extractLoggers(response));
  }

  changeLevel(name: string, level: string) {
    this.logsService.changeLevel(name, level).subscribe(() => {
      this.logsService.findAll().subscribe(response => this.extractLoggers(response));
    });
  }

  private extractLoggers(response) {
    this.loggers = Object.entries(response.body.loggers).map(e => new Log(e[0], e[1][EFFECTIVE_LEVEL]));
  }
}
