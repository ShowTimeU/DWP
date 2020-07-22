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

  private cartUrl = 'http://localhost:8080/cart';
  private currentUser: User;

  constructor(private http: HttpClient,
              private auth: AuthenticationService) {
    this.auth.currentUser.subscribe(user => this.currentUser = user);
  }

  getCartItems(user: User): Observable<CartItem[]> {

    const userId = user.id.toString();
    let params = new HttpParams().set('userId', userId)
    return this.http.get<CartItem[]>(this.cartUrl + '/getAllCart', {params: params});
    // .pipe(
    //   map((res: any[]) => {
    //     let cartItems: CartItem[] = [];
    //
    //     for (let item of res) {
    //       let productExists = false;
    //
    //       for (let i in cartItems) {
    //         if (cartItems[i].product_id === item.id) {
    //           cartItems[i].quantity++;
    //           productExists = true;
    //           break;
    //         }
    //       }
    //       if (!productExists) {
    //         cartItems.push(new CartItem(item.id, item.product));
    //       }
    //     }
    //     return cartItems;
    //   })
    // )

  }

  addProductToCart(product: Product, user: User): Observable<any> {
    const userId = user.id;
    const productId = product.id;
    return this.http.post<any>(this.cartUrl + '/addToCart', {productId, userId});
  }

  removeProductsFromCart(product: CartItem, user: User) {
    const productId = product.productId;
    const userId = user.id;
    let params = new HttpParams().set('productId', String(productId)).set('userId', String(userId));
    return this.http.delete(this.cartUrl + '/deleteFromCart', {params: params});
  }
}
