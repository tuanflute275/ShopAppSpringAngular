import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editcategory',
  templateUrl: './updatecategory.component.html',
  styleUrls: ['./updatecategory.component.css']
})
export class UpdatecategoryComponent implements OnInit {
  categoryFormUpdate = new FormGroup({
    name: new FormControl(''),
    status: new FormControl('')
  });
  id: number = this.route.snapshot.params['id'];
  responseMessage: any;
  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getOneCategory(this.id);
  }

  getOneCategory(id: number) {
    this.categoryService.findById(id).subscribe((response: any) => {
      this.categoryFormUpdate = new FormGroup({
        name: new FormControl(response.data.categoryName),
        status: new FormControl(response.data.categoryStatus)
      });
    });
  }

  handleSubmit() {
    let formData = this.categoryFormUpdate.value;
    let data = {
      categoryName: formData.name,
      categoryStatus: formData.status
    }
    this.categoryService.update(this.id, data).subscribe(
      (response: any) => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Update Successfully !',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/admin/category'])
      }, (error: any) => {
        console.log(error);
      })
  }
}
