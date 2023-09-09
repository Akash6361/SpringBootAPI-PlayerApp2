package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Player;

public interface PlayerRepository  extends JpaRepository<Player, Integer>{

	Optional <Player> findByPlayerName(String playerName);

}
