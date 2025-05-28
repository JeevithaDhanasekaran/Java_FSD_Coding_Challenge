package com.hexaware.cricketteammanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hexaware.cricketteammanagement.dto.PlayerDTO;
import com.hexaware.cricketteammanagement.dto.PlayerOutputDTO;
import com.hexaware.cricketteammanagement.entity.Player;
import com.hexaware.cricketteammanagement.exception.InvalidInputException;
import com.hexaware.cricketteammanagement.exception.ResourceNotFoundException;
import com.hexaware.cricketteammanagement.repository.PlayerRepository;

@Transactional
@Service
public class PlayerServiceImpl implements IPlayerService {

	
	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public PlayerDTO addPlayer(PlayerDTO playerDto) {
		Player player = new Player();
		player.setPlayerName(playerDto.getPlayerName());
		player.setJerseyNumber(playerDto.getJerseyNumber());
		player.setRole(playerDto.getRole());
		player.setTotalMatches(playerDto.getTotalMatches());
		player.setTeamName(playerDto.getTeamName());
		player.setCountryOrStateName(playerDto.getCountryOrStateName());
		player.setDescription(playerDto.getDescription());
		
		Player saved = playerRepository.save(player);
		playerDto.setPlayerId(saved.getPlayerId());
        return playerDto;
	}

	@Override
	public PlayerDTO updatePlayer(Long playerId, PlayerDTO playerDTO) {
		Optional<Player> foundPlayer = playerRepository.findById(playerId);
        if (foundPlayer.isEmpty()) {
            throw new ResourceNotFoundException("Player with Given Id is not Found. ID:"+playerId);
        }
        Player player = foundPlayer.get();
        if(StringUtils.hasText(playerDTO.getPlayerName()));
        	player.setPlayerName(playerDTO.getPlayerName());
        if(playerDTO.getJerseyNumber()>0)
        	player.setJerseyNumber(playerDTO.getJerseyNumber());
        if(playerDTO.getRole()!=null)
        	player.setRole(playerDTO.getRole());
        if(playerDTO.getTotalMatches()>0)
        	player.setTotalMatches(playerDTO.getTotalMatches());
        if(StringUtils.hasText(playerDTO.getTeamName()))
        	player.setTeamName(playerDTO.getTeamName());
        if(StringUtils.hasText(playerDTO.getCountryOrStateName()))
        	player.setCountryOrStateName(playerDTO.getCountryOrStateName());
        if(StringUtils.hasText(playerDTO.getDescription()))
        	player.setDescription(playerDTO.getDescription());
        
        Player updated = playerRepository.save(player);

        return convertToDTO(updated);
	}

	@Override
	public PlayerOutputDTO getPlayerById(Long playerId) {
		Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player with Given Id is not Found. ID"+playerId));
        return toOutputDTO(player);
	}

	@Override
	public List<PlayerOutputDTO> getAllPlayers() {
		return playerRepository.findAll()
	            .stream()
	            .map(this::toOutputDTO)
	            .collect(Collectors.toList());
	}

	@Override
	public void deletePlayer(Long playerId) {
		if (!playerRepository.existsById(playerId)) {
            throw new ResourceNotFoundException("Player with Given Id is not Found. ID"+playerId);
        }
        playerRepository.deleteById(playerId);

	}

	@Override
	public int updatePlayerTotalMatch(Long playerId, int newTotalMatch) {
		if (newTotalMatch < 0) {
	        throw new InvalidInputException("Total Match count must be greater than 0.");
	    }
	    if (!playerRepository.existsById(playerId)) {
	        throw new ResourceNotFoundException("Player with Given Id is not Found. ID"+playerId);
	    }
	    return playerRepository.updatePlayerTotalMatch(playerId, newTotalMatch);
	}
	
	private PlayerOutputDTO toOutputDTO(Player player) {
	    return new PlayerOutputDTO(
	        player.getPlayerId(),
	        player.getPlayerName(),
	        player.getJerseyNumber(),
	        player.getRole()
	    );
	}
	
	private PlayerDTO convertToDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setRole(player.getRole());
        dto.setTotalMatches(player.getTotalMatches());
        dto.setTeamName(player.getTeamName());
        dto.setCountryOrStateName(player.getCountryOrStateName());
        dto.setDescription(player.getDescription());
        return dto;
    }

}
