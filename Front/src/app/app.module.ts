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
import {UserLoginComponent} from './User Components/user-login/user-login.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {JwtInterceptor} from './_Helpers/jwt.interceptor';
import {ErrorInterceptor} from './_Helpers/error.interceptor';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {ProductCardComponent} from './Product Components/product-card/product-card.component';
import {ProductCardsListComponent} from './Product Components/product-cards-list/product-cards-list.component';
import {UserRegistrationComponent} from './User Components/user-registration/user-registration.component';
import {MatSelectModule} from "@angular/material/select";
import {ProductSearchComponent} from './Product Components/product-search/product-search.component';
import {ProductFiltersComponent} from './Product Components/product-filters/product-filters.component';
import {FilterPipe} from './_Helpers/filter.pipe';
import {UserInfoComponent} from './User Components/user-info/user-info.component';
import {ShoppingCartComponent} from './Shopping Cart Components/shopping-cart/shopping-cart.component';
import {MatTableModule} from "@angular/material/table";
import {ShoppingCartItemComponent} from './Shopping Cart Components/shopping-cart-item/shopping-cart-item.component';
import {MatDialogModule} from "@angular/material/dialog";
import {ShoppingCartDetailsComponent} from './Shopping Cart Components/shopping-cart-details/shopping-cart-details.component';
import {MatTooltipModule} from "@angular/material/tooltip";
import {AboutUsComponent} from './About Us/about-us.component';
import {CheckoutComponent} from './Checkout/checkout.component';
import {UserOrdersComponent} from './User Components/user-orders/user-orders.component';
import {UserPaymentsComponent} from './User Components/user-payments/user-payments.component';
import {UserSocialAccountsComponent} from './User Components/user-social-accounts/user-social-accounts.component';
import {BusinessLoginComponent} from './Business Components/business-login/business-login.component';
import {BusinessRegistrationComponent} from './Business Components/business-registration/business-registration.component';
import {BusinessProductsComponent} from './Business Components/business-products/business-products.component';
import {MatStepperModule} from "@angular/material/stepper";
import { BusinessInfoComponent } from './Business Components/business-info/business-info.component';
import { BusinessOrdersComponent } from './Business Components/business-orders/business-orders.component';
import { CreateProductComponent } from './Create Product/create-product.component';

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
    CreateProductComponent,
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
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
