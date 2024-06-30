import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth-service.service';
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
  u_data: any;
  page: number = 1;
  newProducts: any[] = [];
  saleProducts: any[] = [];
  carts: any[] = [];
  cartId: number = 1;
  blogs: any[] = [];


  // carts: any = this.userService.getCarts();
  home1 = '../../../assets/images/home1.jpg'
  home2 = '../../../assets/images/home2.jpg'
  home3 = '../../../assets/images/home3.jpg'


  instagram = [
    { id: 1, src: '../../assets/images/1.jpg', alt: 'image' },
    { id: 2, src: '../../assets/images/2.jpg', alt: 'image' },
    { id: 3, src: '../../assets/images/3.jpg', alt: 'image' },
    { id: 4, src: '../../assets/images/4.jpg', alt: 'image' },
    { id: 5, src: '../../assets/images/5.jpg', alt: 'image' },
    { id: 6, src: '../../assets/images/6.jpg', alt: 'image' },
    { id: 7, src: '../../assets/images/7.jpg', alt: 'image' },
    { id: 8, src: '../../assets/images/8.jpg', alt: 'image' },
  ]

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private blogService: BlogService,
    private router: Router,
    private authService: AuthService,
  ) {}

  ngOnInit(): void {
    this.getAllProductNew();
    this.getAllProductSale();
    this.getCarts();
    this.getAllBlog();
    this.u_data = this.getUData();
  }

  getUData(): any {
    const data = this.authService.getAccount();
    return data;
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
