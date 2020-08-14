import {Injectable} from '@angular/core';
import {User} from "../-Models-/user";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {AuthenticationService} from "./authentication.service";
import {Observable} from "rxjs";
import {Institution} from "../-Models-/institution";
import {Branch} from "../-Models-/branch";

@Injectable({
  providedIn: 'root'
})
export class InstitutionService {

  private urlInstitution = 'http://localhost:8080/institution';
  private urlBranch = 'http://localhost:8080/branch';
  private currentUser: User;

  constructor(private http: HttpClient,
              private auth: AuthenticationService) {
    this.auth.currentUser.subscribe(user => this.currentUser = user)
  }

  createInstitution(institution): Observable<Institution> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    return this.http.post<Institution>(this.urlInstitution + '/addInstitution', institution, {headers: headers});
  }

  getAllInstitutions(): Observable<Institution[]> {
    return this.http.get<Institution[]>(this.urlInstitution + '/getAllInstitutions');
  }

  createInstitutionBranch(branch, institutionId, userId): Observable<Branch> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    let params = new HttpParams().set('institutionId', institutionId).set('userId', userId);
    return this.http.post<Branch>(this.urlBranch + '/addBranch', branch, {params: params, headers: headers});
  }

  getAllBranches(): Observable<Branch[]> {
    return this.http.get<Branch[]>(this.urlBranch + '/getAllBranches');
  }

  getCities(): Observable<string[]> {
    return this.http.get<string[]>(this.urlBranch + '/getCities');
  }

}
