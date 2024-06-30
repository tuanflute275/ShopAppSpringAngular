import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BlogService } from 'src/app/services/blog.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit{
  data: any[] = [];
  page: number = 1;
  imageDefault = '../../../../../../assets/images/add-image-icon.jpg';

  constructor(
    private blogService: BlogService,
    private router: Router
  ){}

  ngOnInit(): void {
    this.getAllBlog();
  }

  getAllBlog(){
    this.blogService.findAll().subscribe((response: any) => {
      console.log(response.data)
      this.data = response.data;
    })
  }

  getDetailBlog(blogId: any){
    this.router.navigate([`/blogDetail/${blogId}`]);
  }
}
