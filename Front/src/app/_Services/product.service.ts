import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../_Models/product";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private urlProduct = 'http://localhost:8080/product/';

  constructor(private http: HttpClient) { }

  createProduct(product): Observable<Product> {
    return this.http.post<Product>(this.urlProduct + 'createProduct', product);
  }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.urlProduct + 'getAllProducts');
  }

  getFilteredProducts(area, min, max) {
    return this.http.post<Product[]>(this.urlProduct + 'searchProduct', {area, min, max});
  }

}
