import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.css']
})
export class UpdateproductComponent implements OnInit {
  data: any[] = [];
  imgUrl:any;
  categoryId:any;
  categoryName:any;
  fileName:string = '';
  imageDefault = '../../../../../../assets/images/add-image-icon.jpg';

  productFormPost = new FormGroup({
    name: new FormControl(''),
    price: new FormControl(''),
    sale_price: new FormControl(''),
    category_id: new FormControl('1'),
    status: new FormControl(''),
    description: new FormControl(''),
  })

  id: number = this.route.snapshot.params['id'];
  responseMessage: any;

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.getAllCategory();
    this.getOneProduct(this.id);
  }

  getAllCategory() {
    this.categoryService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, (err:any) => {
      console.log(err);
    })
  }

  getOneProduct(id: number) {
    this.productService.findById(id).subscribe((response: any) => {
      console.warn(response.data[0]);
      this.imgUrl = response.data[0].productImage;
      this.categoryId = response.data[0].productCategoryId;
      this.categoryName = response.data[0].productCategoryName;
      this.productFormPost = new FormGroup({
        name: new FormControl(response.data[0].productName),
        price: new FormControl(response.data[0].productPrice),
        sale_price: new FormControl(response.data[0].productSalePrice),
        category_id: new FormControl(response.data[0].productCategoryId),
        status: new FormControl(response.data[0].productStatus),
        description: new FormControl(response.data[0].productDescription),
      });
    });
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
      productImage: this.fileName != '' ? this.fileName : this.imgUrl,
      productPrice: formData.price,
      productSalePrice: formData.sale_price,
      productCategoryId: formData.category_id,
      productStatus: formData.status,
      productDescription: formData.description,
    }
    let s = data.productSalePrice ? data.productSalePrice : 0;
    let p = data.productPrice ? data.productPrice : 0;
    if (s < p) {
      this.productService.update(this.id, data).subscribe((response: any) => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Update Successfully !',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/admin/product']);
      }, (error:any) => {
        console.log(error)
      }
      )
    }else{
      Swal.fire({
        icon: "error",
        title: "Ôi Không...",
        text: "Giá khuyến mãi phải nhỏ hơn giá gốc!",
      });

    }
  }
}
