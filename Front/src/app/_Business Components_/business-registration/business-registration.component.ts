import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-business-registration',
  templateUrl: './business-registration.component.html',
  styleUrls: ['./business-registration.component.css']
})
export class BusinessRegistrationComponent implements OnInit {

  formGroup: FormGroup;
  error = '';
  email: any;
  role = '';
  maxChars = 500;
  constructor(private snack: MatSnackBar,
              private router: Router,
              private auth: AuthenticationService,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.formGroup = this.fb.group({
      name: new FormControl('', Validators.pattern('[a-zA-Z ]{1,30}')),
      email: new FormControl('', Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')),
      city: new FormControl('', Validators.pattern('[a-zA-Z ]{1,30}')),
      address: new FormControl('', Validators.pattern('')),
      website: new FormControl('', Validators.pattern('(https?://)?([\\\\da-z.-]+)\\\\.([a-z.]{2,6})[/\\\\w .-]*/?')),
      phone: new FormControl('', Validators.pattern('[0-9 ]{9}')),
      comment: new FormControl('', Validators.pattern(''))
    });
  }

  onSubmit() {

  }

}
