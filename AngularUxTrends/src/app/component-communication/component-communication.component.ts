import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-component-communication',
  templateUrl: './component-communication.component.html',
  styleUrls: ['./component-communication.component.css']
})
export class ComponentCommunicationComponent implements OnInit {

  constructor() {
  }

  toCart = false;
  isSelected = false;
  selectedProduct = '';
  cartProduct = '';

  ngOnInit(): void {
  }

  selectProduct(product) {
    this.isSelected = true;
    this.selectedProduct = product;
  }

  addProduct(proData)
  {
    // this.toCart = true;
    this.cartProduct = proData;
  }
}

