import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { Producto } from '../producto';
/*trad..*/
import { TranslateService } from '@ngx-translate/core';


@Component({
  selector: 'app-productos-cargados',
  templateUrl: './productos-cargados.component.html',
  styleUrls: ['./productos-cargados.component.css']
})
export class ProductosCargadosComponent implements OnInit {
  selectedproducto:Producto;

  constructor(private http: HttpClient,public appcomp: AppComponent,public data: DataService,translate: TranslateService) {
    translate.setDefaultLang('es');
    translate.use('es');
   }

  ngOnInit() {
    this.appcomp.getProductosEnOfertaAPI$();
     console.log("Save button is clicked!", this.data.getProductosEnOferta());
     //llamo y traigo los datos de usuario, por ahora va aca. despues se creara una component LOgin para esto.
     /*if(this.data.userData == null){
      this.appcomp.getUserData("1");
     }*/

}

public agregarProducto(producto){
   this.selectedproducto = producto;
   //this.data.agregarProductoAlCarrito(producto);
   this.appcomp.agregarProductoACarrito(producto)
   /*console.log("Producto Seleccionado en carrito", this.selectedproducto);
   this.data.productosEnCarrito.push(producto)
   console.log("Cant Productos en carrito:", this.data.productosEnCarrito.length);*/
 }

  //DeletectProductFromUserComerciante(Component: string) {}
  //ModificarProductFromUserComerciante(Component: string){}


}
