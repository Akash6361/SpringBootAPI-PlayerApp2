package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;

@Service

public class PlayerService {
	
	@Autowired
	private PlayerRepository repo;
	
	//adding players
	
	public Player addPlayer(Player player) {
		
		
		 Optional<Player> existingPlayer = repo.findByPlayerName(player.getPlayerName());

	        if (existingPlayer.isPresent()) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Player already exists");
	        }
		 return repo.save(player);
		
	}
	
	
	//get all players 
	
	public List<Player> getAllPlayers() {
        return repo.findAll();
    }
	//get player by id 
	public Player getPlayerById(int playerId) {
        Optional<Player> player = repo.findById(playerId);
        
        if (player.isPresent()) {
            return player.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
        }
    }
        		
	
	//deleteing players by id 
	 public List<Player> deletePlayerById(int playerId) {
	        Optional<Player> existingPlayer = repo.findById(playerId);

	        if (existingPlayer.isPresent()) {
	            repo.deleteById(playerId);
	        } else {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
	        }
	        return repo.findAll();
	    }

    public List<Player> getAllPlayerss() {
        return repo.findAll();
    }
	//updating player 
    public Player updatePlayer(int playerId, Player updatedPlayer) {
        Optional<Player> existing = repo.findById(playerId);

        if (existing.isPresent()) {
            Player existingPlayer = existing.get();

          
            existingPlayer.setPlayerName(updatedPlayer.getPlayerName());
            existingPlayer.setCountry(updatedPlayer.getCountry());
            existingPlayer.setSports(updatedPlayer.getSports());
            return repo.save(existingPlayer);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player does not exists");
        }
    }
	
	

}
