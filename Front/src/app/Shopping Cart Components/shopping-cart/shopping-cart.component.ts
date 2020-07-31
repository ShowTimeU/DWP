import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CartService} from "../../-Services-/cart.service";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {Subscription} from "rxjs";
import {User} from "../../-Models-/user";
import {MessengerService} from "../../-Services-/messenger.service";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  userSubscription: Subscription;
  currentUser: User;
  @Input() cartItems = [];
  @Output() productRemoved = new EventEmitter();
  displayedColumns: string[] = ['name', 'price', 'qty'];

  constructor(private msg: MessengerService,
              private cartService: CartService,
              private auth: AuthenticationService) {
    this.userSubscription = this.auth.currentUser.subscribe(user => this.currentUser = user);
  }

  ngOnInit() {
    this.loadCartItems();
  }

  loadCartItems() {
    if (this.auth.currentUserValue) {
      this.cartService.getCartItems(this.currentUser).subscribe((items) => {
        this.cartItems = items;
        console.log(this.cartItems);
        this.calcTotalPrice();
      })
    }
  }

  removeProduct(product) {
    this.cartService.removeProductsFromCart(product, this.currentUser).subscribe(() => {
      this.loadCartItems()
    })
  }

  calcTotalPrice() {
    return this.cartItems.reduce((acc, prod) => acc += (prod.product.price * prod.quantity), 0);
  }

}
