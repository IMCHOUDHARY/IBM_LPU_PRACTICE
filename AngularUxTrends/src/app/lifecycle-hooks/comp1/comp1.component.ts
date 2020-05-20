import {Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-comp1',
  templateUrl: './comp1.component.html',
  styleUrls: ['./comp1.component.css']
})
export class Comp1Component implements OnInit, OnChanges, DoCheck {

  constructor() {
    console.log('Constructor called');
  }

  @Input() myValue = 'Ankit Choudhary';

  ngOnChanges(changes: SimpleChanges) {
    console.log(changes.myValue.previousValue);
    console.log(changes);
    console.log(changes.myValue.currentValue);
  }

  ngOnInit(): void {
    console.log('Hello ngOnInit....');
  }

  ngDoCheck() {
    console.log('DoCheck called....');
  }
}
