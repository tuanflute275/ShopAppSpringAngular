import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CouponService } from 'src/app/services/coupon.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addcoupon',
  templateUrl: './addcoupon.component.html',
  styleUrls: ['./addcoupon.component.css']
})
export class AddcouponComponent {
  couponFormPost: any = FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private couponService: CouponService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.couponFormPost = this.formBuilder.group({
      code: ['', [Validators.required]],
      percent: [''],
      description: [''],
      active: ['1', [Validators.required]],
    })
  }

  handleSubmit() {
    let formData = this.couponFormPost.value;
    let data = {
      code: formData.code,
      percent: formData.percent,
      description: formData.description,
      active: formData.active,
    }
    // console.log(data)
    this.couponService.save(data).subscribe((response: any) => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Add Successfully !',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigate(['/admin/coupon']);
    }, (error) => {
     console.log(error)
    })
  }
}
