import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CouponService } from 'src/app/services/coupon.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listcoupon',
  templateUrl: './listcoupon.component.html',
  styleUrls: ['./listcoupon.component.css']
})
export class ListcouponComponent {
  page: number = 1;
  data: any[] = [];

  constructor(
    private couponService: CouponService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.couponService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, err => {
      console.log(err);
    })
  }


  onEditCoupon(couponId: any) {
    this.router.navigate([`admin/coupon/edit/${couponId}`]);
  }

  onDeleteCoupon(id: any) {
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.couponService.delete(id).subscribe((res: any) => {
          console.log(res);
          this.getAll();
        }, (err:any) => {
          console.log(err);
        })
        Swal.fire({
          title: "Deleted!",
          text: "Your file has been deleted.",
          icon: "success"
        });
      }
    });
  }
}
