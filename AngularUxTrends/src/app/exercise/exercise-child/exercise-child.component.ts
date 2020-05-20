import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-exercise-child',
  templateUrl: './exercise-child.component.html',
  styleUrls: ['./exercise-child.component.css']
})
export class ExerciseChildComponent implements OnInit {

  constructor() { }

  @Input() Users: string[] = [];
  @Input() Admins: string[] = [];

  ngOnInit(): void {
  }
  addUser(userValue){
    this.Users.push(userValue.value);
  }

  addAdmin(adminValue){
    this.Admins.push(adminValue.value);
  }
}
