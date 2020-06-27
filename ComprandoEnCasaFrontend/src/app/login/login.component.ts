import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
import { UsuarioData } from '../usuarioData';
import { Router } from '@angular/router';


@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })
  export class LoginComponent implements OnInit{
      username: String = "";
      password: String = "";
      constructor(private http: HttpClient,public appcomp: AppComponent, public data: DataService) {}

      ngOnInit() {
      }


    login() {
    }
}