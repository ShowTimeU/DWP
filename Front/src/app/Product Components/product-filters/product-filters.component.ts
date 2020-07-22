import {Component, Input, OnInit} from '@angular/core';
import {Area} from "../../_Models/area";
import {ProductService} from "../../_Services/product.service";
import {Product} from "../../_Models/product";
import {Price} from "../../_Models/price";

@Component({
  selector: 'app-product-filters',
  templateUrl: './product-filters.component.html',
  styleUrls: ['./product-filters.component.css']
})
export class ProductFiltersComponent implements OnInit {

  @Input() selectedValue: any;
  @Input() selectedPrice: any;
  productList: Product[];
  area: string;
  min: number;
  max: number;

  searchText: '';
  areas: Area[] = [
    {value: 'All', viewValue: 'All Districts'},
    {value: 'Jerusalem', viewValue: 'Jerusalem District'},
    {value: 'North', viewValue: 'Northern District'},
    {value: 'Haifa', viewValue: 'Haifa District'},
    {value: 'Centre', viewValue: 'Central District'},
    {value: 'Tel Aviv', viewValue: 'Tel Aviv District'},
    {value: 'South', viewValue: 'Southern District'},
    {value: 'Judea and Samaria Area', viewValue: 'Judea and Samaria Area'}
  ];
  priceList: Price[] = [
    {min: 0, max: 1000, view: 'All Prices'},
    {min: 0, max: 50, view: '₪0 - ₪50'},
    {min: 51, max: 100, view: '₪51 - ₪100'},
    {min: 101, max: 150, view: '₪101 - ₪150'},
    {min: 151, max: 200, view: '₪151 - ₪200'},
    {min: 201, max: 250, view: '₪201 - ₪250'}
  ]

  constructor(private product: ProductService) {
  }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    return this.product.getAllProducts().subscribe(data => {
      this.productList = data;
      this.sorting(this.productList);
    });
  }

  filter() {
    if (this.selectedValue && !this.selectedPrice) {
      if (this.selectedValue === 'All') {
        this.getAllProducts();
      } else {
        this.getFilteredProducts(this.selectedValue, null, null);
      }
    } else if (this.selectedPrice && !this.selectedValue) {
      this.getFilteredProducts(null, this.selectedPrice.min, this.selectedPrice.max);
    } else if (this.selectedValue && this.selectedPrice) {
      if (this.selectedValue == 'All' && this.selectedPrice) {
        this.getFilteredProducts(null, this.selectedPrice.min, this.selectedPrice.max);
      } else {
        this.getFilteredProducts(this.selectedValue, this.selectedPrice.min, this.selectedPrice.max);
      }
    }
  }


  getFilteredProducts(area, min, max) {
    this.product.getFilteredProducts(area, min, max)
      .subscribe(data => {
        this.productList = data;
        this.sorting(this.productList);
      })
    return this.productList;
  }

  sorting(productList: Product[]) {
    productList.sort((a, b) => {
      if (a.productName < b.productName) return -1;
      else if (a.productName > b.productName) return 1;
      else return 0;
    });
  }


}
