import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { CouponService } from 'src/app/services/coupon.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  data: any[] = [];
  quantity: number = 1;
  totalCart: number = 1;
  totalAmount: number = 1;
  discount: number = 0;
  percentDiscount: number = 0;
  myGroup: any = new FormGroup({
    coupon: new FormControl(''),
  });

  constructor(
    private cartService: CartService,
    private couponService: CouponService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAll();
  }

  handleCoupon() {
    let coupon = this.myGroup.value.coupon;
    this.couponService
      .applyCoupon(coupon, this.totalCart)
      .subscribe((response) => {
        console.log(response.data);
        if (
          response.data == 'Coupon not found' ||
          response.data == 'Coupon is not active'
        ) {
          this.totalAmount = this.totalCart;
          Swal.fire({
            icon: 'error',
            title: 'Ôi không...',
            text: 'Voucher đã hết hạn hoặc không tồn tại !',
            footer: '<a href="/coupon">Nhận thêm mã giảm giá ?</a>',
          });
        } else {
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Áp dụng voucher thành công',
            showConfirmButton: false,
            timer: 1500,
          });
          this.totalAmount = Math.round(response.data);
          this.discount = Math.round(
            this.totalCart - Math.round(response.data)
          );
          this.percentDiscount = (this.discount / this.totalCart) * 100;
        }
      });
  }

  onCheckout() {
    if (this.data.length == 0) {
      Swal.fire({
        icon: 'error',
        title: 'Ôi không...',
        text: 'Chưa có sản phẩm để thanh toán, hãy tiếp tục mua sắm nhé !',
      });
    } else {
      this.router.navigate([`/checkout/${this.totalAmount}`]);
    }
  }

  getAll() {
    this.cartService.findAll().subscribe((response) => {
      console.log(response.data);
      this.data = response.data;
      const arrayTotal = response.data.map((i: any) => i.totalAmount);
      const initialValue = 0;
      const sumWithInitial = arrayTotal.reduce(
        (accumulator: any, currentValue: any) => accumulator + currentValue,
        initialValue
      );
      this.totalCart = sumWithInitial;
      this.totalAmount = sumWithInitial;
      console.log(sumWithInitial);
    });
  }

  getDetailProduct(productId: any) {
    this.router.navigate([`product/${productId}`]);
  }

  updateQuantity(item: any, e: any, totalAmout: number) {
    let newQuantity = e.target.value;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    newQuantity = newQuantity <= 100 ? newQuantity : 100;
    this.cartService
      .update(item.cartId, item.product.productId, this.quantity, totalAmout)
      .subscribe((response) => {
        this.getAll();
      });
  }

  handleMinus(item: any, quantity: number, totalAmout: number) {
    let newQtt = quantity - 1;
    newQtt = newQtt > 0 ? newQtt : 1;
    newQtt = newQtt <= 100 ? newQtt : 100;
    this.quantity = newQtt;
    this.cartService
      .update(
        item.cartId,
        item.product.productId,
        this.quantity,
        (item.product.productSalePrice > 0
          ? item.product.productSalePrice
          : item.product.productPrice) * this.quantity
      )
      .subscribe((response) => {
        this.getAll();
      });
  }
  handlePlus(item: any, quantity: number, totalAmout: number) {
    let newQtt = quantity + 1;
    newQtt = newQtt > 0 ? newQtt : 1;
    newQtt = newQtt <= 100 ? newQtt : 100;
    this.quantity = newQtt;
    this.cartService
      .update(
        item.cartId,
        item.product.productId,
        this.quantity,
        (item.product.productSalePrice > 0
          ? item.product.productSalePrice
          : item.product.productPrice) * this.quantity
      )
      .subscribe((response) => {
        this.getAll();
      });
  }
  removeCart(cartId: any) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.cartService.delete(cartId).subscribe((response) => {
          this.getAll();
        });

        Swal.fire('Deleted!', 'Your file has been deleted.', 'success');
      }
    });
  }
  onPay() {
    this.cartService.pay().subscribe((response) => {
      window.location.href = response.data;
    });
  }
}
