import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { Producto } from '../producto';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-carrito',
  templateUrl: './detalles.component.html',
  styleUrls: ['./detalles.component.css']
})
export class DetallesComponent implements OnInit {

  constructor(public appcomp: AppComponent, public data: DataService,private route: Router) { }

  ngOnInit() {
  }

  public seguirComprando(){
      this.route.navigateByUrl('history');
   }
}
