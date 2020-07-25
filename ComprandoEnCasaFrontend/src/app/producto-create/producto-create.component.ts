import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { Producto } from '../producto';
import { Router, RouterLink } from '@angular/router';
import * as XLSX from 'xlsx'
/*traducc*/
import { TranslateService } from '@ngx-translate/core';
import{ FormBuilder,FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-producto-create',
  templateUrl: './producto-create.component.html',
  styleUrls: ['./producto-create.component.css']
})
export class ProductoCreateComponent implements OnInit {
  data: [][];
  producto : Producto;
  alert: Boolean = false;
  productoForm: FormGroup;

  constructor(public router: Router,public appcomp: AppComponent,translate: TranslateService) {
    translate.setDefaultLang('es');
    translate.use('es');
    this.productoForm = this.createFormGroup();
  //this.cleanProduct();
  }


  createFormGroup(){
  return new FormGroup({
    nombreProducto: new FormControl('',[Validators.required,Validators.minLength(2)]),
    marca: new FormControl('',[Validators.required,Validators.minLength(2)]),
    stock: new FormControl('',[Validators.required]),
    precio: new FormControl('',[Validators.required]),
    imagen: new FormControl('',[Validators.required,Validators.minLength(5)]),
    categoria: new FormControl('',[Validators.required,Validators.minLength(2)])
  });
  }
  onResetForm(){
    this.productoForm.reset();
   }

  onSaveForm(){
    if(this.productoForm.valid){
        this.appcomp.createProducto(this.productoForm.value);
        this.alert = true;
        this.onResetForm();
        console.log( 'valid');
    }else{
      console.log('not valid');
    }

  }
  ngOnInit() {
  }

  get nombreProducto(){
  return this.productoForm.get('nombreProducto');
  }
  get marca(){
    return this.productoForm.get('marca');
  }
  get stock(){
    return this.productoForm.get('stock');
  }
  get precio(){
    return this.productoForm.get('precio');
  }
  get imagen(){
    return this.productoForm.get('imagen');
  }
  get categoria(){
    return this.productoForm.get('categoria');
  }
/*
 createProducto(){
    console.log(this.producto);
    this.appcomp.createProducto(this.producto);
    this.cleanProduct();
    this.alert = true;
  }

  cleanProduct(){
   this.producto = {id:0,nombreProducto: "", marca: "", stock: 0,precio: 0,imagen:"",categoria:"",cantidadAComprar:1};
  }*/

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

    for (var val of this.data) {
       var valores = val  // prints values: 10, 20, 30, 40
       console.log(valores);
       var productoval : Producto
      for (var val2 of valores) {
      console.log(val2);
      }}

  };
  reader.readAsBinaryString(target.files[0]);
  }
}
