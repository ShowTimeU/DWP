import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../_Services/product.service";
import {Product} from "../../_Models/product";

@Component({
  selector: 'app-product-cards-list',
  templateUrl: './product-cards-list.component.html',
  styleUrls: ['./product-cards-list.component.css']
})
export class ProductCardsListComponent implements OnInit {

  productList: Product[] = [];
  constructor(private product: ProductService) { }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    return this.product.getAllProducts().subscribe(data => {
      this.productList = data;
      this.productList.sort((a, b) => {
        if (a.productName < b.productName) return -1;
        else if (a.productName > b.productName) return 1;
        else return 0;
      });
    });
  }
}
