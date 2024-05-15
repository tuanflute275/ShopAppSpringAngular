import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth-service.service';
import { OrderService } from 'src/app/services/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit{
  u_data: any;
  dataFormPost: any = FormGroup;
  current_time: any;
  amount: any = this.route.snapshot.params['amount'];

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private orderService: OrderService,
    private authService: AuthService,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    var today = new Date();
    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    this.current_time = date + " " + time;
    this.u_data = this.getUData();
    this.dataFormPost = this.formBuilder.group({
      fullName: ['', [Validators.required]],
      fullAddress: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required]],
      email: ['', [Validators.required]],
      date: ['', [Validators.required]],
      paymentMethods: ['', [Validators.required]],
      statusPayment: ['', [Validators.required]],
      status: ['', [Validators.required]],
      note: ['', [Validators.required]],
    })
  }

  handleSubmit() {
    let formData = this.dataFormPost.value;
    let data = {
      orderFullName: formData.fullName,
      orderAddress: formData.fullAddress,
      orderPhoneNumber: formData.phoneNumber,
      orderEmail: formData.email,
      orderDate: this.current_time,
      orderPaymentMethods: "Thanh toán khi giao hàng",
      orderStatusPayment: "Chưa thanh toán",
      orderStatus: 1,
      orderAmount: this.amount,
      orderNote: formData.note
    }

    if(data.orderFullName == '' || data.orderAddress == '' || data.orderPhoneNumber == '' || data.orderEmail == ''){
      Swal.fire({
        position: 'top-end',
          icon: 'error',
          title: 'Không có thông tin !',
          showConfirmButton: false,
          timer: 1500
      })
    }else{
      console.log(data)
      this.orderService.save(data).subscribe((response: any) => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Add Successfully !',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/']);
      }, (error) => {
       console.log(error)
      }
      )
    }
  }

  getUData(): any {
    const data = this.authService.getAccount();
    return data;
  }

  onOrder(){

  }

}
