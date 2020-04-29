import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductoListComponent } from './producto-list/producto-list.component';
import { ProductoCreateComponent } from './producto-create/producto-create.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:  "", pathMatch:  "full",redirectTo:  "home"},
  {path: "home", component: HomeComponent},
  {path: "producto-create", component: ProductoCreateComponent},
  {path: "producto-list", component: ProductoListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
