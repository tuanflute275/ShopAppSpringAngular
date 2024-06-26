import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private URL_API = `${environment.apiBaseUrl}/categories`;


  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      // Authorization: 'my-auth-token'
    }),
  };

  public exportPDF(): Observable<any> {
    const url = `${this.URL_API}/download`
    return this.httpClient.get<any>(url, this.httpOptions)
  }


  constructor(private httpClient: HttpClient) { }

  public findAll(): Observable<any> {
    const url = `${this.URL_API}`
    return this.httpClient.get<any>(url, this.httpOptions)
  }

  public findById(id: number): Observable<any> {
    const url = `${this.URL_API}/` + id
    return this.httpClient.get<any>(url, this.httpOptions)
  }

  public search(data: any): Observable<any> {
    const url = `${this.URL_API}?key=` + data
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
