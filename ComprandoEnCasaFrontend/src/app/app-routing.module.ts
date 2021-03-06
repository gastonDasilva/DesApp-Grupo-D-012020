import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductoCreateComponent } from './producto-create/producto-create.component';
import { HomeComponent } from './home/home.component';
import { CarritoComponent } from './carrito/carrito.component';
import { PerfilComponent } from './perfil/perfil.component';
import { ProductosCargadosComponent } from './productos-cargados/productos-cargados.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HistorialComponent } from './historial-de-compras/historial.component';
import { DetallesComponent } from './detalles-compra/detalles.component';


const routes: Routes = [
  {path:  "", pathMatch:  "full",redirectTo:  "login"},
  {path: "home", component: HomeComponent},
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "producto-create", component: ProductoCreateComponent},
  {path: "carrito", component: CarritoComponent},
  {path: "home/carrito", component: CarritoComponent},
  {path: "home/carrito", redirectTo:  "carrito"},
  {path: "carrito/home",redirectTo:  "home"},
  {path: "perfil-usuario", component: PerfilComponent},
  {path: "home/perfil-usuario", redirectTo:  "perfil-usuario"},
  {path: "productos-cargados", component: ProductosCargadosComponent},
  {path: "history", component: HistorialComponent},
  {path: "home/history", component: HistorialComponent},
  {path: "home/history", redirectTo: "history"},
  {path: "history/home", redirectTo: "home" },
  {path: "detalles", component: DetallesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
