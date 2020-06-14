import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Producto } from '../producto';

@Component({
  selector: 'app-producto-create',
  templateUrl: './producto-create.component.html',
  styleUrls: ['./producto-create.component.css']
})
export class ProductoCreateComponent implements OnInit {
  producto : Producto;

  constructor(public appcomp: AppComponent) {
  this.cleanProduct();
  }


  ngOnInit() {
  }

 createProducto(){
    console.log(this.producto);
    this.appcomp.createProducto(this.producto);
    this.cleanProduct();
  }

  cleanProduct(){
   this.producto = {id:0,nombreProducto: "", marca: "", stock: 0,precio: 0,imagen:"",categoria:"",cantidadAComprar:0};
  }
}
