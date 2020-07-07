import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { ApiService } from '../api.service';
import { DataService } from '../data.service';
import { UsuarioData } from '../usuarioData';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from "angularx-social-login";
import { FacebookLoginProvider, GoogleLoginProvider } from "angularx-social-login";
import { SocialUser } from "angularx-social-login";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })
  export class LoginComponent implements OnInit{
      username: String;
      password: String;
      errorState: String;
      private user: SocialUser;
      private loggedIn: boolean;
      constructor(public appcomp: AppComponent ,public apiService: ApiService, public router: Router,private authService: AuthService) {}

      ngOnInit() {
       this.authService.authState.subscribe((user) => {
            this.user = user;
            this.loggedIn = (user != null);
            if(this.loggedIn == true){
              this.appcomp.gestionaLogin(this.user);

            }
          });
        }

    login() {
        const user = {username: this.username, password: this.password};
        this.apiService.login(user).subscribe (data => {
            console.log(data);
            this.router.navigateByUrl('/home');
        }),
        error => {
            console.log(error);
        }
    }

    registrar() {
        this.router.navigateByUrl('/register');
    }

    signInWithGoogle(): void {
      this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
    }

    signInWithFB(): void {
      this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
    }

    signOut(): void {
      this.authService.signOut();
    }
}
