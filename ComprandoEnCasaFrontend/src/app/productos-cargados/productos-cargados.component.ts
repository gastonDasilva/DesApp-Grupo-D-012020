import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
@Component({
  selector: 'app-productos-cargados',
  templateUrl: './productos-cargados.component.html',
  styleUrls: ['./productos-cargados.component.css']
})
export class ProductosCargadosComponent implements OnInit {

  constructor(public data: DataService) { }

  ngOnInit() {
  }

  //DeletectProductFromUserComerciante(Component: string) {}
  //ModificarProductFromUserComerciante(Component: string){}


}
