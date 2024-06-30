import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category.model';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  data: Category[] = [];
  productFormPost: any = FormGroup;
  responseMessage: any;
  fileName:string = '';

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private categoryService: CategoryService,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.getAll();
    this.productFormPost = this.formBuilder.group({
      name: ['', [Validators.required]],
      price: ['', [Validators.required]],
      sale_price: ['', [Validators.required]],
      category_id: ['', [Validators.required]],
      status: ['1', [Validators.required]],
      description: ['', []],
    })
  }

  getAll() {
    this.categoryService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, (err:any) => {
      console.log(err);
    })
  }

  onFileChange(event: any){
    if(event.target.files.length>0){
      const file:File = event.target.files[0];
      if(file.type == 'image/png' || file.type == 'image/jpeg'){
        const formData = new FormData();
        formData.append('image', file);
        const upload$ = this.http.post("http://localhost:8080/upload-image/product", formData);
            upload$.subscribe((response: any) => {
              console.log(response.data)
              this.fileName = response.data
            });
      }else{
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'File không hợp lệ !',
          showConfirmButton: false,
          timer: 1500
        })
      }
    }
  }

  handleSubmit() {
    let formData = this.productFormPost.value;
    let data = {
      productName: formData.name,
      productImage: this.fileName,
      productPrice: formData.price,
      productSalePrice: formData.sale_price,
      productCategoryId: formData.category_id,
      productStatus: formData.status,
      productDescription: formData.description,
    }

    if (formData.sale_price < formData.price) {
      this.productService.save(data).subscribe((response: any) => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Add Successfully !',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/admin/product']);
      }, (error:any) => {
        console.log(error)
      })
    }else{
      Swal.fire({
        icon: "error",
        title: "Ôi Không...",
        text: "Giá khuyến mãi phải nhỏ hơn giá gốc!",
      });
    }
  }
}
