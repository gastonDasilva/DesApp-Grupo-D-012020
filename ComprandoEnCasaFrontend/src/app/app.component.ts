import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';
import { Producto } from './producto';
import { DataService } from './data.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ComprandoEnCasaFrontend';
   products: Producto[] = [];

constructor(public router: Router,private http: HttpClient,private api: ApiService, public data: DataService) {}

    public getProductos():Array<{nombreProducto, marca, stock, precio, imagen, categoria}>{
      return this.data.products
    }

    public createProducto(product: Producto){
    /*Por implementar*/
     this.api.CrearProductoForUsuario(product,this.data.getuserData().id)
         .subscribe(resp => {  const data = resp.body
                                this.data.setuserData(data);
                                       },
                              err => console.log(err));
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

    public getProductosEnOfertaAPI$() {
      this.products = [];
      this.api.aplicarOfertaEnBebidasConDescuento(10)
          .subscribe(resp => {
                     console.log(resp);
                     for (const data of resp){
                       this.products.push(data);
                     }
                     console.log(this.products);
                    },
                    err => console.log(err));
            this.data.productosEnOferta = this.products;
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


      public getUserData(idUser:string){
      /*Consulto a la API y obtengo los datos del usuario*/
        this.api.getUserData$(idUser)
           .subscribe(resp => {
                          const data = resp.body
                          this.data.userData = data;
                          this.data.nombreUsuario = this.data.userData.nombreUsuario;
                          this.data.userEsComercio = this.data.userData.esComercio;
                          if(this.data.userData.listaDeCompras != undefined){
                              this.data.productosEnCarrito = this.data.userData.listaDeCompras.productosAcumulados;
                          }
                           this.router.navigateByUrl('/home');

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
                             },

                     err => console.log(err));
      }

      public deleteProductoFromCarrito(producto: Producto){
      /*Saco un producto seleccionado del carrito*/
      this.api.sacarProductoDelCarritoAPI$(this.data.getListaCompras().id,producto.id,this.data.getListaCompras())
          .subscribe(resp => {  const data = resp.body;
                                this.data.userData.listaDeCompras = data;
                                this.data.actualizarProductosEnCarrito();
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


      public getAgregarCompraEnHistorial(){
        this.api.realizarCompra(this.data.getuserData())
            .subscribe(resp => { const data = resp.historialDeCompras
                                 this.data.setHistorialDeCompras(data);
                               },
                       err => console.log(err));
      }


      public aplicarOfertaEnCategoriaDeBebidas(descuento: number){
        this.api.aplicarOfertaEnBebidasConDescuento(descuento)
            .subscribe(resp => { const data = resp
                                 this.data.actualizarProductosConOferta(data);
                               },
                      err => console.log(err));
      }

      public gestionaLogin(user:any){
      /*Esta function se encarga de usar la api para loguearme , en este caso con Google*/
      this.api.loginWithGoogle(user)
          .subscribe(resp => { const data = resp
                               /* Lleno el userData con todos los datos del usuario.*/
                               this.getUserData(data.id.toString());
                               },
                     err => console.log(err));
      }
}
