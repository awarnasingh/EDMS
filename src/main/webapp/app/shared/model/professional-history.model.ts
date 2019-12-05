import { Moment } from 'moment';

export interface IProfessionalHistory {
  id?: number;
  professionalId?: number;
  empType?: string;
  srsEmpId?: string;
  fullName?: string;
  firstName?: string;
  lastName?: string;
  education?: string;
  certification?: string;
  email?: string;
  homePhone?: string;
  mobileNumber?: string;
  workPhoneNumber?: string;
  dOB?: string;
  status?: string;
  city?: string;
  location?: string;
  totalExperience?: number;
  jobTitle?: string;
  typeOfRole?: string;
  skillCategory?: string;
  specificSkills?: string;
  generalSkills?: string;
  clientDomain?: string;
  mode?: string;
  employer?: string;
  primeVendor?: string;
  endClient?: string;
  currentProjectStartDate?: Moment;
  currentProjectEndDate?: Moment;
  remarks?: string;
  sellRate?: string;
  workAuthorization?: string;
  addedOn?: string;
  benchAge?: string;
  technology?: string;
  payType?: string;
  additionalNotifiers?: string;
  source?: string;
  workExperience?: string;
  primarySkills?: string;
  sellRateHelper?: number;
  createdBy?: string;
  createdDate?: Moment;
  updatedBy?: string;
  updatedDate?: Moment;
}

export class ProfessionalHistory implements IProfessionalHistory {
  constructor(
    public id?: number,
    public professionalId?: number,
    public empType?: string,
    public srsEmpId?: string,
    public fullName?: string,
    public firstName?: string,
    public lastName?: string,
    public education?: string,
    public certification?: string,
    public email?: string,
    public homePhone?: string,
    public mobileNumber?: string,
    public workPhoneNumber?: string,
    public dOB?: string,
    public status?: string,
    public city?: string,
    public location?: string,
    public totalExperience?: number,
    public jobTitle?: string,
    public typeOfRole?: string,
    public skillCategory?: string,
    public specificSkills?: string,
    public generalSkills?: string,
    public clientDomain?: string,
    public mode?: string,
    public employer?: string,
    public primeVendor?: string,
    public endClient?: string,
    public currentProjectStartDate?: Moment,
    public currentProjectEndDate?: Moment,
    public remarks?: string,
    public sellRate?: string,
    public workAuthorization?: string,
    public addedOn?: string,
    public benchAge?: string,
    public technology?: string,
    public payType?: string,
    public additionalNotifiers?: string,
    public source?: string,
    public workExperience?: string,
    public primarySkills?: string,
    public sellRateHelper?: number,
    public createdBy?: string,
    public createdDate?: Moment,
    public updatedBy?: string,
    public updatedDate?: Moment
  ) {}
}
