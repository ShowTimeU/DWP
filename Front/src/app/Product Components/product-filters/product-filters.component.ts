import {Component, Input, OnInit} from '@angular/core';
import {ProductService} from "../../-Services-/product.service";
import {Product} from "../../-Models-/product";
import {Price} from "../../-Models-/price";
import {Observable, ReplaySubject, Subject} from "rxjs";
import {FormControl} from "@angular/forms";
import {map, startWith, takeUntil} from "rxjs/operators";
import {KitchenType} from "../../-Models-/kitchen-type";

@Component({
  selector: 'app-product-filters',
  templateUrl: './product-filters.component.html',
  styleUrls: ['./product-filters.component.css']
})
export class ProductFiltersComponent implements OnInit {

  @Input() selectedCity: any;
  @Input() selectedPrice: any;
  @Input() selectedKitchen: any;
  @Input() selectedDish: any;

  productList: Product[];
  cities: Array<string> = ['All Cities'];
  kitchens: Array<string> = ['All Kitchens'];
  dishes: Array<string> = ['All Dishes']

  min: number;
  max: number;

  searchText: '';
  priceList: Price[] = [
    {min: 0, max: 1000, view: 'All Prices'},
    {min: 0, max: 50, view: '₪0 - ₪50'},
    {min: 51, max: 150, view: '₪51 - ₪150'},
    {min: 151, max: 250, view: '₪151 - ₪250'}
  ]

  constructor(private product: ProductService) {
  }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this.product.getAllProducts().subscribe(data => {
      this.productList = data;
      data.forEach(x => {
        this.cities.push(x.branch.branchCity);
      })
      this.sorting(this.productList);
    });

    this.product.getKitchenTypes().subscribe(y => {
      y.forEach( yData => {
        this.kitchens.push(yData.kitchenName);
      })
      this.kitchens[6] = this.kitchens[6].bold();
    })

    this.product.getDishTypes().subscribe(z => {
      z.forEach( zData => {
        this.dishes.push(zData.dishType);
      })
    })
  }

  filter() {
    if (this.selectedCity && !this.selectedPrice) {
      if (this.selectedCity === 'All cities') {
        this.getAllProducts();
      } else {
        this.getFilteredProducts(this.selectedCity, null, null);
      }
    } else if (this.selectedPrice && !this.selectedCity) {
      this.getFilteredProducts(null, this.selectedPrice.min, this.selectedPrice.max);
    } else if (this.selectedCity && this.selectedPrice) {
      if (this.selectedCity == 'All' && this.selectedPrice) {
        this.getFilteredProducts(null, this.selectedPrice.min, this.selectedPrice.max);
      } else {
        this.getFilteredProducts(this.selectedCity, this.selectedPrice.min, this.selectedPrice.max);
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
      if (a.productTemplate.productName < b.productTemplate.productName) return -1;
      else if (a.productTemplate.productName > b.productTemplate.productName) return 1;
      else return 0;
    });
  }

}
