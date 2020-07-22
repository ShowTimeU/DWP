import {Component, OnInit} from '@angular/core';
import {Area} from "../../_Models/area";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthenticationService} from "../../_Services/authentication.service";
import {first} from "rxjs/operators";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import * as CryptoJS from 'crypto-js';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  areas: Area[] = [
    {value: 'Jerusalem', viewValue: 'Jerusalem District'},
    {value: 'North', viewValue: 'Northern District'},
    {value: 'Haifa', viewValue: 'Haifa District'},
    {value: 'Centre', viewValue: 'Central District'},
    {value: 'Tel Aviv', viewValue: 'Tel Aviv District'},
    {value: 'South', viewValue: 'Southern District'},
    {value: 'Judea and Samaria Area', viewValue: 'Judea and Samaria Area'},
  ];
  formGroup: FormGroup;
  returnUrl: string;
  error = '';
  private encWord = 'food';

  constructor(private snack: MatSnackBar,
              private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private auth: AuthenticationService) {
  }

  ngOnInit() {
    if (this.auth.currentUserValue) {
      this.router.navigate(['/']);
    }
    this.formGroup = this.formBuilder.group({
      firstName: new FormControl('', Validators.pattern('[a-zA-Z ]{2,15}')),
      lastName: new FormControl('', Validators.pattern('[a-zA-Z ]{2,15}')),
      email: new FormControl('', Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')),
      password: new FormControl('', Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z\d$@$!%*?&].{8,}')),
      phone: new FormControl('', Validators.pattern('[0-9 ]{9}')),
      area: new FormControl('', Validators.required)
    });
  }

  get f() {
    return this.formGroup.controls;
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      return;
    }
    // this.formGroup.value.password = CryptoJS.AES.encrypt(this.encWord.trim(), this.formGroup.value.password.trim()).toString();
    this.auth.createUser(this.formGroup.value)
      .pipe(first())
      .subscribe(
        data => {
          if (data) {
            this.router.navigate(['']);
          }
        },
        error => {
          error = this.snack.open('The user already exists. Try to use a different e-mail address',
            null, {duration: 3000, panelClass: 'snackReg'});
          this.error = error;
        });
  }

}
