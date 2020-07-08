import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { DataService } from '../data.service';
import { SocialUser } from "angularx-social-login";
import { AuthService } from "angularx-social-login";
/*traduccion*/
import { TranslateService } from '@ngx-translate/core';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  consulta:string = "";
  usuarioname: String = "";
  private user: SocialUser;
  private loggedIn: boolean;
  constructor(public appcomp: AppComponent,private route: Router, public data: DataService,private authService: AuthService,private translate: TranslateService) {
      translate.setDefaultLang('es');
      translate.use('es');
   }

  ngOnInit() {
   this.authService.authState.subscribe((user) => {
              this.user = user;
              this.loggedIn = (user != null);
              if(this.loggedIn == false){
               this.route.navigateByUrl('/');
              }
            });
  }

  callProductosByConsulting(){
    console.log(this.consulta);
    if(this.consulta != ""){
     this.appcomp.getProductosByConsulta(this.consulta);
      //this.route.navigate(["producto-create"]);

    }
  }
  signOut(): void {
    this.authService.signOut();
  }
  verPerfil(): void{
   this.route.navigateByUrl('perfil-usuario');
  }
  verCarrito(): void{
     this.route.navigateByUrl('carrito');
  }

  // Se cambia el idioma a Español
  changeLanguageToSpanish(): void {
      this.translate.use('es');
      console.log('Idioma cambiado al Español');
  }

  // Se cambia el idioma a Inglés
  changeLanguageToEnglish(): void {
     this.translate.use('en');
     console.log('Idioma cambiado al Inglés');
   }

  verHistorial(): void{
    this.route.navigateByUrl('history');
  }
}
