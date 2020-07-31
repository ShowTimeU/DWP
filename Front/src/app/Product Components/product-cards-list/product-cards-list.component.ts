import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../-Services-/product.service";
import {Product} from "../../-Models-/product";

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
        if (a.productTemplate.productName < b.productTemplate.productName) return -1;
        else if (a.productTemplate.productName > b.productTemplate.productName) return 1;
        else return 0;
      });
    });
  }
}
