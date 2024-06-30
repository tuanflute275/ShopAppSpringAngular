import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AuthService } from 'src/app/services/auth-service.service';
import { FormControl, FormGroup } from '@angular/forms';
import { AccountService } from 'src/app/services/account.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  data: any;
  u_data: any;
  keywords: any;
  dataCountMessage:number = 1;

  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });

  constructor(
    private authService: AuthService,
    private accountService: AccountService,
    private userService: UserService,
    private router: Router

  ) { }

  ngOnInit(): void {
    this.u_data = this.getUData();
    this.getAllUser()
  }

  getAllUser(){
    this.accountService.findAll().subscribe((response: any) => {
      console.warn(response.data);
      this.data = response.data;
      this.dataCountMessage = response.data.length;
    }, err => {
      console.log(err);
    })
  }

  getUData(): any {
    const data = this.authService.getAccount();
    return data;
  }

  handleChange(e: any) {
    this.keywords = e.target.value;
  }



  handleSearch(){
    this.router.navigate(['/admin/product/search/' + this.keywords])
  }

  logout(){
    this.userService.logout()
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Logout Successfully !',
      showConfirmButton: false,
      timer: 1500
    })
    this.router.navigate(['/login'])
  }

}
