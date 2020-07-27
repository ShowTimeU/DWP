import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {User} from "../-Models-/user";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {AuthenticationService} from "./authentication.service";
import {Product} from "../-Models-/product";
import {CartItem} from "../-Models-/cart-item";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private urlCart = 'http://localhost:8080/cart';
  private currentUser: User;

  constructor(private http: HttpClient,
              private auth: AuthenticationService) {
    this.auth.currentUser.subscribe(user => this.currentUser = user);
  }

  getCartItems(user: User): Observable<CartItem[]> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    const userId = user.id.toString();
    let params = new HttpParams().set('userId', userId)
    return this.http.get<CartItem[]>(this.urlCart + '/getAllCart', {params: params, headers: headers});
  }

  addProductToCart(product: Product, user: User): Observable<any> {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    const userId = user.id;
    const productId = product.id;
    return this.http.post<any>(this.urlCart + '/addToCart', {productId, userId}, {headers: headers});
  }

  removeProductsFromCart(product: CartItem, user: User) {
    let headers = new HttpHeaders().set('Authorization', this.currentUser.token);
    const productId = product.productId;
    const userId = user.id;
    let params = new HttpParams().set('productId', String(productId)).set('userId', String(userId));
    return this.http.delete(this.urlCart + '/deleteFromCart', {params: params, headers: headers});
  }
}
