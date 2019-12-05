import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IProfessionalHistory } from 'app/shared/model/professional-history.model';

@Component({
  selector: 'jhi-professional-history-detail',
  templateUrl: './professional-history-detail.component.html'
})
export class ProfessionalHistoryDetailComponent implements OnInit {
  professionalHistory: IProfessionalHistory;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ professionalHistory }) => {
      this.professionalHistory = professionalHistory;
    });
  }

  previousState() {
    window.history.back();
  }
}
