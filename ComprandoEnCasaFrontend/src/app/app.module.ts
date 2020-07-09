import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
/*import { HttpClientModule } from '@angular/common/http';*/
import { HomeComponent } from './home/home.component';
import { ProductoCreateComponent } from './producto-create/producto-create.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule } from '@angular/forms';
import { CarritoComponent } from './carrito/carrito.component';
import { PerfilComponent } from './perfil/perfil.component';
import { ProductosCargadosComponent } from './productos-cargados/productos-cargados.component';
import { HistorialComponent } from './historial-de-compras/historial.component';
import { DetallesComponent } from './detalles-compra/detalles.component';
/*Modulos para inicio de sesion para redes sociales*/
import { SocialLoginModule, AuthServiceConfig } from "angularx-social-login";
import { GoogleLoginProvider, FacebookLoginProvider } from "angularx-social-login";
/* modulos para traduccion dinamica*/
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { MainComponent } from './components/main/main.component';
/*modulos para fecha y moneda*/
//en app.component

let config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider("311052136099-qqf6f12v6pdpt5tfv67lqfe8gdivg920.apps.googleusercontent.com")
  },
]);

export function provideConfig() {
  return config;
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProductoCreateComponent,
    HeaderComponent,
    FooterComponent,
    CarritoComponent,
    PerfilComponent,
    ProductosCargadosComponent,
<<<<<<< HEAD
    HistorialComponent,
    DetallesComponent
=======
    MainComponent
    HistorialComponent
>>>>>>> b42dff247b8fe898c9afccf1a2a15d80e98b2a58
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    SocialLoginModule,
    NgbModule,
        TranslateModule.forRoot(),
        HttpClientModule,
        TranslateModule.forRoot({
              loader: {
                provide: TranslateLoader,
                useFactory: HttpLoaderFactory,
                deps: [ HttpClient ]
              }
            })
  ],
  providers: [ {
                    provide: AuthServiceConfig,
                    useFactory: provideConfig
                  }],
  bootstrap: [AppComponent]
})
export class AppModule { }

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}
