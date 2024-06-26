import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent implements OnInit {
  userData: any;
  categories: any[] = [];

  constructor(
    private categoryService: CategoryService,
    private productService: ProductService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllCategory();
    this.getLocalStorage();
  }

  getLocalStorage(): any {
    this.userData = JSON.parse(localStorage.getItem('u_data') as any) || {};
    console.log('U Data: ', this.userData);
  }

  getAllCategory() {
    this.categoryService.findAll().subscribe(
      (response: any) => {
        this.categories = response.data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getByCategoryId(categoryId: any) {
    // this.router.navigate([`category/${categoryId}`]);
    location.href = `category/${categoryId}`
  }
}
