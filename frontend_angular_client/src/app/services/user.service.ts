import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth-service.service';
import { jwtDecode } from "jwt-decode";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  token: any;
  tokenPayload: any;
  private URL_API = `${environment.apiBaseUrl}`;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      "No-Auth": "True"
      // Authorization: 'my-auth-token'
    }),
  };

  constructor(
    private httpClient: HttpClient,
    private authService: AuthService
  ) { }

  public resetPassword(userName : string){
    const url = `${this.URL_API}/reset-password/` + userName
    return this.httpClient.put<any>(url, this.httpOptions)
  }
  public changePassword(data : any){
    const url = `${this.URL_API}/change/password`;
    return this.httpClient.put<any>(url, data, this.httpOptions)
  }
  public signup(data: any): Observable<any> {
    const url = `${this.URL_API}/registerNewUser`;
    return this.httpClient.post<any>(url, data, this.httpOptions);
  }
  public login(data: any): Observable<any> {
    const url = `${this.URL_API}/authenticate`;
    return this.httpClient.post<any>(url, data, this.httpOptions);
  }
  public forgotPassword(data: any): Observable<any> {
    const url = `${this.URL_API}/send/email`;
    return this.httpClient.post<any>(url, data, this.httpOptions);
  }
  public resetPasswordWithEmail(data: any){
    const url = `${this.URL_API}/reset/password`;
    return this.httpClient.post<any>(url, data, this.httpOptions)
  }

  public logout(){
    localStorage.clear();
  }


}
