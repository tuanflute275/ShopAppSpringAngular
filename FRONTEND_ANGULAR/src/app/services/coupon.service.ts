import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CouponService {
  private URL_API = 'http://localhost:8080/coupon';


  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      // Authorization: 'my-auth-token'
    }),
  };


  constructor(private httpClient: HttpClient) { }

  public applyCoupon(couponCode: string, totalAmount: number): Observable<any> {
    const url = `${this.URL_API}/caculate?couponCode=${couponCode}&totalAmount=${totalAmount}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }
  public findAll(): Observable<any> {
    const url = `${this.URL_API}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }
  public findById(id: number): Observable<any> {
    const url = `${this.URL_API}/` + id
    return this.httpClient.get<any>(url, this.httpOptions)
  }
  public save(data: any): Observable<any> {
    const url = `${this.URL_API}/`
    return this.httpClient.post<any>(url, data, this.httpOptions)
  }
  public update(id: number, data: any): Observable<any> {
    const url = `${this.URL_API}/` + id
    return this.httpClient.put<any>(url, data, this.httpOptions)
  }
  public delete(id: number): Observable<any> {
    const url = `${this.URL_API}/` + id
    return this.httpClient.delete<any>(url, this.httpOptions)
  }

}
