import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { DataService } from '../data.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  consulta:string = "";
  constructor(public appcomp: AppComponent,private route: Router, public data: DataService) { }

  ngOnInit() {
  }

  callProductosByConsulting(){
  console.log(this.consulta);
  if(this.consulta != ""){
   this.appcomp.getProductosByConsulta(this.consulta);
    //this.route.navigate(["producto-create"]);

  }

  }
}
