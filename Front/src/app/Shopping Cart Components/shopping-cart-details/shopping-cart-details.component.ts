import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Subscription} from "rxjs";
import {User} from "../../-Models-/user";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {CartItem} from "../../-Models-/cart-item";
import {MessengerService} from "../../-Services-/messenger.service";
import {CartService} from "../../-Services-/cart.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shopping-cart-details',
  templateUrl: './shopping-cart-details.component.html',
  styleUrls: ['./shopping-cart-details.component.css']
})
export class ShoppingCartDetailsComponent implements OnInit {

  cartItems: CartItem[] = [];
  userSubscription: Subscription;
  currentUser: User;
  displayedColumns: string[] = ['image', 'description', 'price', 'location', 'quantity', 'cancel'];

  constructor(private msg: MessengerService,
              private cartService: CartService,
              private auth: AuthenticationService,
              private router: Router) {
    this.userSubscription = this.auth.currentUser.subscribe(user => this.currentUser = user);
  }

  ngOnInit() {
    this.loadCartItems();
  }

  loadCartItems() {
    if (this.auth.currentUserValue) {
      this.cartService.getCartItems(this.currentUser).subscribe((items: CartItem[]) => {
        this.cartItems = items;
        this.calcTotalPrice();
      })
    }
  }

  removeProducts(productCartId) {
    this.cartService.removeProductsFromCart(productCartId).subscribe(() => {
      this.loadCartItems()
    })
  }

  calcTotalPrice() {
    return this.cartItems.reduce((acc, prod) => acc += (prod.product.price * prod.quantity), 0);
  }

  checkPage() {
    this.router.navigate(['checkout']);
  }
}
