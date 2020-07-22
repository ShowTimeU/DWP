import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../_Models/product";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  createProduct(product): Observable<Product> {
    return this.http.post<Product>(this.url + '/createProduct', product);
  }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url + '/getAllProducts');
  }

  getFilteredProducts(area, min, max) {
    return this.http.post<Product[]>(this.url + '/searchProduct', {area, min, max});
  }

}
