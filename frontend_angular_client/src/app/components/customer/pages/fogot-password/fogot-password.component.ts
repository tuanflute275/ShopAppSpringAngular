import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth-service.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-fogot-password',
  templateUrl: './fogot-password.component.html',
  styleUrls: ['./fogot-password.component.css']
})
export class FogotPasswordComponent {
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
      email: ['', [Validators.required, Validators.email]],
    })

  }

  handleSubmit() {
    let formData = this.dataFormPost.value;
    let data = {
      sendEmail: formData.email,
      info: ""
    }
    
    console.log(data);
    this.userService.forgotPassword(data).subscribe(
      (response: any) => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: response.message,
          showConfirmButton: false,
          timer: 1500
        })
      },
      (error:any) => {
       console.log(error)
      }
    );
  }
}
