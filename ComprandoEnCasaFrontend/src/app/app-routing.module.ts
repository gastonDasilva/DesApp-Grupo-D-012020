import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductoCreateComponent } from './producto-create/producto-create.component';
import { HomeComponent } from './home/home.component';
import { CarritoComponent } from './carrito/carrito.component';
import { PerfilComponent } from './perfil/perfil.component';
import { ProductosCargadosComponent } from './productos-cargados/productos-cargados.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
  {path:  "", pathMatch:  "full",redirectTo:  "home"},
  {path: "home", component: HomeComponent},
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "producto-create", component: ProductoCreateComponent},
  {path: "home/carrito", component: CarritoComponent},
  {path: "home/carrito", redirectTo:  "carrito"},
  {path: "carrito/home",redirectTo:  "home"},
  {path: "perfil-usuario", component: PerfilComponent},
  {path: "home/perfil-usuario", redirectTo:  "perfil-usuario"},
  {path: "productos-cargados", component: ProductosCargadosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
