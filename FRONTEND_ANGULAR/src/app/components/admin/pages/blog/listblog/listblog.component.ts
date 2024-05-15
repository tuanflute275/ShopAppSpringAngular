import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BlogService } from 'src/app/services/blog.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listblog',
  templateUrl: './listblog.component.html',
  styleUrls: ['./listblog.component.css']
})
export class ListblogComponent implements OnInit{
  page: number = 1;
  data: any = [];
  keywords: any;
  imageDefault = '../../../../../../assets/images/add-image-icon.jpg';

  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });

  constructor(
    private blogService: BlogService,
    private router: Router,
    private formBuilder: FormBuilder) { }

    ngOnInit(): void {
      this.getAll();
    }

    getAll() {
      this.blogService.findAll().subscribe((response: any) => {
        console.log(response.data)
        this.data = response.data;
      }, (err:any) => {
        console.log(err);
      })
    }

    getByName(keyword: any) {
      this.blogService.search(keyword).subscribe((response: any) => {
        console.warn(response.data);
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

    onEditBlog(categoryId: any) {
      this.router.navigate([`admin/blog/edit/${categoryId}`]);
    }

    onDeleteBlog(id: any) {
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
          this.blogService.delete(id).subscribe((res: any) => {
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
