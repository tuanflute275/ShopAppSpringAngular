import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  page: number = 1;
  categories: any[] = [];
  products: any[] = [];
  keywords: any;
  key_search = this.route.snapshot.params['keyword'];
  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });

  constructor(
    private categoryService: CategoryService,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllCategory();
    if (this.key_search !== undefined) {
      this.getByName(this.key_search);
      // window.location.reload()
    } else {
      this.getAll();
    }
  }

  getAll() {
    this.productService.findAll().subscribe(
      (response: any) => {
        console.log(response.data);
        this.products = response.data;
      },
      (err: any) => {
        console.log(err);
      }
    );
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
    console.log(categoryId)
    location.href = `category/${categoryId}`;
  }

  getDetailProduct(productId: any) {
    this.router.navigate([`product/${productId}`]);
  }

  getByName(keyword: any) {
    this.productService.search(keyword).subscribe(
      (response: any) => {
        console.log(response.data);
        this.products = response.data;
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  getCategoryById(id: any) {}

  handleChange(e: any) {
    this.keywords = e.target.value;
    if (this.keywords) {
      this.getByName(this.keywords);
    } else {
      this.getAll();
    }
  }
}
