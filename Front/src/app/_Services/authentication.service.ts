import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {User} from '../_Models/user';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

@Injectable({providedIn: 'root'})
export class AuthenticationService {

  private url = 'http://localhost:8080/';
  private urlUser = 'http://localhost:8080/user/';

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;
  private localStData: any;

  constructor(private router: Router,
              private matSnackBar: MatSnackBar,
              private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.url + 'registration', user);
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(email: string, password: string) {
    return this.http.post<any>(this.url + 'login', {email, password})
      .pipe(map(user => {
          if (!user) {
            return this.snack('Username or password is incorrect');
          }
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
          return user;
        })
      );
  }

  logout() {
    let headers = new HttpHeaders().set('Authorization', this.currentUserValue.token);
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
    return this.http.delete(this.urlUser + 'logout', {headers: headers});
  }

  updateUser(user: User) {
    this.localStData = JSON.parse(localStorage.getItem("currentUser"))
    let headers = new HttpHeaders().set('Authorization', this.currentUserValue.token);
    this.matSnackBar.open('User details successfully saved!',
      null, {duration: 3000, panelClass: 'snackConf'});
    return this.http.post<User>(this.urlUser + 'updateUser', user, {headers: headers})
      .subscribe(data => {
        this.localStData[0].firstName = user.firstName;
        this.localStData[0].lastName = user.lastName;
        this.localStData[0].phone = user.phone;
        this.localStData[0].area = user.area;
        localStorage.setItem('currentUser', JSON.stringify(this.localStData));
        this.currentUserSubject.next(this.localStData);
        return user;
      })
  }

  getUser(userId): Observable<User> {
    let headers = new HttpHeaders().set('Authorization', this.currentUserValue.token);
    return this.http.get<User>(this.urlUser + 'getUser/' + userId, {headers: headers});
  }

  snack(msg) {
    this.matSnackBar.open(msg, null, {duration: 3000, panelClass: 'snack'});
  }
}
