import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";
import {Institution} from "../../-Models-/institution";
import {InstitutionService} from "../../-Services-/institution.service";

@Component({
  selector: 'app-create-institution',
  templateUrl: './create-institution.component.html',
  styleUrls: ['./create-institution.component.css']
})
export class CreateInstitutionComponent implements OnInit {

  formGroup: FormGroup;
  createdInstitution: Institution;
  role = '';
  maxChars = 250;
  error = '';

  constructor(private snack: MatSnackBar,
              private fb: FormBuilder,
              private institution: InstitutionService,
              private router: Router) { }

  ngOnInit(): void {
    this.formGroup = this.fb.group({
      institutionName: new FormControl('', Validators.required),
      institutionWebSite: new FormControl('', Validators.required),
      institutionLogo: new FormControl('', Validators.required),
      institutionDescription: new FormControl('', Validators.required),
    });
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      return;
    }
    this.institution.createInstitution(this.formGroup.value).subscribe(data => {
      this.createdInstitution = data;
      this.router.navigate(['/institution-search']);
    }, error => {
      error = this.snack.open('This institution already exists!',
        null, {duration: 3000, panelClass: 'snackReg'});
      this.error = error;
    });
  }
}
