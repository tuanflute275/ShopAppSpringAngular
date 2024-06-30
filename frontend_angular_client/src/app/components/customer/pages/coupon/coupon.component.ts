import { Component, OnInit } from '@angular/core';
import { CouponService } from 'src/app/services/coupon.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-coupon',
  templateUrl: './coupon.component.html',
  styleUrls: ['./coupon.component.css']
})
export class CouponComponent implements OnInit{
  data: any[] = [];

  constructor(
    private couponService: CouponService
  ){}

  ngOnInit(): void {
    this.getAllCoupon();
  }

  getAllCoupon(){
    this.couponService.findAll().subscribe((response: any) => {
      // console.log(response.data)
      this.data = response.data;
    })
  }

  handleCopy(code: string){
    try {
      Swal.fire({
        position: "top-end",
        icon: "success",
        title: "Copy thành công",
        showConfirmButton: false,
        timer: 1500
      });
      navigator.clipboard.writeText(code)
    } catch (error) {
      console.error(error)
    }
  }
}
