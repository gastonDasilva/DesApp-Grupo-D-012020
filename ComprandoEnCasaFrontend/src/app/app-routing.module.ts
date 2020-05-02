import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductoCreateComponent } from './producto-create/producto-create.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:  "", pathMatch:  "full",redirectTo:  "home"},
  {path: "home", component: HomeComponent},
  {path: "producto-create", component: ProductoCreateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
