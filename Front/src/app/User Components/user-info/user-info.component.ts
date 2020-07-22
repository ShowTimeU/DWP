import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../_Services/authentication.service";
import {User} from "../../_Models/user";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Area} from "../../_Models/area";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  currentUser: User;
  info: FormGroup;
  areas: Area[] = [
    {value: 'Jerusalem', viewValue: 'Jerusalem District'},
    {value: 'North', viewValue: 'Northern District'},
    {value: 'Haifa', viewValue: 'Haifa District'},
    {value: 'Centre', viewValue: 'Central District'},
    {value: 'Tel Aviv', viewValue: 'Tel Aviv District'},
    {value: 'South', viewValue: 'Southern District'},
    {value: 'Judea and Samaria Area', viewValue: 'Judea and Samaria Area'},
  ];

  constructor(private snack: MatSnackBar,
              private auth: AuthenticationService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.auth.currentUser.subscribe(user => {
      this.currentUser = user;
    });
    this.auth.getUser(this.currentUser.id).subscribe(data=> {
      this.currentUser = data;
      this.auth.currentUserValue.firstName = this.currentUser.firstName;
      this.auth.currentUserValue.lastName = this.currentUser.lastName;
      this.info = this.formBuilder.group({
        id: this.currentUser.id,
        firstName: new FormControl(this.currentUser.firstName, Validators.pattern('[a-zA-Z ]{2,15}')),
        lastName: new FormControl(this.currentUser.lastName, Validators.pattern('[a-zA-Z ]{2,15}')),
        phone: new FormControl(this.currentUser.phone, Validators.pattern('[0-9 ]{9}')),
        area: new FormControl(this.currentUser.area)
      });
    });
  }

  onSubmit() {
    if (this.info.invalid) {
      return;
    } else {
      this.auth.updateUser(this.info.value);
      window.location.reload();
    }
  }
}
