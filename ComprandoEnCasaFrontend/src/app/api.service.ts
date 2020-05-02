import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from './producto';


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  urlLOcal= 'http://localhost:8080/api/'

 constructor(private http: HttpClient) { }


  getProductosAPI$(): Observable<HttpResponse<Producto[]>> {
   return this.http.get<Producto[]>(
      this.urlLOcal+'productos', { observe: 'response' });
  }

}
