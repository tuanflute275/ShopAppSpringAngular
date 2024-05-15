import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addaccount',
  templateUrl: './addaccount.component.html',
  styleUrls: ['./addaccount.component.css']
})
export class AddaccountComponent implements OnInit{
  accountFormPost: any = FormGroup;
  gender: number = 0;
  fileName:string = '';

  constructor(
    private formBuilder: FormBuilder,
    private accountService: AccountService,
    private userService: UserService,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.accountFormPost = this.formBuilder.group({
      userName: ['', [Validators.required]],
      userFullName: ['', [Validators.required]],
      userEmail: ['', [Validators.required, Validators.email]],
      userPassword: ['', [Validators.required, Validators.minLength(6)]],
      userPhoneNumber: ['', [Validators.required]],
      userAddress: ['', [Validators.required]],
    })
  }

  onItemChange(event: any){
    this.gender = event.target.value;
  }

  onFileChange(event: any){
    if(event.target.files.length>0){
      const file:File = event.target.files[0];
      if(file.type == 'image/png' || file.type == 'image/jpeg'){
        const formData = new FormData();
        formData.append('image', file);
        const upload$ = this.http.post("http://localhost:8080/upload-image/avatar", formData);
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
    let formData = this.accountFormPost.value;
    let data = {
      userName: formData.userName,
      userFullName: formData.userFullName,
      userAvatar: this.fileName,
      userEmail: formData.userEmail,
      userPassword: formData.userPassword,
      userPhoneNumber: formData.userPhoneNumber,
      userAddress: formData.userAddress,
      userGender: this.gender,
      userActive: 0
    }
    console.log(data);
    this.userService.signup(data).subscribe((response: any) => {
      Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Register Successfully !',
            showConfirmButton: false,
            timer: 1500
          })
      this.router.navigate(['/admin/account']);
    }, (error:any) => {
     console.log(error)
    }
    )
  }
}
