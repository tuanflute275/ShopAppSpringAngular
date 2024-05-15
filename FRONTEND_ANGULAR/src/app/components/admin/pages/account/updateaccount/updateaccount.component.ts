import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-updateaccount',
  templateUrl: './updateaccount.component.html',
  styleUrls: ['./updateaccount.component.css']
})
export class UpdateaccountComponent implements OnInit{
  accountFormPost: any = FormGroup;
  username: string = this.route.snapshot.params['username'];
  gender: any;
  fileName:string = '';
  imgUrl:string = '';
  imageDefault:string = '../../../../../assets/images/default.png';

  constructor(
    private formBuilder: FormBuilder,
    private accountService: AccountService,
    private router: Router,
    private route: ActivatedRoute,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.getOneAccount(this.username);
    console.warn(this.username)
  }

  getOneAccount(username: string) {
    this.accountService.findByUserName(this.username).subscribe((response: any) => {
      console.warn(response.data.userGender);
      this.imgUrl = response.data.userAvatar;
      this.gender = response.data.userGender;
      this.accountFormPost = new FormGroup({
        userName: new FormControl(response.data.userName),
        userFullName: new FormControl(response.data.userFullName),
        userEmail: new FormControl(response.data.userEmail),
        userPhoneNumber: new FormControl(response.data.userPhoneNumber),
        userAddress: new FormControl(response.data.userAddress),
        active: new FormControl(response.data.userActive),
      });
    });
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
      userAvatar: this.fileName != '' ? this.fileName : this.imgUrl,
      userEmail: formData.userEmail,
      userPassword: formData.userPassword,
      userPhoneNumber: formData.userPhoneNumber,
      userAddress: formData.userAddress,
      userGender: this.gender,
      userActive: formData.active,
    }
    console.log(data);

    this.accountService.update(this.username, data).subscribe((response: any) => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Update Successfully !',
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
