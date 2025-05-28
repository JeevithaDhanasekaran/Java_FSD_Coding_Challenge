package com.hexaware.cricketteammanagement.dto;

import com.hexaware.cricketteammanagement.enums.PlayerRole;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
	
	
	private Long playerId;

	@NotNull
    private String playerName;

	@Min(value = 1)
    private int jerseyNumber;

    private PlayerRole role;

	@PositiveOrZero
    private int totalMatches;

	@NotNull
    private String teamName;

    private String countryOrStateName;

    private String description;
}
