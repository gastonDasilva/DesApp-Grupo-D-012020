import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Producto } from '../producto';
import { Router, RouterLink } from '@angular/router';
/*traducc*/
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-producto-create',
  templateUrl: './producto-create.component.html',
  styleUrls: ['./producto-create.component.css']
})
export class ProductoCreateComponent implements OnInit {
  producto : Producto;
  alert: Boolean = false;

  constructor(public router: Router,public appcomp: AppComponent,translate: TranslateService) {
    translate.setDefaultLang('es');
    translate.use('es');
  this.cleanProduct();
  }


  ngOnInit() {
  }

 createProducto(){
    console.log(this.producto);
    this.appcomp.createProducto(this.producto);
    this.cleanProduct();
    this.alert = true;
  }

  cleanProduct(){
   this.producto = {id:0,nombreProducto: "", marca: "", stock: 0,precio: 0,imagen:"",categoria:"",cantidadAComprar:1};
  }

 public volverAlHome(){
       this.router.navigateByUrl('home');
      }
}
