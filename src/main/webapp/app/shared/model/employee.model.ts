import {Moment} from 'moment';
import {IConfigure} from "app/shared/model/configure.model";

export interface IEmployee {
    dob?: Moment;
    id?: number;
    empType?: IConfigure;
    srsEmpId?: string;
    fullName?: string;
    firstName?: string;
    lastName?: string;
    education?: string;
    certification?: string;
    email?: string;
    // contactNo?: string;
    status?: IConfigure;
    createdBy?: string;
    createdDate?: Moment;
    updatedBy?: string;
    updatedDate?: Moment;
    // newly added fields
    homePhone?: string;
    mobileNumber?: string;
    workPhoneNumber?: string;
}

export class Employee implements IEmployee {
    constructor(
        public id?: number,
        public empType?: IConfigure,
        public srsEmpId?: string,
        public fullName?: string,
        public firstName?: string,
        public lastName?: string,
        public education?: string,
        public certification?: string,
        public email?: string,
        // public contactNo?: string,
        public status?: IConfigure,
        public createdBy?: string,
        public createdDate?: Moment,
        public updatedBy?: string,
        public updatedDate?: Moment,
        // added
        public homePhone?: string,
        public mobileNumber?: string,
        public workPhoneNumber?: string,
        public dob?: Moment
    ) {
    }
}
