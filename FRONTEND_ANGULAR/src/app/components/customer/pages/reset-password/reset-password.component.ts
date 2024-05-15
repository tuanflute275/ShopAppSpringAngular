import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth-service.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent {
  dataFormPost: any = FormGroup;
  responseMessage: any;
  token: string = this.route.snapshot.params['token'];

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
   
    this.dataFormPost = this.formBuilder.group({
      password: ['', [Validators.required, Validators.minLength(6)]],
    })

  }

  handleSubmit() {
    let formData = this.dataFormPost.value;
    let data = {
      newpassword: formData.password,
      token: this.token
    }
    
    console.log(data);
    this.userService.resetPasswordWithEmail(data).subscribe(
      (response: any) => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Reset password successfully !',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/login'])
      },
      (error:any) => {
       console.log(error)
      }
    );
  }
}
