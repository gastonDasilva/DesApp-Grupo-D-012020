import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service'
import { AppComponent } from '../app.component';
/*traduccion*/
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  userUpdate: Boolean = false;
  constructor(public appcomp: AppComponent,public data: DataService,translate: TranslateService) {
    translate.setDefaultLang('es');
    translate.use('es');
   }

  ngOnInit() {
   console.log("data:", this.appcomp.data);
  }

  public actualizarPerfilUsuario(){
   console.log("data:", this.data.getuserData());
   this.appcomp.actualizarPerfilUsuario();
   this.userUpdate=true;
  }
}
