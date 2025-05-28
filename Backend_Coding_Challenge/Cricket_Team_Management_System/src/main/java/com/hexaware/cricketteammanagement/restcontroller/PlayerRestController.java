package com.hexaware.cricketteammanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketteammanagement.dto.PlayerDTO;
import com.hexaware.cricketteammanagement.dto.PlayerOutputDTO;
import com.hexaware.cricketteammanagement.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

	@Autowired
	IPlayerService playerService;

	@GetMapping
	public ResponseEntity<List<PlayerOutputDTO>> getAllPlayers() {
		return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody PlayerDTO playerDto) {
		PlayerDTO created = playerService.addPlayer(playerDto);
		return new ResponseEntity<>(created, HttpStatus.OK);
	}

	@GetMapping("/{playerId}")
	public ResponseEntity<PlayerOutputDTO> getPlayerById(@PathVariable Long playerId) {
		PlayerOutputDTO player = playerService.getPlayerById(playerId);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	@PutMapping("/{playerId}")
	public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long playerId, @RequestBody PlayerDTO playerDto) {
		PlayerDTO player = playerService.updatePlayer(playerId, playerDto);
		return new ResponseEntity<>(player, HttpStatus.OK);

	}

	@DeleteMapping("/{playerId}")
	public ResponseEntity<String> deletePlayer(@PathVariable Long playerId) {
		playerService.deletePlayer(playerId);
		return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
	}

	@PutMapping("/{playerId}/{totalMatch}")
	public ResponseEntity<String> updateTotalMatches(@PathVariable Long playerId, @PathVariable int totalMatch) {
		if (playerService.updatePlayerTotalMatch(playerId, totalMatch) > 0) {
			return ResponseEntity.ok("Player Updated with new TotalMatch count successfully");
		}
		return new ResponseEntity<>("Couldn't update Match Count", HttpStatus.BAD_REQUEST);
	}

}
