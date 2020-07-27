import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {first} from "rxjs/operators";
import {Role} from "../../-Models-/role";

@Component({
  selector: 'app-business-login',
  templateUrl: './business-login.component.html',
  styleUrls: ['./business-login.component.css']
})
export class BusinessLoginComponent implements OnInit {

  formGroup: FormGroup;
  returnUrl: string;
  error = '';
  submitted = false;

  constructor(private snack: MatSnackBar,
              private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private auth: AuthenticationService,
              private router: Router) {
    if (this.auth.currentUserValue) {
      this.router.navigate(['business-products']);
    }
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
  }

  get f() {
    return this.formGroup.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.formGroup.invalid || this.f.email.value == Role.User) {
      this.snack.open('Got to "User Log In" page',
        null, {duration: 3000, panelClass: 'snackBusLogin'})
      return;
    }
    this.auth.login(this.f.email.value, this.f.password.value)
      .pipe(first())
      .subscribe(data => {
          if (data) {
            this.router.navigate(['business-products']);
            window.location.reload();
          }
        },
        error => {
          error = this.snack.open(error,
            null, {duration: 3000, panelClass: 'snackLogin'});
          this.error = error;
        });
  }

  toRegistration() {
    this.router.navigate(['business-registration']);
  }
}
