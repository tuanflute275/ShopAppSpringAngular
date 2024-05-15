import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CouponService } from 'src/app/services/coupon.service';
import { CouponConditionService } from 'src/app/services/couponCondition.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-coupon-condition',
  templateUrl: './add-coupon-condition.component.html',
  styleUrls: ['./add-coupon-condition.component.css']
})
export class AddCouponConditionComponent {
  data: any[] = [];
  couponConditionFormPost: any = FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private couponService: CouponService,
    private couponConditionService: CouponConditionService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.getAll();
    this.couponConditionFormPost = this.formBuilder.group({
      coupon_id: ['', [Validators.required]],
      attribute: ['minimum_amount', [Validators.required]],
      operator: ['>', [Validators.required]],
      value: ['0', [Validators.required]],
      discount_amount: ['', [Validators.required]],
    })
  }

  getAll() {
    this.couponService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, (err:any) => {
      console.log(err);
    })
  }

  handleSubmit() {
    let formData = this.couponConditionFormPost.value;
    let data = {
      coupon_id: formData.coupon_id,
      attribute: formData.attribute,
      operator: formData.operator,
      value: formData.value,
      discount_amount: formData.discount_amount,
    }
    // console.log(data)
    this.couponConditionService.save(data).subscribe((response: any) => {
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
