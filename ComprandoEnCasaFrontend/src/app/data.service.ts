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
 montoGastado: number = 0;
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

    actualizarMonto(monto: number){
      this.montoGastado = monto;
      console.log("El monto acumulado hasta el momento es de: ", this.montoGastado);
    }
}
