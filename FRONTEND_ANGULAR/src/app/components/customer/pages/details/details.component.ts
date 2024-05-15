import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  page: number = 1;
  product: any;
  category_id: any;
  productRelated: any[] = [];
  id: number = this.route.snapshot.params['id'];
  userData: any;
  quantity: number = 1;
  carts: any[] = [];
  checkProductInCart: boolean = false;
  cartId: number = 1;

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
      this.getCarts()
      this.productService.findById(this.id).subscribe((response: any) => {
        this.product = response.data[0];
        this.productService.getProductRelated(response.data[0].productId, response.data[0].productCategoryId).subscribe(response => {
          this.productRelated = response.data;
          console.log(response.data)
        })
      }, (err:any) => {
        console.log(err);
      });
  }

  getCarts(){
    this.cartService.findAll().subscribe(response => {
      this.carts = response.data
    })
  }

  getDetailProduct(productId:any){
    this.router.navigate([`product/${productId}`]);
  }

  getLocalStorage(): any {
    this.userData = JSON.parse(localStorage.getItem('u_data') as any) || {};
    // console.log("U Data: ", this.userData);
  }

  onAddToCart(productId: number) {
    this.carts.map((item: any) => {
      if(item.product.productId == productId)
        this.cartId = item.cartId
        this.checkProductInCart = true
    })

    if (this.cartId != 1) {
      this.cartService.updateQuantity(this.cartId).subscribe((response: any) => {
        console.log(response);
        Swal.fire(
          '',
          'Add to cart successfully !',
          'success'
        );
      }, (error) => {
        console.log(error);
      })
    } else {
      this.cartService.save(productId, 1).subscribe((response: any) => {
        console.log(response);
        Swal.fire(
          '',
          'Add to cart successfully !',
          'success'
        );
      }, (error) => {
        console.log(error);
      })
    }

  }

  onBuyNow(productId: number) {
    this.carts.map((item: any) => {
      if(item.product.productId == productId)
        this.cartId = item.cartId
        this.checkProductInCart = true
    })

    if (this.cartId != 1) {
      this.cartService.updateQuantity(this.cartId).subscribe((response: any) => {
        console.log(response);
        Swal.fire(
          '',
          'Add to cart successfully !',
          'success'
        );
        this.router.navigate(['/cart'])
      }, (error) => {
        console.log(error);
      })
    } else {
      this.cartService.save(productId, 1).subscribe((response: any) => {
        console.log(response);
        Swal.fire(
          '',
          'Add to cart successfully !',
          'success'
        );
        this.router.navigate(['/cart'])
      }, (error) => {
        console.log(error);
      })
    }

  }
}
