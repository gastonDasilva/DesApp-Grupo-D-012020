import { Component, OnInit } from '@angular/core';
/*traduccion*/
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor(translate: TranslateService) {
       translate.setDefaultLang('es');
       translate.use('es');
   }

  ngOnInit() {
  }
  changeLang(lang: string) {


     if (lang === 'es') {
         localStorage.setItem('locale', 'es');
      }

     if (lang === 'en') {
         localStorage.setItem('locale', 'en');
     }
  }




}
