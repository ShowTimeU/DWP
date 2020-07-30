import {Institution} from "./institution";
import {User} from "./user";

export class Branch {
  branchCity: string;
  branchAddress: string;
  branchPhone: string;
  branchEmail: string;
  institutionId: number;
  userId: number;

  constructor(branchCity: string,
              branchAddress: string,
              branchPhone: string,
              branchEmail: string, institution: Institution, user: User) {
    this.branchCity = branchCity;
    this.branchAddress = branchAddress;
    this.branchPhone = branchPhone;
    this.branchEmail = branchEmail;
    this.institutionId = institution.id;
    this.userId = user.id;
  }
}
