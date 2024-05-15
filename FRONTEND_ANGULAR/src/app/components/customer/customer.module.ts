import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

import { CustomerRoutingModule } from './customer-routing.module';
import { HeaderComponent } from './layouts/header/header.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { ListProductsComponent } from './pages/list-products/list-products.component';
import { DetailsComponent } from './pages/details/details.component';
import { ProductsComponent } from './pages/products/products.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { CartComponent } from './pages/cart/cart.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { MyOrderComponent } from './pages/my-order/my-order.component';
import { CouponComponent } from './pages/coupon/coupon.component';
import { BlogComponent } from './pages/blog/blog.component';
import { BlogDetailComponent } from './pages/blog-detail/blog-detail.component';
import { FogotPasswordComponent } from './pages/fogot-password/fogot-password.component';
import { ResetPasswordComponent } from './pages/reset-password/reset-password.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    SidebarComponent,
    ListProductsComponent,
    DetailsComponent,
    ProductsComponent,
    ProfileComponent,
    CartComponent,
    CheckoutComponent,
    MyOrderComponent,
    CouponComponent,
    BlogComponent,
    BlogDetailComponent,
    FogotPasswordComponent,
    ResetPasswordComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class CustomerModule { }
