import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BlogService } from 'src/app/services/blog.service';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.css']
})
export class BlogDetailComponent implements OnInit{
  blog: any;
  id: any = this.route.snapshot.params['id'];
  imageDefault = '../../../../../../assets/images/add-image-icon.jpg';

  constructor(
    private blogService: BlogService,
    private route: ActivatedRoute,
  ){}

  ngOnInit(): void {
    this.getOneBlog(this.id);
  }

  getOneBlog(blogId: number){
    this.blogService.findById(blogId).subscribe(response => {
      console.log(response.data)
      this.blog = response.data;
    })
  }
}
