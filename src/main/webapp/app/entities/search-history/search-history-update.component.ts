import {Component, OnInit} from '@angular/core';
import {HttpResponse, HttpErrorResponse} from '@angular/common/http';
import {FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {ISearchHistory, SearchHistory} from 'app/shared/model/search-history.model';
import {SearchHistoryService} from './search-history.service';

export const ID = 'id';
export const USER_ID = 'userID';
export const SEARCH_NAME = 'searchName';
export const EMP_TYPE = 'empType';
export const DOMAIN = 'domain';
export const FROM_EXPERIENCE = 'fromExperience';
export const TO_EXPERIENCE = 'toExperience';
export const LOCATION = 'location';
export const STATUS = 'status';
export const END_CLIENT = 'endClient';
export const SKILLS = 'skills';
export const EMPLOYEE_NAME = 'employeeName';

@Component({
    selector: 'jhi-search-history-update',
    templateUrl: './search-history-update.component.html'
})
export class SearchHistoryUpdateComponent implements OnInit {
    searchHistory: ISearchHistory;
    isSaving: boolean;

    editForm = this.fb.group({
        id: [],
        userID: [],
        searchName: [null, []],
        empType: [],
        domain: [],
        fromExperience: [],
        toExperience: [],
        location: [],
        status: [],
        endClient: [],
        skills: [],
        employeeName: []
    });

    constructor(protected searchHistoryService: SearchHistoryService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({searchHistory}) => {
            this.updateForm(searchHistory);
            this.searchHistory = searchHistory;
        });
    }

    updateForm(searchHistory: ISearchHistory) {
        this.editForm.patchValue({
            id: searchHistory.id,
            userID: searchHistory.userID,
            searchName: searchHistory.searchName,
            empType: searchHistory.empType,
            domain: searchHistory.domain,
            fromExperience: searchHistory.fromExperience,
            toExperience: searchHistory.toExperience,
            location: searchHistory.location,
            status: searchHistory.status,
            endClient: searchHistory.endClient,
            skills: searchHistory.skills,
            employeeName: searchHistory.employeeName
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        const searchHistory = this.createFromForm();
        if (searchHistory.id !== undefined) {
            this.subscribeToSaveResponse(this.searchHistoryService.update(searchHistory));
        } else {
            this.subscribeToSaveResponse(this.searchHistoryService.create(searchHistory));
        }
    }

    private createFromForm(): ISearchHistory {
        const entity = {
            ...new SearchHistory(),
            id: this.editForm.get([ID]).value,
            userID: this.editForm.get([USER_ID]).value,
            searchName: this.editForm.get([SEARCH_NAME]).value,
            empType: this.editForm.get([EMP_TYPE]).value,
            domain: this.editForm.get([DOMAIN]).value,
            fromExperience: this.editForm.get([FROM_EXPERIENCE]).value,
            toExperience: this.editForm.get([TO_EXPERIENCE]).value,
            location: this.editForm.get([LOCATION]).value,
            status: this.editForm.get([STATUS]).value,
            endClient: this.editForm.get([END_CLIENT]).value,
            skills: this.editForm.get([SKILLS]).value,
            employeeName: this.editForm.get([EMPLOYEE_NAME]).value
        };
        return entity;
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ISearchHistory>>) {
        result.subscribe((res: HttpResponse<ISearchHistory>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
