import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PlayerDTO, PlayerOutputDTO } from 'src/app/models/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent {
  players: PlayerOutputDTO[] = [];

  constructor(private playerService: PlayerService, private router: Router) { }

  ngOnInit(): void {
    this.getPlayers();
  }

  getPlayers(): void {
    this.playerService.getAllPlayers().subscribe(
      (data) => this.players = data,
      (err) => console.error('Error fetching players', err)
    );
  }

  deletePlayer(id: number): void {
    if (confirm('Are you sure to delete this player?')) {
      this.playerService.delete(id).subscribe(() => {
        this.players = this.players.filter(p => p.playerId !== id);
      });
    }
  }

  viewPlayer(id: number): void {
    this.router.navigate(['/view', id]);
  }

  editPlayer(id: number): void {
    this.router.navigate(['/edit', id]);
  }
}
