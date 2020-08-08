import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './-Helpers-/auth.guard';
import {HomeComponent} from './Home/home.component';
import {UserLoginComponent} from './_User Components_/user-login/user-login.component';
import {UserRegistrationComponent} from "./_User Components_/user-registration/user-registration.component";
import {ProductSearchComponent} from "./Product Components/product-search/product-search.component";
import {UserInfoComponent} from "./_User Components_/user-info/user-info.component";
import {ShoppingCartComponent} from "./Shopping Cart Components/shopping-cart/shopping-cart.component";
import {ShoppingCartDetailsComponent} from "./Shopping Cart Components/shopping-cart-details/shopping-cart-details.component";
import {AboutUsComponent} from "./About Us/about-us.component";
import {CheckoutComponent} from "./Checkout/checkout.component";
import {UserOrdersComponent} from "./_User Components_/user-orders/user-orders.component";
import {UserPaymentsComponent} from "./_User Components_/user-payments/user-payments.component";
import {UserSocialAccountsComponent} from "./_User Components_/user-social-accounts/user-social-accounts.component";
import {BusinessLoginComponent} from "./_Business Components_/business-login/business-login.component";
import {BusinessRegistrationComponent} from "./_Business Components_/business-registration/business-registration.component";
import {Role} from "./-Models-/role";
import {BusinessInfoComponent} from "./_Business Components_/business-info/business-info.component";
import {BusinessOrdersComponent} from "./_Business Components_/business-orders/business-orders.component";
import {BusinessProductsComponent} from "./_Business Components_/business-products/business-products.component";
import {CreateProductTemplateComponent} from "./_Admin Components_/create-product-template/create-product-template.component";
import {UserSearchComponent} from "./_Admin Components_/user-search/user-search.component";
import {CreateInstitutionComponent} from "./_Admin Components_/create-institution/create-institution.component";
import {InstitutionSearchComponent} from "./_Admin Components_/institution-search/institution-search.component";
import {CreateInstitutionBranchComponent} from "./_Admin Components_/create-institution-branch/create-institution-branch.component";
import {BranchSearchComponent} from "./_Admin Components_/branch-search/branch-search.component";
import {BranchInfoComponent} from "./_Admin Components_/branch-info/branch-info.component";
import {CreateProductComponent} from "./_Business Components_/create-product/create-product.component";

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
    path: 'user-search',
    component: UserSearchComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Admin]}
  },
  {
    path: 'create-institution',
    component: CreateInstitutionComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Admin]}
  },
  {
    path: 'institution-search',
    component: InstitutionSearchComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Admin]}
  },
  {
    path: 'create-institution-branch',
    component: CreateInstitutionBranchComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Admin]}
  },
  {
    path: 'branch-search',
    component: BranchSearchComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Admin]}
  },
  {
    path: 'branch-info',
    component: BranchInfoComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Admin]}
  },
  {
    path: 'create-product-template',
    component: CreateProductTemplateComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Admin]}
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
