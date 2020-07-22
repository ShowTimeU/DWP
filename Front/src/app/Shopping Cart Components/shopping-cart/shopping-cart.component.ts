import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CartService} from "../../_Services/cart.service";
import {AuthenticationService} from "../../_Services/authentication.service";
import {Subscription} from "rxjs";
import {User} from "../../_Models/user";
import {MessengerService} from "../../_Services/messenger.service";

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
    return this.cartItems.reduce((acc, prod) => acc += (prod.price * prod.quantity), 0);
  }

}
