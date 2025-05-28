package com.hexaware.cricketteammanagement.entity;

import com.hexaware.cricketteammanagement.enums.PlayerRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player_details")
public class Player {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column(nullable = false)
    private String playerName;

    @Column(nullable = false, unique = true)
    private int jerseyNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlayerRole role;

    @PositiveOrZero(message = "TotalMatches must be positive or zero.")
    private int totalMatches;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private String countryOrStateName;

    private String description;
	
}
