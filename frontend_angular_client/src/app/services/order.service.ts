import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private URL_API = `${environment.apiBaseUrl}/order`;

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      // Authorization: 'my-auth-token'
    }),
  };


  constructor(private httpClient: HttpClient) { }
  public findAllByAdmin(): Observable<any> {
    const url = `${this.URL_API}/all`
    return this.httpClient.get<any>(url, this.httpOptions)
  }
  public findAll(): Observable<any> {
    const url = `${this.URL_API}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }

  public findById(id: number): Observable<any> {
    const url = `${this.URL_API}/${id}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }

  public search(orderName: string): Observable<any> {
    const url = `${this.URL_API}?key=${orderName}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }

  public save(data: any): Observable<any> {
    const url = `${this.URL_API}/`
    return this.httpClient.post<any>(url, data, this.httpOptions)
  }

  public updateStatus(orderId: number, status: any): Observable<any> {
    const url = `${this.URL_API}/${orderId}/${status}`
    return this.httpClient.put<any>(url, this.httpOptions)
  }

  public delete(orderId: number): Observable<any> {
    const url = `${this.URL_API}/${orderId}`
    return this.httpClient.delete<any>(url, this.httpOptions)
  }
}
