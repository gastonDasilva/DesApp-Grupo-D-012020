import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  consulta:string = "";
  constructor(public appcomp: AppComponent) { }

  ngOnInit() {
  }

  callProductosByConsulting(){
  console.log(this.consulta);
  if(this.consulta != ""){
   this.appcomp.getProductosByConsulta(this.consulta);
  }

  }
}
