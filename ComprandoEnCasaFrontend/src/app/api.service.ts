import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from './producto';
import { UsuarioData } from './usuarioData';
import { ListaDeCompras } from './listaDeCompras';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  urlLOcal= 'http://localhost:8080/api/'

 constructor(private http: HttpClient) { }


  login(user: any): Observable<any>{
    return this.http.post(this.urlLOcal+'login', user);
  } 

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

 getUserData$(): Observable<HttpResponse<UsuarioData>> {
  /*Busco los datos de usuario.*/
   return this.http.get<UsuarioData>(
      this.urlLOcal+'usuario/1', { observe: 'response' });
      /* por ahora pongo /1 para obtener los datos del usuario con id 1, pero esto no va a quedar asi, hay que cambiarlo en el futuro y
       agarrar los datos del usuario con el cual se logea el cliente. */
  }

 agregarProductoACarritoAPI$(id: any, idProducto: any,listaDeCompras: ListaDeCompras): Observable<HttpResponse<ListaDeCompras>> {
    let paramsIDProducto = new HttpParams().set('idProducto',idProducto);
    return this.http.put<ListaDeCompras>(this.urlLOcal + "listadecomprasAdd/"+id, listaDeCompras, { params:paramsIDProducto,observe: 'response' });

 }
 sacarProductoDelCarritoAPI$(id: any,idProducto: any,listaDeCompras: ListaDeCompras):Observable<HttpResponse<ListaDeCompras>>{
  let paramsIDProducto = new HttpParams().set('idProducto',idProducto);
  return this.http.put<ListaDeCompras>(this.urlLOcal + "listadecomprasDeleteProduct/"+id,listaDeCompras,{ params:paramsIDProducto,observe: 'response' });
 }


 actualizarPerfilUsuario(userData: UsuarioData){
 /*Llamo a la API para poder actualizar los datos del usuario*/
 return this.http.put<UsuarioData>(this.urlLOcal+"usuario/actualizarUsuario/"+userData.id,userData,{observe: 'response' });
 }

 CrearProductoForUsuario(producto:Producto,idUser:any): Observable<HttpResponse<UsuarioData>>{
   return this.http.post<UsuarioData>(this.urlLOcal+"crearProductosForComercio/"+idUser, producto, {observe: 'response' })
 }



 aplicarOfertaEnBebidasConDescuento(descuento: number): Observable<Producto[]>{
   let paramsConsulta = new HttpParams().set('q', 'Comida');
   paramsConsulta= paramsConsulta.append('d', descuento.toString());
   return this.http.put<Producto[]>(this.urlLOcal+"buscarPorCategoriaYAplicarOferta",{params:paramsConsulta, observe: 'response'})
 }


}
