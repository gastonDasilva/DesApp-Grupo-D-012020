import { Injectable } from '@angular/core';
import { Producto } from './producto';
import { UsuarioData } from './usuarioData';
import { ListaDeCompras } from './listaDeCompras';

@Injectable({
  providedIn: 'root'
})
export class DataService {

 products: Producto[] =[];
 productosEnCarrito: Producto[] =[];
 historialDeCompras: ListaDeCompras[];
 montoGastado: number = 0;
 nombreUsuario: String = ""
 userData: UsuarioData;
 userEsComercio: boolean =false;
 productosEnOferta: Producto[]=[];
 productosAcumulados: Producto[];
 productosCopia: Producto[];
  constructor() {}

    getProductosAcumulados(): Producto[]{
      return this.productosAcumulados;
    }

    setProductosAcumulados(productos: Producto[]){
      this.productosCopia = productos;
      this.productosAcumulados = this.productosCopia;
      this.productosCopia = [];
    }

    getProductosCopia(): Producto[]{
      return this.productosCopia;
    }

    setProductosCopia(productos: Producto[]){
      return this.productosCopia = productos;
    }

    getProductos(): Producto[]{
    /*Busco todo los productos.*/
     return this.products;
    }

    getProductosEnOferta(): Producto[]{
      return this.productosEnOferta;
    }
    
    getuserData(){
    return this.userData;
    }

    getHistorialDeCompras(): ListaDeCompras[]{
      return this.historialDeCompras;
    }

    setuserData(user: UsuarioData){
      return this.userData = user;
    }

    getListaCompras():ListaDeCompras{
    return this.userData.listaDeCompras;
    }

    setHistorialDeCompras(compras: ListaDeCompras[]){
      return this.historialDeCompras = compras;
    }

    getHistorialDeComprasDelUsuario(): ListaDeCompras[]{
      return this.userData.historialDeCompras;
    }

    actualizarHistorialDeCompras(){
      this.historialDeCompras = this.getHistorialDeComprasDelUsuario();
      console.log("Cant compras en historial:", this.historialDeCompras.length);
    }

    actualizarProductosEnCarrito(){
    this.productosEnCarrito = this.getListaCompras().productosAcumulados;
    console.log("Cant Productos en carrito:", this.productosEnCarrito.length);
    }

    actualizarMonto(monto: number){
      this.montoGastado = monto;
      console.log("El monto acumulado hasta el momento es de: ", this.montoGastado);
    }

    actualizarProductosConOferta(productos: Producto[]){
      return this.products = productos;
    }


}
