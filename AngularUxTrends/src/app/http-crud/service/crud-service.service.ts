import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Crud} from '../model/crud';

@Injectable({
  providedIn: 'root'
})
export class CrudServiceService {

  constructor(private http: HttpClient) { }

  url = 'http://localhost:3131/users';

  viewUsers(): Observable<any> {
    return this.http.get(this.url );
  }

  addUser(userObj: Crud): Observable<any> {
    return this.http.post(this.url, userObj);
  }
}
