import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { Producto } from '../producto';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
/*traduccion*/
import { TranslateService, LangChangeEvent } from '@ngx-translate/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {
  modoDeEnvio=0;


  constructor(public appcomp: AppComponent, public data: DataService,private route: Router,private translate: TranslateService, private titleService: Title) {
      this.translate.setDefaultLang('es');
      this.translate.use('es');

   }

  ngOnInit() {
  }


  public DeletectProductFromCarrito(producto:Producto){
  this.appcomp.deleteProductoFromCarrito(producto);
  }

    public seguirComprando(){
     this.route.navigateByUrl('home');
    }

    public realizarCompra(){
     console.log(this.modoDeEnvio);
     this.appcomp.comprar(this.modoDeEnvio.toString())

      /*this.appcomp.getAgregarCompraEnHistorial();
      this.route.navigateByUrl('history');
      */
    }
}
