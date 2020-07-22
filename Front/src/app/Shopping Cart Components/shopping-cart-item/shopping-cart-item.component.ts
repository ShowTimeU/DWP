import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../../_Models/product";
import {CartItem} from "../../_Models/cart-item";

@Component({
  selector: 'app-shopping-cart-item',
  templateUrl: './shopping-cart-item.component.html',
  styleUrls: ['./shopping-cart-item.component.css']
})
export class ShoppingCartItemComponent implements OnInit {

  @Input() cartItem: CartItem;
  displayedColumns: string[] = ['name', 'price', 'quantity', 'cancel'];
  @Output() productRemoved = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  onClick() {
    this.productRemoved.emit(this.cartItem);
  }

  calcPrice() {
    if (this.cartItem.quantity < 1) {
      return this.cartItem.price;
    }
    return this.cartItem.price * this.cartItem.quantity;
  }

}
