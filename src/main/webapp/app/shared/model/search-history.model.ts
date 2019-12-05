export interface ISearchHistory {
  id?: number;
  userID?: string;
  searchName?: string;
  empType?: string;
  domain?: string;
  fromExperience?: number;
  toExperience?: number;
  location?: string;
  status?: string;
  endClient?: string;
  skills?: string;
  employeeName?: string;
}

export class SearchHistory implements ISearchHistory {
  constructor(
    public id?: number,
    public userID?: string,
    public searchName?: string,
    public empType?: string,
    public domain?: string,
    public fromExperience?: number,
    public toExperience?: number,
    public location?: string,
    public status?: string,
    public endClient?: string,
    public skills?: string,
    public employeeName?: string
  ) {}
}
