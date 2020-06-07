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
 nombreUsuario: String = ""
 userData: UsuarioData;
  constructor() { }

   getProductos(): Producto[]{
    /*Busco todo los productos.*/
     return this.products;
    }

    getListaCompras():ListaDeCompras{
    return this.userData.listaDeCompras;
    }

    actualizarProductosEnCarrito(){
    this.productosEnCarrito = this.getListaCompras().productosAcumulados;
    console.log("Cant Productos en carrito:", this.productosEnCarrito.length);
    }
}
