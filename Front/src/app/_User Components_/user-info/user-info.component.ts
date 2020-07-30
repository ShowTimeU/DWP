import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../-Services-/authentication.service";
import {User} from "../../-Models-/user";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  currentUser: User;
  info: FormGroup;

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
        phone: new FormControl(this.currentUser.phone, Validators.pattern('[0-9 ]{9}'))
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