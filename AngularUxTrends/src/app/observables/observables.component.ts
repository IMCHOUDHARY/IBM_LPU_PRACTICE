import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../service/service.service';

@Component({
  selector: 'app-observables',
  templateUrl: './observables.component.html',
  styleUrls: ['./observables.component.css']
})
export class ObservablesComponent implements OnInit {

  constructor(private service: ServiceService) { }

  products = [];

  ngOnInit(): void {
    // this.products = this.service.product;
    this.service.product().subscribe(
      productData => this.products = productData
    );
  }

}
