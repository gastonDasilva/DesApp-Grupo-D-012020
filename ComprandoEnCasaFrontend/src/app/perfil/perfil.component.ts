import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service'
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  constructor(public appcomp: AppComponent,public data: DataService) { }

  ngOnInit() {
   console.log("data:", this.appcomp.data);
  }

  public actualizarPerfilUsuario(){
   console.log("data:", this.data.getuserData());
   this.appcomp.actualizarPerfilUsuario();
  }
}
