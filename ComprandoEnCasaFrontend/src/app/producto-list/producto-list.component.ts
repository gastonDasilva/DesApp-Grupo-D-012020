import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
@Component({
  selector: 'app-producto-list',
  templateUrl: './producto-list.component.html',
  styleUrls: ['./producto-list.component.css']
})
export class ProductoListComponent implements OnInit {
  productos;
  selectedproducto;
  constructor(public appcomp: AppComponent) { }

  ngOnInit() {
      this.productos = this.appcomp.getProductos();
      console.log("Save button is clicked!", this.productos);
    }
    public selectContact(producto){
      this.selectedproducto = producto;
    }

}
