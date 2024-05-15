import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth-service.service';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  u_data: any;
  dataFormPost: any = FormGroup;
  countCart: number = 0;
  imageDefault = '../../../../../assets/images/default.png';

  constructor(
    private formBuilder: FormBuilder,
    private toastr: ToastrService,
    private router: Router,
    private userService: UserService,
    private authService: AuthService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.u_data = this.getUData();
    this.dataFormPost = this.formBuilder.group({
      keyword: ['', []],
    })
    this.cartService.findAll().subscribe(response => {
      this.countCart = response.data.length;
    })
  }

  getUData(): any {
    const data = this.authService.getAccount();
    return data;
  }

  onProfile(){
    this.router.navigate([`/profile/${this.u_data.userName}`]);
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
    setTimeout(()=>{
      window.location.reload()
    }, 1000)
  }

  handleSubmit() {
    this.router.navigate([`product/search/${this.dataFormPost.value.keyword}`]);
  }

}
