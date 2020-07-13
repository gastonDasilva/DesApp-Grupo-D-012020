import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Producto } from '../producto';
import { Router, RouterLink } from '@angular/router';
import * as XLSX from 'xlsx'
/*traducc*/
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-producto-create',
  templateUrl: './producto-create.component.html',
  styleUrls: ['./producto-create.component.css']
})
export class ProductoCreateComponent implements OnInit {
  data: [][];
  producto : Producto;
  alert: Boolean = false;

  constructor(public router: Router,public appcomp: AppComponent,translate: TranslateService) {
    translate.setDefaultLang('es');
    translate.use('es');
  this.cleanProduct();
  }


  ngOnInit() {
  }

 createProducto(){
    console.log(this.producto);
    this.appcomp.createProducto(this.producto);
    this.cleanProduct();
    this.alert = true;
  }

  cleanProduct(){
   this.producto = {id:0,nombreProducto: "", marca: "", stock: 0,precio: 0,imagen:"",categoria:"",cantidadAComprar:1};
  }

 public volverAlHome(){
       this.router.navigateByUrl('home');
      }

  onFileChange(evt: any){
  const target: DataTransfer = <DataTransfer>(evt.target);
  if(target.files.length !==1) throw new Error('No se puede cargar mas de una archivo.')
  console.log(target.files.length);

  const reader: FileReader = new FileReader();
  reader.onload = ( e: any) =>{
    const bstr: string = e.target.result;
    const wb: XLSX.WorkBook = XLSX.read(bstr,{ type: 'binary'});
    const wsname : string = wb.SheetNames[0];
    const ws: XLSX.WorkSheet = wb.Sheets[wsname];
    console.log(ws);
    this.data = (XLSX.utils.sheet_to_json(ws,{header:1}));
    console.log(this.data);
  };
  reader.readAsBinaryString(target.files[0]);
  }
}
