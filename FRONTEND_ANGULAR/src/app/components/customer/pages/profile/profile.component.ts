import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import Swal from 'sweetalert2';
import { UserService } from 'src/app/services/user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  gender: any;
  username: any = this.route.snapshot.params['username'];
  passwordFormPost: any = FormGroup;
  imgUrl:string = '';
  fileName:string = '';
  imageDefault = '../../../../../assets/images/default.png';

  dataFormPost = new FormGroup({
    userName: new FormControl(''),
    userFullName: new FormControl(''),
    userEmail: new FormControl(''),
    userPhoneNumber: new FormControl(''),
    userAddress: new FormControl(''),
  })

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder,
    private accountService: AccountService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ){ }

  ngOnInit(): void {
    this.getOneProduct(this.username)
    this.passwordFormPost = this.formBuilder.group({
      currentPassword: ['', [Validators.required, Validators.minLength(6)]],
      newPassword: ['', [Validators.required, Validators.minLength(6)]],
      passwordConfirm: ['', [Validators.required, Validators.minLength(6)]],
    })
  }


  getOneProduct(username: any) {
    this.accountService.findByUserName(username).subscribe((response: any) => {
      console.warn(response.data);
      this.imgUrl = response.data.userAvatar;
      this.gender = response.data.userGender;
      this.dataFormPost = new FormGroup({
        userName: new FormControl(response.data.userName),
        userFullName: new FormControl(response.data.userFullName),
        userEmail: new FormControl(response.data.userEmail),
        userPhoneNumber: new FormControl(response.data.userPhoneNumber),
        userAddress: new FormControl(response.data.userAddress),
      });
    });
  }

  onItemChange(event: any){
    this.gender = event.target.value;
 }

 handleChangePassword(){
  let formData = this.passwordFormPost.value;
  let data = {
    currentPassword: formData.currentPassword,
    newPassword: formData.newPassword
  }
  if(formData.newPassword !== formData.passwordConfirm){
    Swal.fire({
      position: "top-end",
      icon: "error",
      title: "Mật khẩu không trùng nhau",
      showConfirmButton: false,
      timer: 1500
    });
  }else{
    this.userService.changePassword(data).subscribe(response => {
      Swal.fire({
        position: "top-end",
        icon: "success",
        title: response.message,
        showConfirmButton: false,
        timer: 1500
      });
    })
  }
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

  handleSubmit(){
    let formData = this.dataFormPost.value;

    let data = {
      userName: formData.userName,
      userFullName: formData.userFullName,
      userAvatar: this.fileName != '' ? this.fileName : this.imgUrl,
      userEmail: formData.userEmail,
      userPhoneNumber: formData.userPhoneNumber,
      userAddress: formData.userAddress,
      userGender: this.gender,
      userActive: 0
    }
    // console.warn(data)
    this.accountService.update(this.username, data).subscribe(response=>{
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Update Successfully !',
        showConfirmButton: false,
        timer: 1500
      })
    },(error:any) => {
        console.log(error)
      })
  }
}
