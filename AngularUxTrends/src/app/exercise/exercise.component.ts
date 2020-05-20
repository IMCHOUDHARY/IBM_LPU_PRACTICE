import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css']
})
export class ExerciseComponent implements OnInit {

  constructor() { }

  Users: string [] = [];
  Admins: string [] = [];

  ngOnInit(): void {
  }

  removeUser(indexUser)
  {
    console.log(indexUser);
    this.Users.splice(indexUser, 1);
  }

  removeAdmin(indexAdmin)
  {
    console.log(indexAdmin);
    this.Admins.splice(indexAdmin, 1);
  }
}
