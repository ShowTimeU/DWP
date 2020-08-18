import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../../-Models-/product";
import {CartItem} from "../../-Models-/cart-item";
import {CartService} from "../../-Services-/cart.service";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {MessengerService} from "../../-Services-/messenger.service";

@Component({
  selector: 'app-shopping-cart-item',
  templateUrl: './shopping-cart-item.component.html',
  styleUrls: ['./shopping-cart-item.component.css']
})
export class ShoppingCartItemComponent implements OnInit {

  @Input() cartItem: CartItem;
  displayedColumns: string[] = ['name', 'price', 'quantity', 'cancel'];
  @Output() productRemoved = new EventEmitter();
  @Output() productsRemoved = new EventEmitter();
  @Output() productAdded = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
  }

  onClick() {
    this.productsRemoved.emit(this.cartItem.id);
  }

  calcPrice() {
    if (this.cartItem.product.price < 1) {
      return this.cartItem.product.price;
    }
    return this.cartItem.product.price * this.cartItem.quantity;
  }

  minus() {
    this.productRemoved.emit(this.cartItem);
  }

  plus() {
    this.productAdded.emit(this.cartItem.product);
  }
}
