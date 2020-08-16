import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../-Services-/product.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Institution} from "../../-Models-/institution";
import {Subscription} from "rxjs";
import {User} from "../../-Models-/user";
import {ProductTemplate} from "../../-Models-/product-template";
import {InstitutionService} from "../../-Services-/institution.service";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {Role} from "../../-Models-/role";
import {DishType} from "../../-Models-/dish-type";
import {KitchenType} from "../../-Models-/kitchen-type";

@Component({
  selector: 'app-create-product-template',
  templateUrl: './create-product-template.component.html',
  styleUrls: ['./create-product-template.component.css']
})
export class CreateProductTemplateComponent implements OnInit {

  selectedInstitutionValue: string;
  institutionList: Institution[];

  selectedKitchenValue: string;
  kitchenTypeList: KitchenType[];

  selectedDishValue: string;
  dishTypeList: DishType[];

  userSubscription: Subscription;
  currentUser: User;

  formGroup: FormGroup;
  createdProductTemplate: ProductTemplate;
  value: boolean[];

  error = '';
  role = '';
  maxChars = 250;

  checkedKosher = false;
  checkedVegetarian = false;
  checkedVegan = false;

  constructor(private snack: MatSnackBar,
              private fb: FormBuilder,
              private product: ProductService,
              private router: Router,
              private institution: InstitutionService,
              private auth: AuthenticationService) {
  }

  ngOnInit() {
    this.userSubscription = this.auth.currentUser.subscribe(data => {
      this.currentUser = data;
      this.institution.getAllInstitutions().subscribe(data => this.institutionList = data);
      this.product.getKitchenTypes().subscribe(data => this.kitchenTypeList = data);
      this.product.getDishTypes().subscribe(data => this.dishTypeList = data);
    });
    if(this.currentUser && this.currentUser.role === Role.Admin) {
      this.formGroup = this.fb.group({
        productName: new FormControl('', Validators.required),
        productDescription: new FormControl('', Validators.required),
        productImage: new FormControl('', Validators.required),
        institutionId: new FormControl(this.selectedInstitutionValue, Validators.required),
        kitchenTypeId: new FormControl(this.selectedKitchenValue, Validators.required),
        dishTypeId: new FormControl(this.selectedDishValue, Validators.required),
        kosher: new FormControl(this.checkedKosher),
        vegetarian: new FormControl(this.checkedVegetarian),
        vegan: new FormControl(this.checkedVegan)
      });
    }
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      return;
    }
    this.product.createProductTemplate(this.formGroup.value).subscribe(data => {
      this.createdProductTemplate = data;
      window.location.reload();
    }, error => {
      error = this.snack.open(error, null, {duration: 3000, panelClass: 'snackReg'});
      this.error = error;
    });
  }


}
