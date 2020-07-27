import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Product} from "../../-Models-/product";
import {Area} from "../../-Models-/area";
import {ProductService} from "../../-Services-/product.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {first} from "rxjs/operators";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  formGroup: FormGroup;
  createdProduct: Product;
  id: number;
  error = '';
  selectedValue: string;
  role = '';
  maxChars = 250;

  areas: Area[] = [
    {value: 'Jerusalem', viewValue: 'Jerusalem District'},
    {value: 'North', viewValue: 'Northern District'},
    {value: 'Haifa', viewValue: 'Haifa District'},
    {value: 'Centre', viewValue: 'Central District'},
    {value: 'Tel Aviv', viewValue: 'Tel Aviv District'},
    {value: 'South', viewValue: 'Southern District'},
    {value: 'Judea and Samaria Area', viewValue: 'Judea and Samaria Area'}
  ];

  constructor(private snack: MatSnackBar,
              private fb: FormBuilder,
              private product: ProductService,
              private router: Router) {
  }

  ngOnInit() {
    this.formGroup = this.fb.group({
      institution: new FormControl('', Validators.required),
      productName: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      startingPrice: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required),
      quantity: new FormControl('', Validators.required),
      area: new FormControl('', Validators.required),
      image: new FormControl(''),
      institutionLogo: new FormControl('')
    });
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      return;
    }
    this.product.createProduct(this.formGroup.value).subscribe(data => {
      this.createdProduct = data;
      console.log(this.createdProduct);
      this.router.navigate(['/business-products']);
    }, error => {
      error = this.snack.open('This product already exists!',
        null, {duration: 3000, panelClass: 'snackReg'});
      this.error = error;
    });
  }


}
