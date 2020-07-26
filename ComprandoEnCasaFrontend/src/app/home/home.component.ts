import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { Producto } from '../producto';
import { ApiService } from '../api.service';
/*traduccion*/
import { TranslateService } from '@ngx-translate/core';
import {PageEvent} from '@angular/material/paginator'


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit {

  selectedproducto:Producto;
  page_number: number = 1
  page_size: number = 8
  productos:  Producto[] = []
  pageSizeOptions = [8,10,15,20,50,100];
  constructor(private api: ApiService,private http: HttpClient,public appcomp: AppComponent, public data: DataService,translate: TranslateService) {
      translate.setDefaultLang('es');
      translate.use('es');
  }

  ngOnInit() {
      this.api.getProductosAPI$().subscribe(resp => { this.productos = resp;});
        console.log("Save button is clicked!", this.data.getProductos());
        //llamo y traigo los datos de usuario, por ahora va aca. despues se creara una component LOgin para esto.
       /* if(this.data.userData == null){
         this.appcomp.getUserData("1");
        }*/

  }

  handlePage(e: PageEvent){
  this.page_size = e.pageSize;
  this.page_number = e.pageIndex + 1;
  }
 public agregarProducto(producto){
      this.selectedproducto = producto;
      //this.data.agregarProductoAlCarrito(producto);
      this.appcomp.agregarProductoACarrito(producto)
      /*console.log("Producto Seleccionado en carrito", this.selectedproducto);
      this.data.productosEnCarrito.push(producto)
      console.log("Cant Productos en carrito:", this.data.productosEnCarrito.length);*/
    }
}
