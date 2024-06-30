import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listorder',
  templateUrl: './listorder.component.html',
  styleUrls: ['./listorder.component.css']
})
export class ListorderComponent implements OnInit{
  page: number = 1;
  data: any = [];
  keywords: any;
  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });

  constructor(
    private orderService: OrderService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this.getAll()
    }

    getAll() {
      this.orderService.findAllByAdmin().subscribe((response: any) => {
        console.log(response.data);
        this.data = response.data;
      }, (err:any) => {
        console.log(err);
      })
    }

    getByName(keyword: any) {
      this.orderService.search(keyword).subscribe((response: any) => {
        console.log(response.data);
        this.data = response.data;
      }, (err:any) => {
        console.log(err);
      })
    }

    handleChange(e: any) {
      this.keywords = e.target.value;
      if (this.keywords) {
        this.getByName(this.keywords);
      } else {
        this.getAll();
      }
    }

    onEditOrder(orderId: any){
      this.router.navigate([`admin/order/edit/${orderId}`]);
    }

    onDetailOrder(orderId: any){
      this.router.navigate([`admin/order/detail/${orderId}`]);
    }

    onDeleteOrder(orderId: any) {
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
          this.orderService.delete(orderId).subscribe((res: any) => {
            console.log(res);
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
