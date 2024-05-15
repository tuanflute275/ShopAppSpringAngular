import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { BlogService } from 'src/app/services/blog.service';
import { CategoryService } from 'src/app/services/category.service';
import { OrderService } from 'src/app/services/order.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  countAccount:number = 0;
  countCategory:number = 0;
  countProduct:number = 0;
  countBlog:number = 0;
  countOrder:number = 0;
  countOrderDetail:number = 0;
  page: number = 1;
  data: any = [];

  constructor(
    private accountService: AccountService,
    private categoryService: CategoryService,
    private productService: ProductService,
    private blogService: BlogService,
    private orderService: OrderService,
  ) {}

  ngOnInit(): void {
    this.getAllAccount()
    this.getAllCategory()
    this.getAllProduct()
    this.getAllBlog()
    this.getAllOrder()
  }

  getAllAccount() {
    this.accountService.findAll().subscribe((response: any) => {
      this.countAccount = response.data.length;
    });
  }

  getAllCategory() {
    this.categoryService.findAll().subscribe((response: any) => {
      this.countCategory = response.data.length;
    });
  }

  getAllProduct() {
    this.productService.findAll().subscribe((response: any) => {
      this.countProduct = response.data.length;
    });
  }

  getAllBlog() {
    this.blogService.findAll().subscribe((response: any) => {
      this.countBlog = response.data.length;
    });
  }

  getAllOrder() {
    this.orderService.findAllByAdmin().subscribe((response: any) => {
      console.warn(response.data)
      this.data = response.data;
      this.countOrder = response.data.length;
    });
  }

}
