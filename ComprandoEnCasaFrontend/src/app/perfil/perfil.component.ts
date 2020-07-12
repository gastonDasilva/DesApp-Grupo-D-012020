import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service'
import { AppComponent } from '../app.component';
/*traduccion*/
import { TranslateService } from '@ngx-translate/core';

import { Router, RouterLink } from '@angular/router';


@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  userUpdate: Boolean = false;

  constructor(public router: Router,public appcomp: AppComponent,public data: DataService,translate: TranslateService) {
    translate.setDefaultLang('es');
    translate.use('es');
   }

  ngOnInit() { /**/
   console.log("data:", this.appcomp.data);

  }

  public actualizarPerfilUsuario(){
   console.log("data:", this.data.getuserData());
   this.appcomp.actualizarPerfilUsuario();
   this.data.actualizarNombreUsuario();
   this.userUpdate=true;
  }


    public ConvertirEnComerciante(){
     console.log("SI, quiero ser comerciante", this.data.getuserData());
     this.data.userData.esComercio = true;
     this.actualizarPerfilUsuario();
    }

    public closeAlert(){
    /*Este boton es solo para gestionar la aletar que muestra que el usuario fue actualizado*/
    this.userUpdate = false;
    }

    public volverAlHome(){
     this.router.navigateByUrl('home');
    }
}
