import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

import { TRANSLATIONS } from '@angular/core';
import { TRANSLATIONS_FORMAT } from '@angular/core';


if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));

if (localStorage.getItem('locale') === null) {
localStorage.setItem('locale', 'es');
}

const locale = localStorage.getItem('locale');
declare const require;
const translations = require(`raw-loader!./locale/messages.${locale}.xlf`);

platformBrowserDynamic().bootstrapModule(AppModule, {
  providers: [
    {provide: TRANSLATIONS, useValue: translations},
    {provide: TRANSLATIONS_FORMAT, useValue: 'xlf'}
  ]
});
