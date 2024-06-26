import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BlogService } from 'src/app/services/blog.service';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  page: number = 1;
  categories: any[] = [];
  newProducts: any[] = [];
  saleProducts: any[] = [];
  carts: any[] = [];
  cartId: number = 1;
  blogs: any[] = [];

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private blogService: BlogService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // location.reload();
    this.getAllCategory();
    this.getAllProductNew();
    this.getAllProductSale();
    this.getCarts();
    this.getAllBlog();
  }

  getAllBlog() {
    this.blogService.findAll().subscribe((response) => {
      this.blogs = response.data;
    });
  }

  getAllProductNew() {
    this.productService.findAll().subscribe(
      (response: any) => {
        console.log(response.data);
        this.newProducts = response.data;
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  getDetailProduct(productId: any) {
    this.router.navigate([`product/${productId}`]);
  }

  getDetailBlog(blogId: any) {
    this.router.navigate([`/blogDetail/${blogId}`]);
  }

  getAllCategory() {
    // this.productService.getAllCategory().subscribe((res: any) => {
    //   console.log(res);
    //   this.categories = res;
    // }, (err:any) => {
    //   console.log(err);
    // })
  }

  getAllProductSale() {
    this.productService.getProductDiscount().subscribe(
      (response: any) => {
        console.log(response.data);
        this.saleProducts = response.data;
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  getCarts() {
    this.cartService.findAll().subscribe((response) => {
      this.carts = response.data;
    });
  }

  onBuyNow(productId: number) {
    this.carts.map((item: any) => {
      if (item.product.productId == productId) this.cartId = item.cartId;
    });

    if (this.cartId != 1) {
      this.cartService.updateQuantity(this.cartId).subscribe(
        (response: any) => {
          console.log(response);
          Swal.fire('', 'Add to cart successfully !', 'success');
          this.router.navigate(['/cart']);
        },
        (error) => {
          console.log(error);
        }
      );
    } else {
      this.cartService.save(productId, 1).subscribe(
        (response: any) => {
          console.log(response);
          Swal.fire('', 'Add to cart successfully !', 'success');
          this.router.navigate(['/cart']);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
