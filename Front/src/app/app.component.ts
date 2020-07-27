import {
  ChangeDetectorRef,
  Component,
  OnInit
} from '@angular/core';
import {User} from './-Models-/user';
import {AuthenticationService} from './-Services-/authentication.service';
import {MatDialog} from "@angular/material/dialog";
import {ShoppingCartComponent} from "./Shopping Cart Components/shopping-cart/shopping-cart.component";
import {MessengerService} from "./-Services-/messenger.service";
import {CartService} from "./-Services-/cart.service";
import {Router} from "@angular/router";
import {Role} from "./-Models-/role";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  currentUser: User;
  total: any;

  constructor(public router: Router,
              private changeDetection: ChangeDetectorRef,
              private auth: AuthenticationService,
              private dialog: MatDialog,
              private msg: MessengerService,
              private cart: CartService) {
  }

  ngOnInit() {
    if (this.auth.currentUserValue) {
      this.currentUser = this.auth.currentUserValue;
      if (this.currentUser.role === Role.User) {
        setInterval(() => {
          this.checkCart();
          this.changeDetection.markForCheck()
        }, 1000)
      }
    } else {
      this.auth.currentUser.subscribe(x => this.currentUser = x);
    }
  }

  checkCart() {
    this.cart.getCartItems(this.currentUser).subscribe(data => {
      this.total = data.reduce((acc, prod) => acc += prod.quantity, 0);
    });
  }

  logout() {
    this.auth.logout();
    window.location.reload();
  }

  openCart() {
    this.dialog.open(ShoppingCartComponent, {
      width: '600px',
      minHeight: '400px'
    })
  }

  get isUserOrAdmin() {
    if (this.currentUser && this.currentUser.role === Role.Manager) {
      return false;
    } else {
      return this.currentUser;
    }
  }

}
