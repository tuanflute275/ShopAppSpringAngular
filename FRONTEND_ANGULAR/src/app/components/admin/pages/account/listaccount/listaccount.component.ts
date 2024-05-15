import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listaccount',
  templateUrl: './listaccount.component.html',
  styleUrls: ['./listaccount.component.css']
})
export class ListaccountComponent implements OnInit{
  key:number = 1;
  page: number = 1;
  data: any = [];
  keywords: any;
  myGroup: any = new FormGroup({
    keywords: new FormControl(''),
  });
  imageDefault = '../../../../../assets/images/default.png';

  constructor(
    private accountService: AccountService,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAll()
  }


  getAll() {
    this.accountService.findAll().subscribe((response: any) => {
      console.warn(response.data);
      this.data = response.data;
    }, err => {
      console.log(err);
    })
  }

  getByName(keyword: any) {
    this.accountService.search(keyword).subscribe((response: any) => {
      console.log(response.data);
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
  onEditAccount(username: any) {
    this.router.navigate([`admin/account/edit/${username}`]);
  }

  onDeleteAccount(account: any) {
    let data = {
      userName: account.userName,
      userFullName: account.userFullName,
      userEmail: account.userEmail,
      userPassword: account.userPassword
    }
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
        this.accountService.delete(data).subscribe((response: any) => {
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

  onResetPassword(username: string){
    this.userService.resetPassword(username).subscribe((response: any)=>{
      Swal.fire({
        title: "Mật khẩu mới của bạn là !",
        text: response.data,
        icon: "success"
      });
    })
  }

}
