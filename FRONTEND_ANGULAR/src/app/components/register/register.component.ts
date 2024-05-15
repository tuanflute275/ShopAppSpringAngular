import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  dataFormPost: any = FormGroup;
  responseMessage: any;
  u_data: any;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService,
  ) { }

  ngOnInit(): void {
    this.dataFormPost = this.formBuilder.group({
      username: ['', [Validators.required,Validators.minLength(5)]],
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    })
  }

  handleSubmit() {
    let formData = this.dataFormPost.value;
    let data = {
      userName: formData.username,
      userFullName: formData.name,
      userEmail: formData.email,
      userPassword: formData.password
    }
    console.log(data);
    this.userService.signup(data).subscribe((response: any) => {
      this.responseMessage = response?.message;
      Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Register Successfully !',
            showConfirmButton: false,
            timer: 1500
          })
      this.router.navigate(['/login']);
    }, (error:any) => {
     console.log(error)
    }
    )
  }
}
