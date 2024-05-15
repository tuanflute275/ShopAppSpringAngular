import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-updateorder',
  templateUrl: './updateorder.component.html',
  styleUrls: ['./updateorder.component.css']
})
export class UpdateorderComponent implements OnInit{
  data: any[] = [];
  status: any;
  userFullName: string = '';

  orderFormPost = new FormGroup({
    user: new FormControl(''),
  })

  id: number = this.route.snapshot.params['id'];

  constructor(
    private orderService: OrderService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.getOneProduct(this.id);
  }

  getOneProduct(id: number) {
    this.orderService.findById(id).subscribe((response: any) => {
      // console.warn(response.data.orderFullName);
      this.status = response.data.orderStatus;
      this.userFullName = response.data.orderFullName;
    });
  }

  onItemChange(event: any){
    this.status = event.target.value;
  }

  handleSubmit() {
    this.orderService.updateStatus(this.id, this.status).subscribe(
      (response: any) => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Update Successfully !',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/admin/order'])
      }, (error: any) => {
        console.log(error);
      })
  }
}
