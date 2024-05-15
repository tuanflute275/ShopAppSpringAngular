import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ListcategoryComponent } from './pages/category/listcategory/listcategory.component';
import { AddcategoryComponent } from './pages/category/addcategory/addcategory.component';
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
import { ListCouponConditionComponent } from './pages/couponCondition/list-coupon-condition/list-coupon-condition.component';
import { AddCouponConditionComponent } from './pages/couponCondition/add-coupon-condition/add-coupon-condition.component';
import { UpdateCouponConditionComponent } from './pages/couponCondition/update-coupon-condition/update-coupon-condition.component';


const routes: Routes = [
  { path: '', component: DashboardComponent },

  { path: 'category', component: ListcategoryComponent },
  { path: 'category/add', component: AddcategoryComponent },
  { path: 'category/edit/:id', component: UpdatecategoryComponent },

  { path: 'product', component: ListproductComponent },
  { path: 'product/add', component: AddproductComponent },
  { path: 'product/edit/:id', component: UpdateproductComponent },
  { path: 'product/search/:keyword', component: ListproductComponent },

  { path: 'blog', component: ListblogComponent },
  { path: 'blog/add', component: AddblogComponent },
  { path: 'blog/edit/:id', component: UpdateblogComponent },

  { path: 'account', component: ListaccountComponent},
  { path: 'account/add', component: AddaccountComponent },
  { path: 'account/edit/:username', component: UpdateaccountComponent },

  { path: 'order', component: ListorderComponent},
  { path: 'order/edit/:id', component: UpdateorderComponent},
  { path: 'order/detail/:id', component: DetailComponent},

  {path: 'coupon', component: ListcouponComponent},
  {path: 'coupon/add', component: AddcouponComponent},
  {path: 'coupon/edit/:id', component: UpdatecouponComponent},

  {path: 'couponCondition', component: ListCouponConditionComponent},
  {path: 'couponCondition/add', component: AddCouponConditionComponent},
  {path: 'couponCondition/edit/:id', component: UpdateCouponConditionComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class AdminRoutingModule { }
