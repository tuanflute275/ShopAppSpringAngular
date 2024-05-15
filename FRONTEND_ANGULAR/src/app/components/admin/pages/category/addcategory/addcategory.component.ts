import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})

export class AddcategoryComponent implements OnInit {
  categoryFormPost: any = FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private categoryService: CategoryService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.categoryFormPost = this.formBuilder.group({
      name: ['', [Validators.required]],
      status: ['1', [Validators.required]],
    })
  }

  handleSubmit() {
    let formData = this.categoryFormPost.value;
    let data = {
      categoryName: formData.name,
      categoryStatus: formData.status
    }
    this.categoryService.save(data).subscribe((response: any) => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Add Successfully !',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigate(['/admin/category']);
    }, (error) => {
     console.log(error)
    }
    )
  }
}
