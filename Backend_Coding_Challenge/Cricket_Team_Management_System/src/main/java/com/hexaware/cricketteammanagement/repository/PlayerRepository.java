package com.hexaware.cricketteammanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketteammanagement.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

	@Modifying
	@Query("update Player p set p.totalMatches = ?2 where p.playerId = ?1")
	int updatePlayerTotalMatch(Long playerId,int newTotalMatch);
}
