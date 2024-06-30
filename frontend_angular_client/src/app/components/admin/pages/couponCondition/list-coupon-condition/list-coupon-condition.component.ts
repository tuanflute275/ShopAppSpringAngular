import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { CouponConditionService } from 'src/app/services/couponCondition.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-coupon-condition',
  templateUrl: './list-coupon-condition.component.html',
  styleUrls: ['./list-coupon-condition.component.css']
})
export class ListCouponConditionComponent implements OnInit{
  page: number = 1;
  data: any[] = [];

  constructor(
    private couponConditionService: CouponConditionService,
    private formBuilder: FormBuilder,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.couponConditionService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, err => {
      console.log(err);
    })
  }


  onEditCouponCondition(couponConditionId: any) {
    this.router.navigate([`admin/couponCondition/edit/${couponConditionId}`]);
  }

  onDeleteCouponCondition(id: any) {
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
        this.couponConditionService.delete(id).subscribe((res: any) => {
          this.getAll()
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
