import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ISearchHistory } from 'app/shared/model/search-history.model';

@Component({
  selector: 'jhi-search-history-detail',
  templateUrl: './search-history-detail.component.html'
})
export class SearchHistoryDetailComponent implements OnInit {
  searchHistory: ISearchHistory;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ searchHistory }) => {
      this.searchHistory = searchHistory;
    });
  }

  previousState() {
    window.history.back();
  }
}
