import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

import { AdminRoutingModule } from './admin-routing.module';
import { HeaderComponent } from './layouts/header/header.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { ListcategoryComponent } from './pages/category/listcategory/listcategory.component';
import { AddcategoryComponent } from './pages/category/addcategory/addcategory.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ListproductComponent } from './pages/product/listproduct/listproduct.component';
import { AddproductComponent } from './pages/product/addproduct/addproduct.component';
import { UpdateproductComponent } from './pages/product/updateproduct/updateproduct.component';
import { ListblogComponent } from './pages/blog/listblog/listblog.component';
import { AddblogComponent } from './pages/blog/addblog/addblog.component';
import { UpdateblogComponent } from './pages/blog/updateblog/updateblog.component';
import { UpdatecategoryComponent } from './pages/category/updatecategory/updatecategory.component';
import { ListaccountComponent } from './pages/account/listaccount/listaccount.component';
import { AddaccountComponent } from './pages/account/addaccount/addaccount.component';
import { UpdateaccountComponent } from './pages/account/updateaccount/updateaccount.component';
import { ListorderComponent } from './pages/order/listorder/listorder.component';
import { UpdateorderComponent } from './pages/order/updateorder/updateorder.component';
import { DetailComponent } from './pages/order/detail/detail.component';
import { ListcouponComponent } from './pages/coupon/listcoupon/listcoupon.component';
import { AddcouponComponent } from './pages/coupon/addcoupon/addcoupon.component';
import { UpdatecouponComponent } from './pages/coupon/updatecoupon/updatecoupon.component';
import { AddCouponConditionComponent } from './pages/couponCondition/add-coupon-condition/add-coupon-condition.component';
import { ListCouponConditionComponent } from './pages/couponCondition/list-coupon-condition/list-coupon-condition.component';
import { UpdateCouponConditionComponent } from './pages/couponCondition/update-coupon-condition/update-coupon-condition.component';


@NgModule({
  declarations: [
    DashboardComponent,
    HeaderComponent,
    SidebarComponent,
    ListcategoryComponent,
    AddcategoryComponent,
    UpdatecategoryComponent,
    ListproductComponent,
    AddproductComponent,
    UpdateproductComponent,
    ListblogComponent,
    AddblogComponent,
    UpdateblogComponent,
    ListaccountComponent,
    AddaccountComponent,
    UpdateaccountComponent,
    ListorderComponent,
    UpdateorderComponent,
    DetailComponent,
    ListcouponComponent,
    AddcouponComponent,
    UpdatecouponComponent,
    AddCouponConditionComponent,
    ListCouponConditionComponent,
    UpdateCouponConditionComponent,
  ],
  imports: [
    NgxPaginationModule,
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class AdminModule { }
