import { Component, OnInit } from '@angular/core';
import {Product} from "../../-Models-/product";
import {ProductService} from "../../-Services-/product.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {User} from "../../-Models-/user";

@Component({
  selector: 'app-business-products',
  templateUrl: './business-products.component.html',
  styleUrls: ['./business-products.component.css']
})
export class BusinessProductsComponent implements OnInit {

  productList: Product[];
  currentUser: User;
  displayedColumns: string[] = ['image', 'description', 'price', 'location', 'quantity', 'cancel'];

  constructor(private product: ProductService,
              private router: Router,
              private auth: AuthenticationService) { }

  ngOnInit(): void {
    if(this.auth.currentUserValue) {
      this.currentUser = this.auth.currentUserValue;
      this.getProductsByInstitution();
    }
  }

  getProductsByInstitution() {
    this.product.getAllProducts().subscribe( data => {
      this.productList = data;
      this.sorting(this.productList);
    })
  }

  toCreateProduct() {
    this.router.navigate(['create-product']);
  }

  sorting(productList: Product[]) {
    productList.sort((a, b) => {
      if (a.productName < b.productName) return -1;
      else if (a.productName > b.productName) return 1;
      else return 0;
    });
  }
}
