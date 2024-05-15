import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { BlogService } from 'src/app/services/blog.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addblog',
  templateUrl: './addblog.component.html',
  styleUrls: ['./addblog.component.css']
})
export class AddblogComponent implements OnInit{
  data: any = [];
  blogFormPost: any = FormGroup;
  fileName:string = '';

  constructor(
    private formBuilder: FormBuilder,
    private blogService: BlogService,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.blogFormPost = this.formBuilder.group({
      title: ['', [Validators.required]],
      description: ['', []],
    })
  }

  onFileChange(event: any){
    // console.log(event.target.files)
    if(event.target.files.length>0){
      const file:File = event.target.files[0];
      // console.log(file)
      if(file.type == 'image/png' || file.type == 'image/jpeg'){
        const formData = new FormData();
        formData.append('image', file);
        // console.log(formData)
        const upload$ = this.http.post("http://localhost:8080/upload-image/blog", formData);
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
    let formData = this.blogFormPost.value;
    let data = {
      blogTitle: formData.title,
      blogImage: this.fileName,
      blogDescription: formData.description,
    }
    console.log(data)
    this.blogService.save(data).subscribe((response: any) => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Add Successfully !',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigate(['/admin/blog']);
    }, (error) => {
     console.log(error)
    }
    )
  }
}
