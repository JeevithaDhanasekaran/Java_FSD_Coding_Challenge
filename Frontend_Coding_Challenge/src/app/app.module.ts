import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayerListComponent } from './components/player-list/player-list.component';
import { PlayerRegisterComponent } from './components/player-register/player-register.component';
import { PlayerDetailsComponent } from './components/player-details/player-details.component';
import {HttpClientModule}  from '@angular/common/http'

import {FormsModule, ReactiveFormsModule}  from '@angular/forms';
import { NavbarComponent } from './components/navbar/navbar.component'

@NgModule({
  declarations: [
    AppComponent,
    PlayerListComponent,
    PlayerRegisterComponent,
    PlayerDetailsComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
