import { Component, OnInit } from '@angular/core';
import {Product} from "../../-Models-/product";
import {ProductService} from "../../-Services-/product.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {User} from "../../-Models-/user";
import {ProductTemplate} from "../../-Models-/product-template";
import {Role} from "../../-Models-/role";

@Component({
  selector: 'app-business-products',
  templateUrl: './business-products.component.html',
  styleUrls: ['./business-products.component.css']
})
export class BusinessProductsComponent implements OnInit {

  productList: ProductTemplate[];
  currentUser: User;

  constructor(private product: ProductService,
              private router: Router,
              private auth: AuthenticationService) { }

  ngOnInit(): void {
    if(this.auth.currentUserValue && this.auth.currentUserValue.role === Role.Manager) {
      this.currentUser = this.auth.currentUserValue;
      this.getProductsByInstitution();
    }
  }

  getProductsByInstitution() {
    // this.product.getAllTemplates().subscribe( data => {
    //   this.productList = data;
    // })
  }

  toCreateProduct() {
    this.router.navigate(['create-product']);
  }

}
