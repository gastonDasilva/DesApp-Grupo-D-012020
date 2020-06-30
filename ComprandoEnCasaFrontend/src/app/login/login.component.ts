import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { ApiService } from '../api.service';
import { DataService } from '../data.service';
import { UsuarioData } from '../usuarioData';
import { Router, RouterLink } from '@angular/router';


@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })
  export class LoginComponent implements OnInit{
      username: String;
      password: String;
      errorState: String;
      constructor(public apiService: ApiService, public router: Router) {}

      ngOnInit() {
      }

    login() {
        const user = {username: this.username, password: this.password};
        this.apiService.login(user).subscribe (data => {
            console.log(data);
            this.router.navigateByUrl('/home');
        }),
        error => {
            this.errorState = error;
            console.log(error);
        }
    }
}