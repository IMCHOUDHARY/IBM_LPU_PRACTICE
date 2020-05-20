import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { RoutingComponentComponent } from './routing-component/routing-component.component';
import { HomeComponent } from './routing-component/home/home.component';
import { AboutComponent } from './routing-component/about/about.component';
import { ComponentCommunicationComponent } from './component-communication/component-communication.component';
import { ChildComponentComponent } from './component-communication/child-component/child-component.component';
import { ExerciseComponent } from './exercise/exercise.component';
import { ExerciseChildComponent } from './exercise/exercise-child/exercise-child.component';
import { ObservablesComponent } from './observables/observables.component';
import {HttpClientModule} from '@angular/common/http';
import { HttpCRUDComponent } from './http-crud/http-crud.component';
import {FormsModule} from '@angular/forms';
import { LifecycleHooksComponent } from './lifecycle-hooks/lifecycle-hooks.component';
import { Comp1Component } from './lifecycle-hooks/comp1/comp1.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';

const appRoutes: Routes = [
  { path : '' , redirectTo : 'home' , pathMatch : 'full'},
  { path : 'home' , component : HomeComponent},
  { path : 'about' , component : AboutComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    RoutingComponentComponent,
    HomeComponent,
    AboutComponent,
    ComponentCommunicationComponent,
    ChildComponentComponent,
    ExerciseComponent,
    ExerciseChildComponent,
    ObservablesComponent,
    HttpCRUDComponent,
    LifecycleHooksComponent,
    Comp1Component,
    MyOrdersComponent,
    ProductsComponent,
    ProductDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
