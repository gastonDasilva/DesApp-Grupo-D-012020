import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  ping$($event) {
          /*const httpOptions = { headers: new HttpHeaders()
                                        .set('Access-Control-Allow-Origin', '*')
                                        .set('Access-Control-Allow-Headers', 'Content-Type')
                                        .set('Access-Control-Allow-Methods', 'OPTIONS,POST,GET')
                                 };
          this.http.get('http://localhost:8585/api/private',httpOptions)
          .subscribe(res => {
                            console.log(res);
                             },
                      err => console.log(err)
                    );*/
                    console.log("Save button is clicked!", $event);
        }
}
