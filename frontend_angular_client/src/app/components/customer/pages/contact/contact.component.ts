import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css'],
})
export class ContactComponent {
  contactForm: any = FormGroup;

  constructor(
    private toastr: ToastrService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}
  ngOnInit(): void {
    this.contactForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      phone: ['', [Validators.required]],
      message: ['', [Validators.required]],
    });
  }

  handleSubmit() {
    let formData = this.contactForm.value;
    let data = {
      name: formData.name,
      email: formData.email,
      phone: formData.phone,
      message: formData.message,
    };

    if (
      data.name == '' ||
      data.email == '' ||
      data.phone == '' ||
      data.message
    ) {
      Swal.fire({
        position: 'top-end',
        icon: 'error',
        title: "Data empty !",
        showConfirmButton: false,
        timer: 1500
      })
    } else {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: "Success",
        showConfirmButton: false,
        timer: 1500
      })
    }
  }
}
