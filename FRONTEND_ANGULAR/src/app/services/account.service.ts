import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  // account admin
  private URL_API = 'http://localhost:8080/user';


    private httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        // Authorization: 'my-auth-token'
      }),
    };

    constructor(private httpClient: HttpClient) { }

    // account user
    public findAll(){
      const url = `${this.URL_API}`
      return this.httpClient.get<any>(url, this.httpOptions)
    }
    public search(data: any){
      const url = `${this.URL_API}?key=`+data
      return this.httpClient.get<any>(url, this.httpOptions)
    }

    public findByUserName(userName: string){
      const url = `${this.URL_API}/` + userName
      return this.httpClient.get<any>(url, this.httpOptions)
    }

    public update(userName : string,data: any){
      const url = `${this.URL_API}/` + userName
      return this.httpClient.put<any>(url,data, this.httpOptions)
    }

    public save(data: any){
      const url = `${this.URL_API}`
      return this.httpClient.post<any>(url,data, this.httpOptions)
    }

    public delete(data: any){
      const url = `${this.URL_API}/delete`
      return this.httpClient.post<any>(url,data, this.httpOptions)
    }

}
