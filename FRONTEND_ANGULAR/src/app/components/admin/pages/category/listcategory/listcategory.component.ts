import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category.model';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listcategory',
  templateUrl: './listcategory.component.html',
  styleUrls: ['./listcategory.component.css']
})
export class ListcategoryComponent implements OnInit {
  page: number = 1;
  data: Category[] = [];
  keywords: any;

  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });

  constructor(private categoryService: CategoryService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.categoryService.findAll().subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, err => {
      console.log(err);
    })
  }

  getByName(keyword: any) {
    this.categoryService.search(keyword).subscribe((response: any) => {
      console.log(response.data);
      this.data = response.data;
    }, (err:any) => {
      console.log(err);
    })
  }

  handleChange(e: any) {
    console.warn(e.target.value)
    this.keywords = e.target.value;
    if (this.keywords) {
      this.getByName(this.keywords);
    } else {
      this.getAll();
    }
  }

  onEditCategory(categoryId: any) {
    this.router.navigate([`admin/category/edit/${categoryId}`]);
  }

  onDeleteCategory(id: any) {
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
        this.categoryService.delete(id).subscribe((res: any) => {
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
