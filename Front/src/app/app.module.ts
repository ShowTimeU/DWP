import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HomeComponent} from './Home/home.component';
import {HeaderComponent} from './Header/header.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {RouterModule} from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatBadgeModule} from '@angular/material/badge';
import {MatButtonModule} from '@angular/material/button';
import {UserLoginComponent} from './_User Components_/user-login/user-login.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {JwtInterceptor} from './-Helpers-/jwt.interceptor';
import {ErrorInterceptor} from './-Helpers-/error.interceptor';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {ProductCardComponent} from './Product Components/product-card/product-card.component';
import {ProductCardsListComponent} from './Product Components/product-cards-list/product-cards-list.component';
import {UserRegistrationComponent} from './_User Components_/user-registration/user-registration.component';
import {MatSelectModule} from "@angular/material/select";
import {ProductSearchComponent} from './Product Components/product-search/product-search.component';
import {ProductFiltersComponent} from './Product Components/product-filters/product-filters.component';
import {FilterPipe} from './-Helpers-/filter.pipe';
import {UserInfoComponent} from './_User Components_/user-info/user-info.component';
import {ShoppingCartComponent} from './Shopping Cart Components/shopping-cart/shopping-cart.component';
import {MatTableModule} from "@angular/material/table";
import {ShoppingCartItemComponent} from './Shopping Cart Components/shopping-cart-item/shopping-cart-item.component';
import {MatDialogModule} from "@angular/material/dialog";
import {ShoppingCartDetailsComponent} from './Shopping Cart Components/shopping-cart-details/shopping-cart-details.component';
import {MatTooltipModule} from "@angular/material/tooltip";
import {AboutUsComponent} from './About Us/about-us.component';
import {CheckoutComponent} from './Checkout/checkout.component';
import {UserOrdersComponent} from './_User Components_/user-orders/user-orders.component';
import {UserPaymentsComponent} from './_User Components_/user-payments/user-payments.component';
import {UserSocialAccountsComponent} from './_User Components_/user-social-accounts/user-social-accounts.component';
import {BusinessLoginComponent} from './_Business Components_/business-login/business-login.component';
import {BusinessRegistrationComponent} from './_Business Components_/business-registration/business-registration.component';
import {BusinessProductsComponent} from './_Business Components_/business-products/business-products.component';
import {MatStepperModule} from "@angular/material/stepper";
import {BusinessInfoComponent} from './_Business Components_/business-info/business-info.component';
import {BusinessOrdersComponent} from './_Business Components_/business-orders/business-orders.component';
import {CreateProductTemplateComponent} from './_Admin Components_/create-product-template/create-product-template.component';
import {UserSearchComponent} from './_Admin Components_/user-search/user-search.component';
import {MatPaginatorModule} from "@angular/material/paginator";
import { CreateInstitutionComponent } from './_Admin Components_/create-institution/create-institution.component';
import { InstitutionSearchComponent } from './_Admin Components_/institution-search/institution-search.component';
import { LinkifyPipe } from './-Helpers-/linkify.pipe';
import { CreateInstitutionBranchComponent } from './_Admin Components_/create-institution-branch/create-institution-branch.component';
import { BranchSearchComponent } from './_Admin Components_/branch-search/branch-search.component';
import { BranchInfoComponent } from './_Admin Components_/branch-info/branch-info.component';
import { CreateProductComponent } from './_Business Components_/create-product/create-product.component';
import { BusinessProductTemplateComponent } from './_Business Components_/business-product-template/business-product-template.component';
import {MatCheckboxModule} from "@angular/material/checkbox";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    UserLoginComponent,
    ProductCardComponent,
    ProductCardsListComponent,
    UserRegistrationComponent,
    ProductSearchComponent,
    ProductFiltersComponent,
    FilterPipe,
    UserInfoComponent,
    ShoppingCartComponent,
    ShoppingCartItemComponent,
    ShoppingCartDetailsComponent,
    AboutUsComponent,
    CheckoutComponent,
    UserOrdersComponent,
    UserPaymentsComponent,
    UserSocialAccountsComponent,
    BusinessLoginComponent,
    BusinessRegistrationComponent,
    BusinessProductsComponent,
    BusinessInfoComponent,
    BusinessOrdersComponent,
    CreateProductTemplateComponent,
    UserSearchComponent,
    CreateInstitutionComponent,
    InstitutionSearchComponent,
    LinkifyPipe,
    CreateInstitutionBranchComponent,
    BranchSearchComponent,
    BranchInfoComponent,
    CreateProductComponent,
    BusinessProductTemplateComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,
    RouterModule,
    MatIconModule,
    MatToolbarModule,
    MatBadgeModule,
    MatButtonModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCardModule,
    MatSnackBarModule,
    MatSelectModule,
    FormsModule,
    MatTableModule,
    MatDialogModule,
    MatTooltipModule,
    MatStepperModule,
    MatPaginatorModule,
    MatCheckboxModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
