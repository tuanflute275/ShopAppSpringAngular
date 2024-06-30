import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-my-order',
  templateUrl: './my-order.component.html',
  styleUrls: ['./my-order.component.css']
})
export class MyOrderComponent implements OnInit{
  page: number = 1;
  data: any = [];
  product: any;

  constructor(
    private orderService: OrderService,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

    ngOnInit(): void {
      this.getAll()
    }

    getAll() {
      this.orderService.findAll().subscribe((response: any) => {
        console.log(response.data);
        this.data = response.data;
      }, (err:any) => {
        console.log(err);
      })
    }

    OnDetailProduct(productId: any){
      this.productService.findById(productId).subscribe(response => {
        // console.log(response.data[0])
        this.product = response.data[0];
      })
    }
}
