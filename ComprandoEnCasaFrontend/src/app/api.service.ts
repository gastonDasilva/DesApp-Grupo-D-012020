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
  /*Busco todo los productos.*/
   return this.http.get<Producto[]>(
      this.urlLOcal+'productos', { observe: 'response' });
  }

  getProductosByConsultaAPI$(consulta:string): Observable<HttpResponse<Producto[]>> {
  /*Busco los productos a partir de una consulta, por ahora busca por nonbre y marca.*/
    let paramsConsulta = new HttpParams().set('q',consulta);
    return this.http.get<Producto[]>(
     this.urlLOcal+'buscarProductos', { params:paramsConsulta, observe: 'response' });
  }


}
