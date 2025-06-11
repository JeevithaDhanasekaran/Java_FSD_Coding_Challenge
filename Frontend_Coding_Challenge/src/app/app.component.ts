import { Component } from '@angular/core';
import { PlayerOutputDTO } from './models/player';
import { PlayerService } from './services/player.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // title = 'Cricket_Team_Management_App';

  players: PlayerOutputDTO[] = [];

  constructor(private playerService: PlayerService) {}

  handleSearch(name: string): void {
    if (name) {
      this.playerService.searchPlayersByName(name).subscribe(data => {
        this.players = data;
      });
    }
  }

}
