import { Component, OnInit } from '@angular/core';
import {Crud} from './model/crud';
import {CrudServiceService} from './service/crud-service.service';

@Component({
  selector: 'app-http-crud',
  templateUrl: './http-crud.component.html',
  styleUrls: ['./http-crud.component.css']
})
export class HttpCRUDComponent implements OnInit {

  constructor(private crudService: CrudServiceService) { }

  users: Crud[];
  userObj = new Crud();

  ngOnInit(): void {
    this.viewUsers();
  }

  viewUsers(): void{
    this.crudService.viewUsers().subscribe(
      userData => this.users = userData
    );
  }

  onSubmit()
  {
    this.crudService.addUser(this.userObj).subscribe(
      data => console.log(data), error => console.log(error)
    );
  }
}
