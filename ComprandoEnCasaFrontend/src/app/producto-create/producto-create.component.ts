import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-producto-create',
  templateUrl: './producto-create.component.html',
  styleUrls: ['./producto-create.component.css']
})
export class ProductoCreateComponent implements OnInit {
  producto : {id, name, description, email} = {id: null, name: "", description: "", email: ""};

  constructor(public appcomp: AppComponent) { }


  ngOnInit() {
  }

  createProducto(){
    console.log(this.producto);
    this.appcomp.createProducto(this.producto);
    this.producto = {id: null, name: "", description: "", email: ""};

  }
}
