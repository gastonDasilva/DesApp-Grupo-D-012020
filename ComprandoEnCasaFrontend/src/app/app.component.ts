import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ComprandoEnCasaFrontend';
  productos = [
      {id: 1, name: "Contact 001", description: "Contact 001 des", email: "c001@email.com"},
      {id: 2, name: "Contact 002", description: "Contact 002 des", email: "c002@email.com"},
      {id: 3, name: "Contact 003", description: "Contact 003 des", email: "c003@email.com"},
      {id: 4, name: "Contact 004", description: "Contact 004 des", email: "c004@email.com"}
    ];
constructor(private http: HttpClient) {}

    public getProductos():Array<{id, name, description, email}>{
      return this.productos;
    }
    public createProducto(contact: {id, name, description, email}){
      this.productos.push(contact);
    }

    ping$($event) {
        const httpOptions = { headers: new HttpHeaders()
                                      .set('Access-Control-Allow-Origin', '*')
                                      .set('Access-Control-Allow-Headers', 'Content-Type')
                                      .set('Access-Control-Allow-Methods', 'OPTIONS,POST,GET')
                               };
        this.http.get('http://localhost:8585/api/private',httpOptions)
        .subscribe(res => {
                          console.log(res);
                           },
                    err => console.log(err)
                  );
                  console.log("Save button is clicked!", $event);
      }


}
