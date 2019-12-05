import {Component, OnInit} from '@angular/core';
import {HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {FormBuilder} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {IProfessionalHistory, ProfessionalHistory} from 'app/shared/model/professional-history.model';
import {ProfessionalHistoryService} from './professional-history.service';

@Component({
  selector: 'jhi-professional-history-update',
  templateUrl: './professional-history-update.component.html'
})
export class ProfessionalHistoryUpdateComponent implements OnInit {
  professionalHistory: IProfessionalHistory;
  isSaving: boolean;
  currentProjectStartDateDp: any;
  currentProjectEndDateDp: any;
  createdDateDp: any;
  updatedDateDp: any;

  editForm = this.fb.group({
    id: [],
    professionalId: [],
    empType: [],
    srsEmpId: [],
    fullName: [],
    firstName: [],
    lastName: [],
    education: [],
    certification: [],
    email: [],
    homePhone: [],
    mobileNumber: [],
    workPhoneNumber: [],
    dOB: [],
    status: [],
    city: [],
    location: [],
    totalExperience: [],
    jobTitle: [],
    typeOfRole: [],
    skillCategory: [],
    specificSkills: [],
    generalSkills: [],
    clientDomain: [],
    mode: [],
    employer: [],
    primeVendor: [],
    endClient: [],
    currentProjectStartDate: [],
    currentProjectEndDate: [],
    remarks: [],
    sellRate: [],
    workAuthorization: [],
    addedOn: [],
    benchAge: [],
    technology: [],
    payType: [],
    additionalNotifiers: [],
    source: [],
    workExperience: [],
    primarySkills: [],
    sellRateHelper: [],
    createdBy: [],
    createdDate: [],
    updatedBy: [],
    updatedDate: []
  });

  constructor(
    protected professionalHistoryService: ProfessionalHistoryService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ professionalHistory }) => {
      this.updateForm(professionalHistory);
      this.professionalHistory = professionalHistory;
    });
  }

  updateForm(professionalHistory: IProfessionalHistory) {
    this.editForm.patchValue({
      id: professionalHistory.id,
      professionalId: professionalHistory.professionalId,
      empType: professionalHistory.empType,
      srsEmpId: professionalHistory.srsEmpId,
      fullName: professionalHistory.fullName,
      firstName: professionalHistory.firstName,
      lastName: professionalHistory.lastName,
      education: professionalHistory.education,
      certification: professionalHistory.certification,
      email: professionalHistory.email,
      homePhone: professionalHistory.homePhone,
      mobileNumber: professionalHistory.mobileNumber,
      workPhoneNumber: professionalHistory.workPhoneNumber,
      dOB: professionalHistory.dOB,
      status: professionalHistory.status,
      city: professionalHistory.city,
      location: professionalHistory.location,
      totalExperience: professionalHistory.totalExperience,
      jobTitle: professionalHistory.jobTitle,
      typeOfRole: professionalHistory.typeOfRole,
      skillCategory: professionalHistory.skillCategory,
      specificSkills: professionalHistory.specificSkills,
      generalSkills: professionalHistory.generalSkills,
      clientDomain: professionalHistory.clientDomain,
      mode: professionalHistory.mode,
      employer: professionalHistory.employer,
      primeVendor: professionalHistory.primeVendor,
      endClient: professionalHistory.endClient,
      currentProjectStartDate: professionalHistory.currentProjectStartDate,
      currentProjectEndDate: professionalHistory.currentProjectEndDate,
      remarks: professionalHistory.remarks,
      sellRate: professionalHistory.sellRate,
      workAuthorization: professionalHistory.workAuthorization,
      addedOn: professionalHistory.addedOn,
      benchAge: professionalHistory.benchAge,
      technology: professionalHistory.technology,
      payType: professionalHistory.payType,
      additionalNotifiers: professionalHistory.additionalNotifiers,
      source: professionalHistory.source,
      workExperience: professionalHistory.workExperience,
      primarySkills: professionalHistory.primarySkills,
      sellRateHelper: professionalHistory.sellRateHelper,
      createdBy: professionalHistory.createdBy,
      createdDate: professionalHistory.createdDate,
      updatedBy: professionalHistory.updatedBy,
      updatedDate: professionalHistory.updatedDate
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const professionalHistory = this.createFromForm();
    if (professionalHistory.id !== undefined) {
      this.subscribeToSaveResponse(this.professionalHistoryService.update(professionalHistory));
    } else {
      this.subscribeToSaveResponse(this.professionalHistoryService.create(professionalHistory));
    }
  }

  private createFromForm(): IProfessionalHistory {
    return {
      ...new ProfessionalHistory(),
      id: this.editForm.get(['id']).value,
      professionalId: this.editForm.get(['professionalId']).value,
      empType: this.editForm.get(['empType']).value,
      srsEmpId: this.editForm.get(['srsEmpId']).value,
      fullName: this.editForm.get(['fullName']).value,
      firstName: this.editForm.get(['firstName']).value,
      lastName: this.editForm.get(['lastName']).value,
      education: this.editForm.get(['education']).value,
      certification: this.editForm.get(['certification']).value,
      email: this.editForm.get(['email']).value,
      homePhone: this.editForm.get(['homePhone']).value,
      mobileNumber: this.editForm.get(['mobileNumber']).value,
      workPhoneNumber: this.editForm.get(['workPhoneNumber']).value,
      dOB: this.editForm.get(['dOB']).value,
      status: this.editForm.get(['status']).value,
      city: this.editForm.get(['city']).value,
      location: this.editForm.get(['location']).value,
      totalExperience: this.editForm.get(['totalExperience']).value,
      jobTitle: this.editForm.get(['jobTitle']).value,
      typeOfRole: this.editForm.get(['typeOfRole']).value,
      skillCategory: this.editForm.get(['skillCategory']).value,
      specificSkills: this.editForm.get(['specificSkills']).value,
      generalSkills: this.editForm.get(['generalSkills']).value,
      clientDomain: this.editForm.get(['clientDomain']).value,
      mode: this.editForm.get(['mode']).value,
      employer: this.editForm.get(['employer']).value,
      primeVendor: this.editForm.get(['primeVendor']).value,
      endClient: this.editForm.get(['endClient']).value,
      currentProjectStartDate: this.editForm.get(['currentProjectStartDate']).value,
      currentProjectEndDate: this.editForm.get(['currentProjectEndDate']).value,
      remarks: this.editForm.get(['remarks']).value,
      sellRate: this.editForm.get(['sellRate']).value,
      workAuthorization: this.editForm.get(['workAuthorization']).value,
      addedOn: this.editForm.get(['addedOn']).value,
      benchAge: this.editForm.get(['benchAge']).value,
      technology: this.editForm.get(['technology']).value,
      payType: this.editForm.get(['payType']).value,
      additionalNotifiers: this.editForm.get(['additionalNotifiers']).value,
      source: this.editForm.get(['source']).value,
      workExperience: this.editForm.get(['workExperience']).value,
      primarySkills: this.editForm.get(['primarySkills']).value,
      sellRateHelper: this.editForm.get(['sellRateHelper']).value,
      createdBy: this.editForm.get(['createdBy']).value,
      createdDate: this.editForm.get(['createdDate']).value,
      updatedBy: this.editForm.get(['updatedBy']).value,
      updatedDate: this.editForm.get(['updatedDate']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IProfessionalHistory>>) {
    result.subscribe((res: HttpResponse<IProfessionalHistory>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
