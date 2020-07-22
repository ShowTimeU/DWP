import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {User} from "../_Models/user";
import {HttpClient, HttpParams} from "@angular/common/http";
import {AuthenticationService} from "./authentication.service";
import {Product} from "../_Models/product";
import {CartItem} from "../_Models/cart-item";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private urlCart = 'http://localhost:8080/cart/';
  private currentUser: User;

  constructor(private http: HttpClient,
              private auth: AuthenticationService) {
    this.auth.currentUser.subscribe(user => this.currentUser = user);
  }

  getCartItems(user: User): Observable<CartItem[]> {
    const userId = user.id.toString();
    let params = new HttpParams().set('userId', userId)
    return this.http.get<CartItem[]>(this.urlCart + 'getAllCart', {params: params});
  }

  addProductToCart(product: Product, user: User): Observable<any> {
    const userId = user.id;
    const productId = product.id;
    return this.http.post<any>(this.urlCart + 'addToCart', {productId, userId});
  }

  removeProductsFromCart(product: CartItem, user: User) {
    const productId = product.productId;
    const userId = user.id;
    let params = new HttpParams().set('productId', String(productId)).set('userId', String(userId));
    return this.http.delete(this.urlCart + 'deleteFromCart', {params: params});
  }
}
