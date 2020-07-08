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
    }
  }