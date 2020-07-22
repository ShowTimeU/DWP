import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './_Helpers/auth.guard';
import {HomeComponent} from './Home/home.component';
import {UserLoginComponent} from './User Components/user-login/user-login.component';
import {UserRegistrationComponent} from "./User Components/user-registration/user-registration.component";
import {ProductSearchComponent} from "./Product Components/product-search/product-search.component";
import {UserInfoComponent} from "./User Components/user-info/user-info.component";
import {ShoppingCartComponent} from "./Shopping Cart Components/shopping-cart/shopping-cart.component";
import {ShoppingCartDetailsComponent} from "./Shopping Cart Components/shopping-cart-details/shopping-cart-details.component";
import {AboutUsComponent} from "./About Us/about-us.component";
import {CheckoutComponent} from "./Checkout/checkout.component";
import {UserOrdersComponent} from "./User Components/user-orders/user-orders.component";
import {UserPaymentsComponent} from "./User Components/user-payments/user-payments.component";
import {UserSocialAccountsComponent} from "./User Components/user-social-accounts/user-social-accounts.component";
import {BusinessLoginComponent} from "./Business Components/business-login/business-login.component";
import {BusinessRegistrationComponent} from "./Business Components/business-registration/business-registration.component";
import {Role} from "./_Models/role";
import {BusinessInfoComponent} from "./Business Components/business-info/business-info.component";
import {BusinessOrdersComponent} from "./Business Components/business-orders/business-orders.component";
import {BusinessProductsComponent} from "./Business Components/business-products/business-products.component";
import {CreateProductComponent} from "./Create Product/create-product.component";


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: UserLoginComponent
  },
  {
    path: 'registration',
    component: UserRegistrationComponent
  },
  {
    path: 'business-login',
    component: BusinessLoginComponent
  },
  {
    path: 'business-registration',
    component: BusinessRegistrationComponent
  },
  {
    path: 'about-us',
    component: AboutUsComponent
  },
  {
    path: 'search',
    component: ProductSearchComponent
  },
  {
    path: 'user-info',
    component: UserInfoComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.User, Role.Admin]}
  },
  {
    path: 'user-orders',
    component: UserOrdersComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.User, Role.Admin]}
  },
  {
    path: 'user-payment-methods',
    component: UserPaymentsComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.User, Role.Admin]}
  },
  {
    path: 'user-social-accounts',
    component: UserSocialAccountsComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.User, Role.Admin]}
  },
  {
    path: 'cart',
    component: ShoppingCartComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.User, Role.Admin]}
  },
  {
    path: 'cart-details',
    component: ShoppingCartDetailsComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.User, Role.Admin]}
  },
  {
    path: 'checkout',
    component: CheckoutComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.User, Role.Admin]}
  },
  {
    path: 'business-info',
    component: BusinessInfoComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Manager, Role.Admin]}
  },
  {
    path: 'business-orders',
    component: BusinessOrdersComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Manager, Role.Admin]}
  },
  {
    path: 'business-products',
    component: BusinessProductsComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Manager, Role.Admin]}
  },
  {
    path: 'create-product',
    component: CreateProductComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Manager, Role.Admin]}
  },
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
