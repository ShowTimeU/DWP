import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../-Models-/product";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {User} from "../-Models-/user";
import {AuthenticationService} from "./authentication.service";
import {ProductTemplate} from "../-Models-/product-template";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private urlProduct = 'http://localhost:8080/product';
  private urlProductTemplate = 'http://localhost:8080/productTemplate';
  private currentUser: User;

  constructor(private http: HttpClient,
              private auth: AuthenticationService) {
    this.auth.currentUser.subscribe(user => this.currentUser = user);
  }

  createProduct(product): Observable<Product> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    return this.http.post<Product>(this.urlProduct + '/createProduct', product, {headers: headers});
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

}
