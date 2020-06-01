import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';
import { Producto } from './producto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ComprandoEnCasaFrontend';
   products: Producto[] = [];


constructor(private http: HttpClient,private api: ApiService) {}

    public getProductos():Array<{nombreProducto, marca, stock, precio, imagen, categoria}>{
      return this.products;
    }

    public createProducto(product: {id, name, description, email,urlImage}){
    /*Por implementar*/
      //this.productos.push(product);
    }

    getProductosAPI$() {
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
    }

    public getProductosByConsulta(consulta:string){
      this.products = [];
      this.api.getProductosByConsultaAPI$(consulta)
           .subscribe(resp => {
                          console.log(resp);
                          //
                            for (const data of resp.body) {
                                  this.products.push(data);
                                }
                                console.log(this.products);
                                },

                       err => console.log(err));
      }


}
