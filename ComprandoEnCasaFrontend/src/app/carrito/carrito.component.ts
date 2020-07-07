import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { Producto } from '../producto';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {

  constructor(public appcomp: AppComponent, public data: DataService,private route: Router) { }

  ngOnInit() {
  }


  public DeletectProductFromCarrito(producto:Producto){
  this.appcomp.deleteProductoFromCarrito(producto);
  }

    public seguirComprando(){
     this.route.navigateByUrl('home');
    }

    public realizarCompra(){
      this.appcomp.getAgregarCompraEnHistorial();
      this.route.navigateByUrl('history');
    }
}
