import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {saveAs as importedSaveAs} from 'file-saver';
import {MatPaginator, MatSort, MatTableDataSource, PageEvent} from '@angular/material';
import {Column, IColumn} from 'app/shared/model/column.model';
import {LoginService} from 'app/core';
import {IProfessional} from 'app/shared/model/professional.model';
import {ProfessionalService} from 'app/entities/professional/professional.service';
import {ISearchHistory, SearchHistory} from 'app/shared/model/search-history.model';
import {SearchHistoryService} from 'app/entities/search-history/search-history.service';
import {filter, map} from 'rxjs/operators';
import {JhiAlertService} from 'ng-jhipster';
import Swal from 'sweetalert2';
import {
    SEARCH_ERROR_MSG,
    SEARCH_INFO_MSG,
    SEARCH_SUCCESS_MSG,
    SEARCH_CRITERIA_URL,
    SLACE, BLANK, INFO, ERROR, SUCCESS
} from 'app/app.constants';
import {IConfigure} from 'app/shared/model/configure.model';

@Component({
    selector: 'jhi-search-criteria',
    templateUrl: './search-criteria.component.html',
    styleUrls: ['./search-criteria.component.scss']
})
export class SearchCriteriaComponent implements OnInit {
    // Employee List
    show: any = false;
    public status: any = null;
    public type: any = null;
    flag = true;
    professional: IProfessional;
    dropDown: any;
    domainList: IConfigure[];
    locationList: IConfigure[];
    statusList: IConfigure[];
    endClientList: IConfigure[];
    result: any;
    experience: string = null;
    location: any = null;
    domain: any = null;
    expStart = 0;
    expEnd = 100;
    skills: string = null;
    endClient: any = null;
    fullName: string = null;
    collection: any;

    errorMessage = false;
    searchResult = false;
    dataSource: MatTableDataSource<IProfessional>;
    selectedRow: any;
    totalCount: any;
    modalRef: any;
    dialogRef: any;
    PageEvent: any;
    displayedColumns = [
        'employee.id',
        'employee.fullName',
        'employee.empType',
        // 'title',
        // 'location',
        // 'totalExperience',
        // 'employee.status',
        'endClient',
        // 'specificSkills',
        // 'clientDomain',
        'layerOne',
        'layerTwo',
        'srsJoiningDate',
        'currentProjectStartDate',
        'action'
    ];
    column: IColumn;
    header: any;
    users: any;
    public rowID;

    @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
    @ViewChild(MatSort, {static: true}) sort: MatSort;
    searchHistory: any;
    searchHistoryName: any;
    searchHistories: ISearchHistory[];

    constructor(
        private loginService: LoginService,
        private professionalService: ProfessionalService,
        public modalService: NgbModal,
        public router: Router,
        protected searchHistoryService: SearchHistoryService,
        protected jhiAlertService: JhiAlertService
    ) {
    }

    ngOnInit() {
        this.loginService.searchTypeReqData.subscribe(res => {
            this.type = res;
        });

        this.loginService.searchStatusReqData.subscribe(res => {
            this.status = res;
            this.flag = false;
        });

        if (this.type !== undefined && this.type !== null && this.status !== undefined && this.status !== null) {
            this.sendResult();
        } else {
            this.storeType('all');
        }
        this.professionalService.dropDown().subscribe(res => {
            this.dropDown = res;
            this.domainList = this.dropDown.domainList;
            this.locationList = this.dropDown.location;
            this.statusList = this.dropDown.status;
            this.endClientList = this.dropDown.endClient;
        });
        this.getTableData();
        this.getSavedSearch();
    }

    // Storing Employee Domain
    storeDomain(value) {
        if (value === BLANK) {
            value = null;
        }
        this.domain = value;
    }

    // Storing Employee Location
    storeLocation(value) {
        if (value === BLANK) {
            value = null;
        }
        this.location = value;
    }

    // Storing Employee Status
    storeStatus(value) {
        if (value === BLANK) {
            value = null;
        }
        this.status = value;
    }

    // Storing Employee Experience
    storeExp(value) {
        if (value === BLANK) {
            value = null;
            this.expStart = 0;
            this.expEnd = 100;
        } else if (value === '>15') {
            this.expStart = 15;
            this.expEnd = 100;
        } else if (value !== BLANK) {
            this.experience = value;
            // tslint:disable-next-line:prefer-const
            let toArray = this.experience.split('-');
            // tslint:disable-next-line:radix
            this.expStart = parseInt(toArray[0]);
            // tslint:disable-next-line:radix
            this.expEnd = parseInt(toArray[1]);
        }
    }

    // Storing Employee Type
    storeType(value) {
        if (value === BLANK) {
            value = null;
            this.flag = true;
        }
        if (value === 'all') {
            value = null;
            this.flag = true;
        }
        this.type = value;
    }

    // Storing Employee Client
    storeClient(value) {
        if (value === BLANK) {
            value = null;
        }
        this.endClient = value;
    }

    // Storing Employee Skills
    storeSkills(value) {
        if (value === BLANK) {
            value = null;
        }
        this.skills = value;
    }

    // Send result with search data
    public sendResult() {
        if (this.type === BLANK) {
            this.type = null;
        }
        if (this.status === BLANK) {
            this.status = null;
        }
        this.result = {
            type: this.type,
            location: this.location,
            domain: this.domain,
            // tslint:disable-next-line:radix
            expStart: this.expStart,
            // tslint:disable-next-line:radix
            expEnd: this.expEnd,
            status: this.status,
            skills: this.skills,
            endClient: this.endClient,
            fullName: this.fullName
        };
        this.getTableData();
    }

    // Get searching data in table
    getTableData() {
        this.professionalService.getEmployee(this.result).subscribe(res => {
            this.collection = res;
            console.log('res............', res);
            if (this.collection.length === 0) {
                this.errorMessage = true;
            } else {
                this.errorMessage = false;
                    // this.professional = this.collection;
                this.dataSource = new MatTableDataSource(this.collection);
                setTimeout(() => this.dataSource.paginator = this.paginator);
                this.dataSource.sortingDataAccessor = (item, property) => {
                    if (property.includes('.')) {
                        return property.split('.').reduce((o, i) => o[i], item);
                    }
                    return item[property];
                };
                setTimeout(() => this.dataSource.sort = this.sort);
                if (this.dataSource.data) {
                    this.searchResult = true;
                }
                if (this.collection.length === 0) {
                    this.errorMessage = true;
                } else if (this.collection.length !== 0) {
                    this.errorMessage = false;
                    if (this.dataSource.paginator === undefined) {
                        this.dataSource.paginator = this.paginator;
                    }
                    if (this.dataSource.sort === undefined) {
                        this.dataSource.sort = this.sort;
                    }
                    if (this.paginator && this.sort) {
                        this.applyFilter(BLANK);
                    }
                }
        // tslint:disable-next-line: no-shadowed-variable
                this.dataSource.filterPredicate = (data, filter) => {
                    const dataStr =
                                    data.employee.id +
                                    data.employee.fullName +
                                    data.employee.empType +
                                    // data.jobTitle +
                                    // data.location +
                                    // data.totalExperience +
                                    // data.employee.status +
                                    // data.endClient +
                                    // data.generalSkills +
                                    data.layerOne +
                                    data.layerTwo +
                                    data.srsJoiningDate +
                                    data.currentProjectStartDate +
                                    data.clientDomain;
                    const tableData = dataStr.trim().toLowerCase();
                    return tableData.indexOf(filter) !== -1;
                };
            }
        });
    }

    // Resetting Employee Skill
    resetSkillsValue() {
        this.skills = '';
        this.sendResult();
    }

    // Resetting Employee Name
    resetEmpNameValue() {
        this.fullName = '';
        this.sendResult();
    }

    // Filtering the employee list in the table
    applyFilter(filterValue: string) {
        this.dataSource.filter = filterValue.trim().toLowerCase();

        if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
        }
    }

    // Modal for the row
    selectRow(templateRef, row) {
        this.rowID = row['id'];
        this.dialogRef = this.modalService.open(templateRef);
    }

    close() {
        this.dialogRef.close();
    }

    // Modal for Download Excel file
    exportExcel(excelColums) {
        this.column = new Column();
        this.selectAllOrNot(true);

        this.dialogRef = this.modalService.open(excelColums);
    }

    // Download Excel in the modal
    downloadExcel() {
        this.professionalService.exportasExcel(this.result, this.column).subscribe(blob => {
            importedSaveAs(blob, 'EmployeeSearchResults.xlsx');
        });
        this.close();
        this.router.navigate([SLACE, SEARCH_CRITERIA_URL]);
    }

    // Export excel file from email
    exportMail(excelMailColums) {
        this.column = new Column();
        this.selectAllOrNot(true);
        this.dialogRef = this.modalService.open(excelMailColums);
    }

    // Select the fields in the download modal
    selectAllOrNot(isSelect: boolean) {
        this.column.id = this.column.empType = this.column.totalExperience = this.column.specificSkills = this.column.generalSkills = this.column.fullName = this.column.email = this.column.contactNo = this.column.status = this.column.mode = isSelect;
        this.column.location = this.column.jobTitle = this.column.typeOfRole = this.column.clientDomain = this.column.mode = this.column.employer = this.column.srsEmpId = this.column.primeVendor = this.column.endClient = this.column.currentProjectEndDate = this.column.currentProjectStartDate = this.column.firstName = this.column.lastName = this.column.education = this.column.certification = this.column.remarks = this.column.skillCategory = isSelect;
        this.column.homePhone = this.column.workPhoneNumber = this.column.mobileNumber = this.column.dob = this.column.addedOn = this.column.addtionalNotifiers = this.column.jobTitle = this.column.source = this.column.primarySkills = this.column.benchAge = this.column.technology = this.column.layerOne = this.column.layerTwo = this.column.srsJoiningDate = this.column.workExperience = isSelect;
    }

    // export excel from mail in the modal
    exportExcelMail() {
        this.professionalService.exportMail(this.result, this.column); // .subscribe();
        this.close();
        this.router.navigate([SLACE, SEARCH_CRITERIA_URL]);
    }

    // Resetting selecting values
    reset() {
        this.storeType(null);
        this.storeClient(null);
        this.storeLocation(null);
        this.storeSkills(null);
        this.storeStatus(null);
        this.storeExp(BLANK);
        this.storeDomain(null);
        this.sendResult();
    }

    // showing saved search popup
    shows() {
        if (this.show) {
            this.show = false;
        } else {
            this.show = true;
        }
        this.getSavedSearch();
    }

    getSavedSearch() {
        this.searchHistoryService
            .query()
            .pipe(
                filter((res: HttpResponse<ISearchHistory[]>) => res.ok),
                map((res: HttpResponse<ISearchHistory[]>) => res.body)
            )
            .subscribe(
                (res: ISearchHistory[]) => {
                    this.searchHistories = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    // showing column popup
    nameSearch(index) {
        this.storeType(index.empType);
        this.storeClient(index.endClient);
        this.storeLocation(index.location);
        this.storeSkills(index.skills);
        this.storeStatus(index.status);
        this.expStart = index.fromExperience;
        this.expEnd = index.toExperience;
        this.storeDomain(index.domain);
        this.sendResult();
        this.show = false;
    }

    // Next pagination
    getNext(event: PageEvent) {
        const offset = event.pageSize * event.pageIndex;
    }

    // Saving Search
    saveSearchForFuture(searchNameSavePopUp) {
        this.searchHistory = new SearchHistory();
        this.dialogRef = this.modalService.open(searchNameSavePopUp);
    }

    // Saving Search Names using Modal
    saveSearchHistory() {
        if (this.type === BLANK) {
            this.type = null;
        }
        if (this.status === BLANK) {
            this.status = null;
        }
        this.searchHistory.empType = this.type;
        this.searchHistory.location = this.location;
        this.searchHistory.domain = this.domain;
        this.searchHistory.fromExperience = this.expStart;
        this.searchHistory.toExperience = this.expEnd;
        this.searchHistory.searchName = this.searchHistoryName;
        this.searchHistory.status = this.status;
        this.searchHistory.skills = this.skills;
        this.searchHistory.endClient = this.endClient;
        this.searchHistory.employeeName = this.fullName;
        this.searchHistoryService.create(this.searchHistory).subscribe(
            data => {
                // alert('Search saved ...!');
                Swal.fire(BLANK, SEARCH_SUCCESS_MSG, SUCCESS);
                this.close();
            },
            err => {
                if (err.status === 409) {
                    Swal.fire('Ohoo..', SEARCH_INFO_MSG, INFO);
                    // alert('Search Name already used... please use other name');
                } else {
                    // alert('Somthing went wrong...!');
                    Swal.fire('Oops..', SEARCH_ERROR_MSG, ERROR);
                }
            }
        );
    }

}
