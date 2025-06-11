import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerDetailsComponent } from './components/player-details/player-details.component';
import { PlayerListComponent } from './components/player-list/player-list.component';
import { PlayerRegisterComponent } from './components/player-register/player-register.component';

const routes: Routes = [

  { path: '', component: PlayerListComponent },
  { path: 'add', component: PlayerRegisterComponent },
  { path: 'edit/:id', component: PlayerRegisterComponent },
  { path: 'view/:id', component: PlayerDetailsComponent },
  { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
