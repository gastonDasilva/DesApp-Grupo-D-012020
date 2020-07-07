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
 historialDeCompras: ListaDeCompras[] = [];
 montoGastado: number = 0;
 nombreUsuario: String = ""
 userData: UsuarioData;
 userEsComercio: boolean =false;
 productosEnOferta: Producto[]=[];
  constructor() {}

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
      this.historialDeCompras = compras;
      this.userData.historialDeCompras = this.getHistorialDeCompras();
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
