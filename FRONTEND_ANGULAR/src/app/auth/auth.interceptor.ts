import { AuthService } from './../services/auth-service.service';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable, catchError, throwError } from 'rxjs';
import Swal from 'sweetalert2';


@Injectable()
export class AuthInterceptor implements HttpInterceptor{
  constructor(private authService: AuthService, private router: Router,private toastr: ToastrService){}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(req.headers.get("No-Auth") === "True"){
      return next.handle(req.clone());
    }
    const token = this.authService.getToken();

    req = this.addToken(req, token);

    return next.handle(req).pipe(
      catchError(
        (err: HttpErrorResponse) => {
          console.log(err.status);
          if(err.status === 401){
            // Swal.fire({
            //   position: "top-end",
            //   icon: "error",
            //   title: "Errrrrror 401 !",
            //   showConfirmButton: false,
            //   timer: 1500
            // });
            console.error("Errrrrror 401 !")
            localStorage.setItem("jwtToken", "");
            localStorage.setItem("account", "");
            localStorage.setItem("roles", "");
            this.router.navigate(['/']);
          }else if(err.status === 403){
            // Swal.fire({
            //   position: "top-end",
            //   icon: "error",
            //   title: "Errrrrror 403",
            //   showConfirmButton: false,
            //   timer: 1500
            // });
            console.error("Errrrrror 403 !")
            localStorage.setItem("jwtToken", "");
            localStorage.setItem("account", "");
            localStorage.setItem("roles", "");
            this.router.navigate(['/']);
          }
          return throwError("Some thing is wrong ");
        }
      )
    );
  }

  private addToken(request:HttpRequest<any>, token: string){
    return request.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    })
  }
}
