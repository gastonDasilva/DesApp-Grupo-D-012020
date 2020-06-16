import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { Producto } from '../producto';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {

  constructor(public appcomp: AppComponent, public data: DataService) { }

  ngOnInit() {
  }


  public DeletectProductFromCarrito(producto:Producto){
  this.appcomp.deleteProductoFromCarrito(producto);
  }

}
