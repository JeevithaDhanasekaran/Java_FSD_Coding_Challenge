package com.hexaware.cricketteammanagement.service;

import java.util.List;

import com.hexaware.cricketteammanagement.dto.PlayerDTO;
import com.hexaware.cricketteammanagement.dto.PlayerOutputDTO;

public interface IPlayerService {
	PlayerDTO addPlayer(PlayerDTO playerDto);

	PlayerDTO updatePlayer(Long playerId, PlayerDTO playerDTO);

	PlayerOutputDTO getPlayerById(Long playerId);

	List<PlayerOutputDTO> getAllPlayers();

	void deletePlayer(Long playerId);

	int updatePlayerTotalMatch(Long playerId, int newTotalMatch);
}
