package com.hexaware.cricketteammanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketteammanagement.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

	@Modifying
	@Query("update Player p set p.totalMatches = :newTotalMatch where p.playerId =:playerId")
	int updatePlayerTotalMatch(@Param("playerId") Long playerId,@Param("newTotalMatch") int newTotalMatch);
	
	List<Player> findByPlayerNameContainingIgnoreCase(String name);
}
