import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  productos;
  selectedproducto;
  constructor(private http: HttpClient,public appcomp: AppComponent) { }

  ngOnInit() {
  this.appcomp.getProductosAPI$();
  this.productos = this.appcomp.getProductos();
  console.log("Save button is clicked!", this.productos);
  }

 public selectProduct(producto){
      this.selectedproducto = producto;
    }

}
