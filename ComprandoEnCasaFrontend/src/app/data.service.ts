import { Injectable } from '@angular/core';
import { Producto } from './producto';

@Injectable({
  providedIn: 'root'
})
export class DataService {

 products: Producto[] =[];
 productosEnCarrito: Producto[] =[];
  constructor() { }

   getProductos(): Producto[]{
    /*Busco todo los productos.*/
     return this.products;
    }
}
