import {Component, Input, OnInit} from '@angular/core';
import {ProductService} from "../../-Services-/product.service";
import {Product} from "../../-Models-/product";
import {InstitutionService} from "../../-Services-/institution.service";

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
  @Input() selectedInstitution: any;
  @Input() selectedVegan: boolean;
  @Input() selectedVegetarian: boolean;
  @Input() selectedKosher: boolean;

  productList: Product[];
  cities: Array<string> = ['--'];
  kitchens: Array<string> = ['--'];
  dishes: Array<string> = ['--'];
  institutions: Array<string> = ['--'];

  searchText: '';
  // priceList: Price[] = [
  //   {min: 0, max: 1000, view: '--'},
  //   {min: 0, max: 50, view: '₪0 - ₪50'},
  //   {min: 51, max: 150, view: '₪51 - ₪150'},
  //   {min: 151, max: 250, view: '₪151 - ₪250'}
  // ]

  constructor(private product: ProductService,
              private institution: InstitutionService) {
  }

  ngOnInit() {
    this.getAllProducts();
    this.institution.getCities().subscribe(c => {
      c.forEach(cData => {
        this.cities.push(cData);
      })
    })
    this.institution.getAllInstitutions().subscribe(x => {
      x.forEach(xData => {
        this.institutions.push(xData.institutionName);
      })
    });

    this.product.getKitchenTypes().subscribe(y => {
      y.forEach(yData => {
        this.kitchens.push(yData.kitchenName);
      })
      this.kitchens[6] = this.kitchens[6].bold();
    });

    this.product.getDishTypes().subscribe(z => {
      z.forEach(zData => {
        this.dishes.push(zData.dishType);
      })
    });
  }

  getAllProducts() {
    this.product.getAllProducts().subscribe(data => {
      this.productList = data;
      this.sorting(this.productList);
    });
  }

  filter() {
    if(this.selectedCity == '--') {
      this.selectedCity = undefined;
    }
    if(this.selectedInstitution == '--') {
      this.selectedInstitution = undefined;
    }
    if(this.selectedKitchen == '--') {
      this.selectedKitchen = undefined;
    }
    if(this.selectedDish == '--') {
      this.selectedDish = undefined;
    }

    if (!this.selectedCity) {
      this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                               this.selectedDish, this.selectedKitchen, this.selectedInstitution, null);
    } else {
      return this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
        this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    }

    if (!this.selectedInstitution) {
      this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                               this.selectedDish, this.selectedKitchen, null, this.selectedCity);
    } else {
      return this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                                      this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    }

    if (!this.selectedKitchen) {
      this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                               this.selectedDish, null, this.selectedInstitution, this.selectedCity);
    } else {
      return this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                                      this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    }

    if (!this.selectedDish) {
      this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                       null, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    } else {
      return this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                                      this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    }

    if (!this.selectedVegan) {
      this.getFilteredProducts(null, this.selectedVegetarian, this.selectedKosher,
                               this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    } else {
      return this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
                                      this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    }

    if (!this.selectedVegetarian) {
      this.getFilteredProducts(this.selectedVegan, null, this.selectedKosher,
        this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    } else {
      return this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
        this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    }

    if (!this.selectedKosher) {
      this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, null,
        this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    } else {
      return this.getFilteredProducts(this.selectedVegan, this.selectedVegetarian, this.selectedKosher,
        this.selectedDish, this.selectedKitchen, this.selectedInstitution, this.selectedCity);
    }
  }

  getFilteredProducts(vegan?, vegetarian?, kosher?, dishType?, kitchenType?, institutionName?, city?) {
    this.product.getFilteredProducts(vegan, vegetarian, kosher, dishType, kitchenType, institutionName, city)
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
