import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Institution} from "../../-Models-/institution";
import {Branch} from "../../-Models-/branch";
import {User} from "../../-Models-/user";
import {MatSnackBar} from "@angular/material/snack-bar";
import {InstitutionService} from "../../-Services-/institution.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {Subscription} from "rxjs";
import {Role} from "../../-Models-/role";

@Component({
  selector: 'app-create-institution-branch',
  templateUrl: './create-institution-branch.component.html',
  styleUrls: ['./create-institution-branch.component.css']
})
export class CreateInstitutionBranchComponent implements OnInit {

  formGroup: FormGroup;
  institutionList: Institution[];
  currentUser: User;
  createdBranch: Branch;
  error = '';
  selectedValue: string;
  selectedUser: string;
  userList: User[];

  constructor(private snack: MatSnackBar,
              private fb: FormBuilder,
              private institution: InstitutionService,
              private router: Router,
              private auth: AuthenticationService) { }

  ngOnInit(): void {
    this.institution.getAllInstitutions().subscribe(data => this.institutionList = data);
    this.auth.getAllUsers().subscribe(data => this.userList = data);
    if(this.auth.currentUserValue && this.auth.currentUserValue.role === Role.Admin) {
      this.formGroup = this.fb.group({
        branchCity: new FormControl('', Validators.required),
        branchAddress: new FormControl('', Validators.required),
        branchPhone: new FormControl('', Validators.required),
        branchEmail: new FormControl('', Validators.required),
      });
    }
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      return;
    }
    this.institution.createInstitutionBranch(this.formGroup.value, this.selectedValue, this.selectedUser).subscribe(data => {
      this.createdBranch = data;
      this.router.navigate(['/branch-search']);
      console.log(this.createdBranch);
    }, error => {
      error = this.snack.open('This institution already exists!',
        null, {duration: 3000, panelClass: 'snackReg'});
      this.error = error;
    });
  }

}
