import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Product} from "../../-Models-/product";
import {Area} from "../../-Models-/area";
import {ProductService} from "../../-Services-/product.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {first} from "rxjs/operators";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Institution} from "../../-Models-/institution";
import {Subscription} from "rxjs";
import {User} from "../../-Models-/user";
import {ProductTemplate} from "../../-Models-/product-template";
import {InstitutionService} from "../../-Services-/institution.service";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {Role} from "../../-Models-/role";

@Component({
  selector: 'app-create-product-template',
  templateUrl: './create-product-template.component.html',
  styleUrls: ['./create-product-template.component.css']
})
export class CreateProductTemplateComponent implements OnInit {

  selectedValue: string;
  institutionList: Institution[];
  userSubscription: Subscription;
  currentUser: User;
  formGroup: FormGroup;
  createdProductTemplate: ProductTemplate;
  error = '';
  role = '';
  maxChars = 250;

  constructor(private snack: MatSnackBar,
              private fb: FormBuilder,
              private product: ProductService,
              private router: Router,
              private institution: InstitutionService,
              private auth: AuthenticationService) {
  }

  ngOnInit() {
    this.userSubscription = this.auth.currentUser.subscribe(data => this.currentUser = data);
    this.institution.getAllInstitutions().subscribe(data => this.institutionList = data);
    if(this.currentUser && this.currentUser.role === Role.Admin) {
      this.formGroup = this.fb.group({
        productName: new FormControl('', Validators.required),
        productDescription: new FormControl('', Validators.required),
        productImage: new FormControl('', Validators.required),
        institutionId: new FormControl(this.selectedValue, Validators.required)
      });
    }
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      return;
    }
    this.product.createProductTemplate(this.formGroup.value).subscribe(data => {
      this.createdProductTemplate = data;
      this.router.navigate(['/business-products']);
    }, error => {
      error = this.snack.open('This product already exists!',
        null, {duration: 3000, panelClass: 'snackReg'});
      this.error = error;
    });
  }


}
