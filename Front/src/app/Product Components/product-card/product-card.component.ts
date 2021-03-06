import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {Product} from "../../-Models-/product";
import {Router} from "@angular/router";
import {ProductService} from "../../-Services-/product.service";
import {CartService} from "../../-Services-/cart.service";
import {AuthenticationService} from "../../-Services-/authentication.service";
import {MessengerService} from "../../-Services-/messenger.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Role} from "../../-Models-/role";
import {CartItem} from "../../-Models-/cart-item";

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input() productItem: Product;
  public counter: number = 1;
  currentUser: any;
  manager = false;
  vegan = false;
  vegetarian = false;
  kosher = false;

  cartItems: CartItem[];
  limit: number;

  constructor(private router: Router,
              private productService: ProductService,
              private cartService: CartService,
              private auth: AuthenticationService,
              private msg: MessengerService,
              private snack: MatSnackBar) {
  }
  ngOnInit() {
    this.auth.currentUser.subscribe(data => {
      this.currentUser = data;
      if(this.currentUser && this.currentUser.role === Role.Manager) {
        this.manager = true;
      }
    });
    if(this.productItem.productTemplate.vegan == true) {
      this.vegan = true;
    }
    if(this.productItem.productTemplate.vegetarian == true) {
      this.vegetarian = true;
    }
    if(this.productItem.productTemplate.kosher == true) {
      this.kosher = true;
    }
  }


  addToCart() {
    if (!this.auth.currentUserValue) {
      this.router.navigate(['login']);
    } else {
      this.snack.open('Product has been added to the cart!', null, {duration: 3000, panelClass: 'snackAdd'});
      this.cartService.addProductToCart(this.productItem, this.auth.currentUserValue).subscribe(() => {

        this.cartService.getCartItems(this.currentUser).subscribe( data => {
          data.map(x => {
            if(x.productTemplate.productName == this.productItem.productTemplate.productName) {
             this.limit = x.quantity;
            }
          });
        })
        this.msg.sendMsg(this.productItem);
        this.msg.editCount(this.counter);
      })
    }
  }

}
