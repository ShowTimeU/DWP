import {Institution} from "./institution";
import {Branch} from "./branch";

export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  phone: string;
  institution: Institution;
  branch: Branch;
  token?: string;
  role?: string;
}
