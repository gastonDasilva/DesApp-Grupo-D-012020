import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { ProductoCreateComponent } from './producto-create/producto-create.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule } from '@angular/forms';
import { CarritoComponent } from './carrito/carrito.component';
import { PerfilComponent } from './perfil/perfil.component';
import { ProductosCargadosComponent } from './productos-cargados/productos-cargados.component';
import { HistorialComponent } from './historial-de-compras/historial.component';
/*Modulos para inicio de sesion para redes sociales*/
import { SocialLoginModule, AuthServiceConfig } from "angularx-social-login";
import { GoogleLoginProvider, FacebookLoginProvider } from "angularx-social-login";


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
    HistorialComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    SocialLoginModule
  ],
  providers: [ {
                    provide: AuthServiceConfig,
                    useFactory: provideConfig
                  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
