import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  page: number = 1;
  products: any[] = [];
  keywords: any;
  key_search = this.route.snapshot.params['keyword'];
  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) { }


  ngOnInit(): void {
    if(this.key_search !== undefined) {
      this.getByName(this.key_search)
      // window.location.reload()
    }else {
      this.getAll()
    }
  }

  getAll(){
    this.productService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.products = response.data;
    }, (err:any) => {
      console.log(err);
    });
  }

  getDetailProduct(productId:any){
    this.router.navigate([`product/${productId}`]);
  }

  getByName(keyword: any) {
    this.productService.search(keyword).subscribe((response: any) => {
      console.log(response.data);
      this.products = response.data;
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
}
