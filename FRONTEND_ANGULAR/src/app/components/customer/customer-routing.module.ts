import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProductsComponent } from './pages/products/products.component';
import { ListProductsComponent } from './pages/list-products/list-products.component';
import { DetailsComponent } from './pages/details/details.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { AuthGuard } from 'src/app/auth/auth.guard';
import { CartComponent } from './pages/cart/cart.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { MyOrderComponent } from './pages/my-order/my-order.component';
import { CouponComponent } from './pages/coupon/coupon.component';
import { BlogComponent } from './pages/blog/blog.component';
import { BlogDetailComponent } from './pages/blog-detail/blog-detail.component';
import { FogotPasswordComponent } from './pages/fogot-password/fogot-password.component';
import { ResetPasswordComponent } from './pages/reset-password/reset-password.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'category/:id', component: ListProductsComponent },
  { path: 'product', component: ProductsComponent },
  { path: 'product/search/:keyword', component: ProductsComponent },
  { path: 'product/:id', component: DetailsComponent },
  { path: 'coupon', component: CouponComponent },
  { path: 'blog', component: BlogComponent },
  { path: 'blogDetail/:id', component: BlogDetailComponent },
  { path: 'fogot-password', component: FogotPasswordComponent },
  { path: 'reset-password/:token', component: ResetPasswordComponent },
  {
    path: 'profile/:username',
    component: ProfileComponent,
    canActivate: [AuthGuard],
    data: {
      roles:["User"],
    },
  },
  {
    path: 'cart',
    component: CartComponent,
    canActivate: [AuthGuard],
    data: {
      roles:["User"],
    },
  },
  {
    path: 'checkout/:amount',
    component: CheckoutComponent,
    canActivate: [AuthGuard],
    data: {
      roles:["User"],
    },
  },
  {
    path: 'order',
    component: MyOrderComponent,
    canActivate: [AuthGuard],
    data: {
      roles:["User"],
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
