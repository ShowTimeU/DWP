import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from '../../-Services-/authentication.service';
import {ActivatedRoute, Router} from '@angular/router';
import {first} from 'rxjs/operators';
import {MatSnackBar} from '@angular/material/snack-bar';
import {Role} from "../../-Models-/role";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

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
      this.router.navigate(['/']);
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
    if (this.formGroup.invalid || this.f.email.value == Role.Manager) {
      this.snack.open('Got to "Business Log In" page',
          null, {duration: 3000, panelClass: 'snackLogin'})
      return;
    }
    this.auth.login(this.f.email.value, this.f.password.value)
      .pipe(first())
      .subscribe(data => {
          if (data) {
            this.router.navigate(['/']);
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
    this.router.navigate(['registration']);
  }
}
