import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  // product = [
  //   { name: 'Ankit' , id: 209},
  //   { name: 'Prerna' , id: 210},
  // ];

  product(): Observable<any> {
    return this.http.get('https://jsonplaceholder.typicode.com/users');
  }
}
