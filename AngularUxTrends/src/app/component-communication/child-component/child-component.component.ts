import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-child-component',
  templateUrl: './child-component.component.html',
  styleUrls: ['./child-component.component.css']
})
export class ChildComponentComponent implements OnInit {

  constructor() { }

  @Input() myName = 'ANKIT';
  @Input() isSelected = false;
  @Input() selectedProduct = '';
  @Output() cartProduct = new EventEmitter<any>();

  ngOnInit(): void {
  }

  addProduct()
  {
     // this.toCart.emit();
    this.cartProduct.emit(this.selectedProduct);
  }
}
