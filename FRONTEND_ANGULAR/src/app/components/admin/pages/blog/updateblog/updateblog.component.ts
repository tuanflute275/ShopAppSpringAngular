import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BlogService } from 'src/app/services/blog.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-updateblog',
  templateUrl: './updateblog.component.html',
  styleUrls: ['./updateblog.component.css']
})
export class UpdateblogComponent implements OnInit{
  imgUrl:any;
  data: any = [];
  blogFormPost: any = FormGroup;
  id: number = this.route.snapshot.params['id'];
  fileName:string = '';
  imageDefault = '../../../../../../assets/images/add-image-icon.jpg';

  constructor(
    private formBuilder: FormBuilder,
    private blogService: BlogService,
    private router: Router,
    private route: ActivatedRoute,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.getOneProduct(this.id);
  }

  getOneProduct(id: number) {
    this.blogService.findById(id).subscribe((response: any) => {
      console.warn(response.data.blogImage);
      this.imgUrl = response.data.blogImage;
      this.blogFormPost = new FormGroup({
        image: new FormControl(response.data.blogImage),
        title: new FormControl(response.data.blogTitle),
        description: new FormControl(response.data.blogDescription),
      });
    });
  }

  onFileChange(event: any){
    if(event.target.files.length>0){
      const file:File = event.target.files[0];
      if(file.type == 'image/png' || file.type == 'image/jpeg'){
        const formData = new FormData();
        formData.append('image', file);
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
    console.log(data);
    this.blogService.update(this.id, data).subscribe((response: any) => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Update Successfully !',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigate(['/admin/blog']);
    }, (error:any) => {
      console.log(error)
    }
    )
  }
}
