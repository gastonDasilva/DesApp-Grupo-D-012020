import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';
import { Producto } from './producto';
import { DataService } from './data.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ComprandoEnCasaFrontend';
   products: Producto[] = [];

constructor(private http: HttpClient,private api: ApiService, public data: DataService) {}

    public getProductos():Array<{nombreProducto, marca, stock, precio, imagen, categoria}>{
      return this.data.products
    }

    public createProducto(product: {id, name, description, email,urlImage}){
    /*Por implementar*/
      //this.productos.push(product);
    }

    public getProductosAPI$() {
    this.products = [];
      this.api.getProductosAPI$()
      .subscribe(resp => {
                     console.log(resp);
                     //
                       for (const data of resp.body) {
                             this.products.push(data);
                           }
                           console.log(this.products);
                           },

                         err => console.log(err));
      this.data.products = this.products;
    }

    public getProductosByConsulta(consulta:string){
      this.products = [];
      this.api.getProductosByConsultaAPI$(consulta)
           .subscribe(resp => {
                            for (const data of resp.body) {
                                  this.products.push(data);
                                }
                                console.log(this.products);
                                },

                       err => console.log(err));
      this.data.products = this.products;
      }


      public getUserData(){
      /*Consulto a la API y obtengo los datos del usuario*/
        this.api.getUserData$()
           .subscribe(resp => {
                          const data = resp.body
                          this.data.userData = data;
                          this.data.nombreUsuario = this.data.userData.nombreUsuario
                          if(this.data.userData.listaDeCompras != undefined){
                              this.data.productosEnCarrito = this.data.userData.listaDeCompras.productosAcumulados;
                          }

                               },

                       err => console.log(err));
      }

      public agregarProductoACarrito(producto:Producto){
      //this.data.agregarProductoAlCarrito(producto);
      this.api.agregarProductoACarritoAPI$(this.data.getListaCompras().id, producto.id,this.data.getListaCompras())
          .subscribe(resp => {  const data = resp.body
                                console.log("Producto Seleccionado en carrito", producto);
                                this.data.userData.listaDeCompras = data;
                                this.data.actualizarProductosEnCarrito();
                                this.data.actualizarMonto(this.data.getListaCompras().montoAcumulado);
                                console.log("Lista de compras ",this.data.getListaCompras());
                             },

                     err => console.log(err));
      }

      public actualizarPerfilUsuario(){
      this.api.actualizarPerfilUsuario(this.data.getuserData())
          .subscribe(resp => {  const data = resp.body
                                this.data.setuserData(data);
                              },
                     err => console.log(err));

      }


}
