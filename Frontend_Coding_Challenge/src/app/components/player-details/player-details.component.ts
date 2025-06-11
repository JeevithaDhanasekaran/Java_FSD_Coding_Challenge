import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerDTO } from 'src/app/models/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.css']
})
export class PlayerDetailsComponent {
  player?: PlayerDTO;

  constructor(
    private route: ActivatedRoute,
    private playerService: PlayerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      //const id = params['id'];
      const id = this.route.snapshot.paramMap.get('id');
      if (id) {
        this.playerService.getById(+id).subscribe(data => {
          this.player = data;
        });
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/']);
  }
}
