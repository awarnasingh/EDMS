import {Moment} from 'moment';
import {IEmployee} from 'app/shared/model/employee.model';
import {IConfigure} from 'app/shared/model/configure.model';

export interface IProfessional {
    id?: number;
    location?: IConfigure; // state
    totalExperience?: number;
    typeOfRole?: string;
    skillCategory?: string;
    specificSkills?: string;
    generalSkills?: string;
    clientDomain?: IConfigure;
    mode?: IConfigure;
    employer?: IConfigure;
    primeVendor?: IConfigure;
    endClient?: IConfigure;
    currentProjectStartDate?: Moment;
    currentProjectEndDate?: Moment;
    remarks?: string;
    createdBy?: string;
    createdDate?: Moment;
    updatedBy?: string;
    updatedDate?: Moment;
    employee?: IEmployee;
    // newly added fields
    sellRate?: string;
    workAuthorization?: IConfigure;
    city?: string;
    jobTitle?: IConfigure;
    addedOn?: Moment;   // Please change this field data type as string ............ whetre evere ur using in ui.
    benchAge?: string;
    technology?: string;
    payType?: IConfigure;
    additionalNotifiers?: string;
    source?: string;
    workExperience?: string;
    primarySkills?: string;
    sellRateHelper?: string;
    layerOne?: string;
    layerTwo?: string;
    srsJoiningDate?: Moment;
}

export class Professional implements IProfessional {
    constructor(
        public id?: number,
        public location?: IConfigure,
        public totalExperience?: number,
        public typeOfRole?: string,
        public skillCategory?: string,
        public specificSkills?: string,
        public generalSkills?: string,
        public clientDomain?: IConfigure,
        public mode?: IConfigure,
        public employer?: IConfigure,
        public primeVendor?: IConfigure,
        public endClient?: IConfigure,
        public currentProjectStartDate?: Moment,
        public currentProjectEndDate?: Moment,
        public remarks?: string,
        public createdBy?: string,
        public createdDate?: Moment,
        public updatedBy?: string,
        public updatedDate?: Moment,
        public employee?: IEmployee,
        // added
        public sellRate?: string,
        public workAuthorization?: IConfigure,
        public city?: string,
        public jobTitle?: IConfigure,
        public addedOn?: Moment,
        public benchAge?: string,
        public technology?: string,
        public payType?: IConfigure,
        public additionalNotifiers?: string,
        public source?: string,
        public workExperience?: string,
        public primarySkills?: string,
        public sellRateHelper?: string,
        public layerOne?: string,
        public layerTwo?: string,
        public srsJoiningDate?: Moment
    ) {
    }
}
