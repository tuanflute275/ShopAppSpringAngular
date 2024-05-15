import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {

  page: number = 1;
  products: any[] = [];
  keywords: any;
  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });
  categoryId = this.route.snapshot.params['id'];

  constructor(
    private categoryService: CategoryService,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getProductByCategory(this.categoryId)
  }

  getProductByCategory(categoryId: number) {
    this.categoryService.findById(categoryId).subscribe((response: any) => {
      console.log(response.data.products);
      this.products = response.data.products;
    }, err => {
      console.log(err);
    });
  }

  getDetailProduct(productId:any){
    this.router.navigate([`product/${productId}`]);
  }

  getByName(keyword: any) {
    this.productService.search(keyword).subscribe((response: any) => {
      console.log(response.data);
      this.products = response.data;
    }, (err:any) => {
      console.log(err);
    })
  }

  handleChange(e: any) {
    this.keywords = e.target.value;
    if (this.keywords) {
      this.getByName(this.keywords);
    } else {
      this.getProductByCategory(this.categoryId);
    }
  }
}
