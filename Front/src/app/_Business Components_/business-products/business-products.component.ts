import {Component, OnInit} from '@angular/core';
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

  currentUser: User;
  productTemplateList: ProductTemplate[];

  constructor(private product: ProductService,
              private router: Router,
              private auth: AuthenticationService) {
  }

  ngOnInit(): void {
    if (this.auth.currentUserValue && this.auth.currentUserValue.role === Role.Manager) {
      this.currentUser = this.auth.currentUserValue;
      this.product.getAllTemplates(this.currentUser.institution.id).subscribe(data => {
        this.productTemplateList = data;
        this.productTemplateList.sort((a, b) => {
          if (a.productName < b.productName) return -1;
          else if (a.productName > b.productName) return 1;
          else return 0;
        });
      });
    }
  }


}
