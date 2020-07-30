import {Institution} from "./institution";
import {User} from "./user";

export class Branch {
  id: number;
  branchCity: string;
  branchAddress: string;
  branchPhone: string;
  branchEmail: string;
  institutionId: number;
  userId: number;

  constructor(id: number,
              branchCity: string,
              branchAddress: string,
              branchPhone: string,
              branchEmail: string, institution: Institution, user: User) {
    this.id = id;
    this.branchCity = branchCity;
    this.branchAddress = branchAddress;
    this.branchPhone = branchPhone;
    this.branchEmail = branchEmail;
    this.institutionId = institution.id;
    this.userId = user.id;
  }
}
