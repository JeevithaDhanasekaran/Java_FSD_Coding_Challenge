import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PlayerOutputDTO, PlayerDTO } from '../models/player';
@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private baseUrl = 'http://localhost:8080/api/players';

  constructor(private http: HttpClient) {

  }
  getAllPlayers(): Observable<PlayerOutputDTO[]> {
    return this.http.get<PlayerOutputDTO[]>(this.baseUrl);
  }

  getById(id: number): Observable<PlayerDTO> {
    return this.http.get<PlayerDTO>(`${this.baseUrl}/${id}`);
  }

  create(player: PlayerDTO): Observable<PlayerDTO> {
    return this.http.post<PlayerDTO>(this.baseUrl, player);
  }

  update(id: number, player: PlayerDTO): Observable<PlayerDTO> {
    return this.http.put<PlayerDTO>(`${this.baseUrl}/${id}`, player);
  }

  delete(id: number): Observable<string> {
    return this.http.delete<string>(`${this.baseUrl}/${id}`);
  }

  updateTotalMatches(id: number, totalMatch: number): Observable<string> {
    return this.http.put<string>(`${this.baseUrl}/${id}/${totalMatch}`, null);
  }

  searchPlayersByName(name: string): Observable<PlayerOutputDTO[]> {
    return this.http.get<PlayerOutputDTO[]>(`${this.baseUrl}/search?name=${name}`);
  }
}
