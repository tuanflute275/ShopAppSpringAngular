import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private URL_API = 'http://localhost:8080/cart';


  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      // Authorization: 'my-auth-token'
    }),
  };


  constructor(private httpClient: HttpClient) { }

  public findAll(): Observable<any> {
    const url = `${this.URL_API}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }
  public findById(id: number): Observable<any> {
    const url = `${this.URL_API}/${id}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }
  public save(productId: number, quantity: number): Observable<any> {
    const url = `${this.URL_API}/${productId}/${quantity}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }
  public update(cartId: number, productId: number, quantity: number, totalAmount: number): Observable<any> {
    const url = `${this.URL_API}/${cartId}/${productId}/${quantity}/${totalAmount}`
    return this.httpClient.put<any>(url, this.httpOptions)
  }
  public updateQuantity(cartId: number): Observable<any> {
    const url = `${this.URL_API}/${cartId}`
    return this.httpClient.put<any>(url, this.httpOptions)
  }
  public delete(cartId: number): Observable<any> {
    const url = `${this.URL_API}/${cartId}`
    return this.httpClient.delete<any>(url, this.httpOptions)
  }
}
