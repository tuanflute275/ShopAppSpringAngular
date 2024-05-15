import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CouponService } from 'src/app/services/coupon.service';
import { CouponConditionService } from 'src/app/services/couponCondition.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-coupon-condition',
  templateUrl: './update-coupon-condition.component.html',
  styleUrls: ['./update-coupon-condition.component.css']
})
export class UpdateCouponConditionComponent implements OnInit{
  couponConditionFormUpdate = new FormGroup({
    coupon_id: new FormControl(''),
    attribute: new FormControl(''),
    operator: new FormControl(''),
    value: new FormControl(''),
    discount_amount: new FormControl('')
  });
  id: number = this.route.snapshot.params['id'];

  constructor(
    private formBuilder: FormBuilder,
    private couponService: CouponService,
    private couponConditionService: CouponConditionService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.getOneCouponCondition(this.id);
  }

  getOneCouponCondition(id: number) {
    this.couponConditionService.findById(id).subscribe((response: any) => {
      this.couponConditionFormUpdate = new FormGroup({
        coupon_id: new FormControl(response.data.coupon_id),
        attribute: new FormControl(response.data.attribute),
        operator: new FormControl(response.data.operator),
        value: new FormControl(response.data.value),
        discount_amount: new FormControl(response.data.discount_amount)
      });
    });
  }

  handleSubmit() {
    let formData = this.couponConditionFormUpdate.value;
    let data = {
      coupon_id: formData.coupon_id,
      attribute: formData.attribute,
      operator: formData.operator,
      value: formData.value,
      discount_amount: formData.discount_amount,
    }
    // console.log(data)
    this.couponConditionService.update(this.id,data).subscribe((response: any) => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Add Successfully !',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigate(['/admin/couponCondition']);
    }, (error) => {
     console.log(error)
    })
  }
}
