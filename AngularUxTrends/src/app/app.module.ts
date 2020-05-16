import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { RoutingComponentComponent } from './routing-component/routing-component.component';
import { HomeComponent } from './routing-component/home/home.component';
import { AboutComponent } from './routing-component/about/about.component';
import { ComponentCommunicationComponent } from './component-communication/component-communication.component';
import { ChildComponentComponent } from './component-communication/child-component/child-component.component';

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
    ChildComponentComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
