import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "../services/auth-service.service";
import { ToastrService } from 'ngx-toastr';
import Swal from "sweetalert2";

@Injectable({
  providedIn: 'root'
})

export class AuthGuard implements CanActivate{
  constructor(private authService: AuthService, private router: Router, private toastr: ToastrService){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if(this.authService.getToken() != null){
      const role = route.data["roles"] as Array<string>;
      if(role){
          const match = this.authService.roleMatch(role);
          if(match){
            return true;
          }else{
            Swal.fire({
              position: "top-end",
              icon: "error",
              title: "Bạn không có quyền",
              showConfirmButton: false,
              timer: 1500
            });
            this.router.navigate(['/login']);
            return false;
          }
      }
    }

    return false;
  }

}
