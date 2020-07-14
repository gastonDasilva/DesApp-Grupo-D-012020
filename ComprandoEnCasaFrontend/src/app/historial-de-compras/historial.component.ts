import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { Producto } from '../producto';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { ListaDeCompras } from '../listaDeCompras';

@Component({
    selector: 'app-historial',
    templateUrl: './historial.component.html',
    styleUrls: ['./historial.component.css']
  })
  export class HistorialComponent implements OnInit{
    constructor(public appcomp: AppComponent, public data: DataService,private route: Router){}

    ngOnInit(){
      console.log("this history is: ", this.data.userData.historialDeCompras);
    }

    public verDetallesDeProductos(productos: Producto[]){
      this.data.setProductosAcumulados(productos);
      this.route.navigateByUrl('detalles');
      console.log("los productos de esta compra son: ", this.data.getProductosAcumulados());
    }

    public seguirComprando(){
         this.route.navigateByUrl('home');
        }

  }
