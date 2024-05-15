import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.css']
})
export class ListproductComponent implements OnInit {
  page: number = 1;
  data: any = [];
  keywords: any;
  imageDefault = '../../../../../../assets/images/add-image-icon.jpg';
  key_search = this.route.snapshot.params['keyword'];
  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.getAll()
  }

  search(){
    if(this.key_search){
      this.getByName(this.key_search)
    }else if(this.key_search === 'undefined'){
      this.getAll();
    }else{
      this.getAll();
    }
  }

  getAll() {
    this.productService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, (err:any) => {
      console.log(err);
    })
  }

  getByName(keyword: any) {
    this.productService.search(keyword).subscribe((response: any) => {
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

  onEditProduct(productId: any) {
    this.router.navigate([`admin/product/edit/${productId}`]);
  }

  onDeleteProduct(id: any) {
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
        this.productService.delete(id).subscribe((res: any) => {
          console.log(res);
          this.getAll();
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
