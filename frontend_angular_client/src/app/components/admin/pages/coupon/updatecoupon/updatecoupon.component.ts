import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CouponService } from 'src/app/services/coupon.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-updatecoupon',
  templateUrl: './updatecoupon.component.html',
  styleUrls: ['./updatecoupon.component.css']
})
export class UpdatecouponComponent {
  couponFormUpdate = new FormGroup({
    code: new FormControl(''),
    percent: new FormControl(''),
    description: new FormControl(''),
    active: new FormControl('')
  });
  id: number = this.route.snapshot.params['id'];

  constructor(
    private formBuilder: FormBuilder,
    private couponService: CouponService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.getOneCoupon(this.id);
  }

  getOneCoupon(id: number) {
    this.couponService.findById(id).subscribe((response: any) => {
      this.couponFormUpdate = new FormGroup({
        code: new FormControl(response.data.code),
        percent: new FormControl(response.data.percent),
        description: new FormControl(response.data.description),
        active: new FormControl(response.data.active)
      });
    });
  }


  handleSubmit() {
    let formData = this.couponFormUpdate.value;
    let data = {
      code: formData.code,
      percent: formData.percent,
      description: formData.description,
      active: formData.active,
    }
    // console.log(data)
    this.couponService.update(this.id,data).subscribe((response: any) => {
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
