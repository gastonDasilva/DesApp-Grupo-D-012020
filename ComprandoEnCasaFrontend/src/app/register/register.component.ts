// register.component.ts

import { Component } from "@angular/core";
import { ApiService } from '../api.service';
import { Router, RouterLink } from '@angular/router';
/*traduc...*/
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent {
  username: String;
  password: String;
  address: String;
  email: String;

  constructor(public apiService: ApiService, public router: Router,translate: TranslateService) {
      translate.setDefaultLang('es');
      translate.use('es');
  }

  register() {
    const user = {
        username: this.username,
        email: this.email,
        password: this.password,
        address: this.address,
    };
    this.apiService.register(user).subscribe(data =>{
        console.log(data);
        this.router.navigateByUrl('/login');
    }),
    error => {
        console.log(error);
    }
  }
}
