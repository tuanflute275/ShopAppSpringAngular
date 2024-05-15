import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit{
  data: any[] = [];
  product: any;
  id: number = this.route.snapshot.params['id'];

  constructor(
    private orderService: OrderService,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.getOneOrder(this.id);
  }

  getOneOrder(id: number) {
    this.orderService.findById(id).subscribe((response: any) => {
      // console.warn(response.data.orderDetails);
      this.data = response.data.orderDetails;
      this.OnDetailProduct(1)
    });
  }

  OnDetailProduct(productId: any){
    this.productService.findById(productId).subscribe(response => {
      // console.log(response.data[0])
      this.product = response.data[0];
    })
  }
}
