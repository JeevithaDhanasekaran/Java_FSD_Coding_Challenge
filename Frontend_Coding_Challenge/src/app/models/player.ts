export enum PlayerRole {
  Batsman = 'Batsman',
  Bowler = 'Bowler',
  Keeper = 'Keeper',
  AllRounder = 'AllRounder'
}

export interface PlayerDTO {
  playerId?: number;
  playerName: string;
  jerseyNumber: number;
  role: PlayerRole;
  totalMatches: number;
  teamName: string;
  countryOrStateName?: string;
  description?: string;
}

export interface PlayerOutputDTO {
  playerId: number;
  playerName: string;
  jerseyNumber: number;
  role: PlayerRole;
}