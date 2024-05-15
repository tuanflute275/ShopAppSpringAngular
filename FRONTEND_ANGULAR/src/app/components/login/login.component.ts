import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth-service.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  dataFormPost: any = FormGroup;
  responseMessage: any;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService,
  ) { }

  ngOnInit(): void {
   
    this.dataFormPost = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    })

  }

  handleSubmit() {
    let formData = this.dataFormPost.value;
    let data = {
      userName: formData.username,
      userPassword: formData.password,
    };
    this.userService.login(data).subscribe(
      (response: any) => {
        this.authService.setRoles(response.data.user.role);
        this.authService.setToken(response.data.jwtToken);
        this.authService.setAccount(response.data.user);
        console.log(response)
        console.log(response.status)
        if(response.data.jwtToken != ''){
          Swal.fire({
            position: "top-end",
            icon: "success",
            title: response.data.message,
            showConfirmButton: false,
            timer: 1500
          });
        }else{
          Swal.fire({
            position: "top-end",
            icon: "error",
            title: response.data.message,
            showConfirmButton: false,
            timer: 1500
          });
        }
        const role = response.data.user.role[0].roleName;
        switch (role) {
          case 'Admin':
            return this.router.navigate(['/admin']);
          case 'User':
            return this.router.navigateByUrl('/');
          default:
            return this.router.navigateByUrl('/');
        }
      },
      (error:any) => {
        Swal.fire({
          position: "top-end",
          icon: "error",
          title: error.error.message,
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigate(['/login']);
       console.log(error)
      }
    );
    console.log(data);
  }

}
