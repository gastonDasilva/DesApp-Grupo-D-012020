import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { Producto } from '../producto';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  selectedproducto:Producto;
  constructor(private http: HttpClient,public appcomp: AppComponent, public data: DataService) {}

  ngOnInit() {
       this.appcomp.getProductosAPI$();
        console.log("Save button is clicked!", this.data.getProductos());


  }

 public agregarProducto(producto){
      this.selectedproducto = producto;
      console.log("Producto Seleccionado en carrito", this.selectedproducto);
      this.data.productosEnCarrito.push(producto)
      console.log("Cant Productos en carrito:", this.data.productosEnCarrito.length);
    }
}
