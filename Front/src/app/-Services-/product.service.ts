import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../-Models-/product";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {User} from "../-Models-/user";
import {AuthenticationService} from "./authentication.service";
import {ProductTemplate} from "../-Models-/product-template";
import {KitchenType} from "../-Models-/kitchen-type";
import {DishType} from "../-Models-/dish-type";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url = 'http://localhost:8080';
  private urlProduct = 'http://localhost:8080/product';
  private urlProductTemplate = 'http://localhost:8080/productTemplate';
  private currentUser: User;

  constructor(private http: HttpClient,
              private auth: AuthenticationService) {
    this.auth.currentUser.subscribe(user => this.currentUser = user);
  }

  createProduct(product): Observable<Product> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    return this.http.post<Product>(this.urlProduct + '/addProduct', product, {headers: headers});
  }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.urlProduct + '/getAllProducts');
  }

  getFilteredProducts(area, min, max) {
    return this.http.post<Product[]>(this.urlProduct + '/searchProduct', {area, min, max});
  }

  createProductTemplate(productTemplate): Observable<ProductTemplate> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    return this.http.post<ProductTemplate>(this.urlProductTemplate + '/addTemplate', productTemplate, {headers: headers});
  }

  getAllTemplates(institutionId): Observable<ProductTemplate[]> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    let params = new HttpParams().set('institutionId', institutionId);
    return this.http.get<ProductTemplate[]>(this.urlProductTemplate + '/getAllTemplates', {headers: headers, params: params});
  }

  getKitchenTypes(): Observable<KitchenType[]> {
    return this.http.get<KitchenType[]>(this.url + '/getKitchenTypes');
  }

  getDishTypes(): Observable<DishType[]> {
    return this.http.get<DishType[]>(this.url + '/getDishTypes');
  }
}
