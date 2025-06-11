import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { PlayerDTO, PlayerRole } from 'src/app/models/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-register',
  templateUrl: './player-register.component.html',
  styleUrls: ['./player-register.component.css']
})
export class PlayerRegisterComponent {
  playerForm!: FormGroup;
  isEditMode = false;
  playerId!: number;
  roles = Object.values(PlayerRole);

  constructor(
    private fb: FormBuilder, private playerService: PlayerService, private router: Router, private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.playerForm = this.fb.group({
      playerName: ['', Validators.required],
      jerseyNumber: [1, [Validators.required, Validators.min(1)]],
      role: ['', Validators.required],
      totalMatches: [0, Validators.min(0)],
      teamName: ['', Validators.required],
      countryOrStateName: ['India'],
      description: ['']
    });
    this.playerId = this.route.snapshot.params['id'];
    this.isEditMode = !!this.playerId;

    this.route.queryParams.subscribe(params => {
      if (params['id']) {
        this.isEditMode = true;
        this.playerId = +params['id'];
        this.playerService.getById(this.playerId).subscribe(data => {
          this.playerForm.patchValue(data);
        });
      }
    });
  }
  onSubmit(): void {
    if (this.playerForm.invalid) return;

    const playerData: PlayerDTO = this.playerForm.value;

    if (this.isEditMode) {
      this.playerService.update(this.playerId, playerData).subscribe(() => {
        alert('Player updated successfully');
        this.router.navigate(['/']);
      });
    } else {
      this.playerService.create(playerData).subscribe(() => {
        alert('Player added successfully');
        this.router.navigate(['/']);
      });
    }
  }

}
