package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;

@RestController
@RequestMapping
public class PlayerController {
	
	
   @Autowired
	private PlayerService service;
	
   
   //adding players 
   
   @PostMapping("/add")
   public Player addplayer(@RequestBody Player player) {
	   return service.addPlayer(player);
	   
	 //fetching players   
	   
   }
   @GetMapping("/getall")
   public List<Player> getAllPlayers() {
       List<Player> players = service.getAllPlayers();

       
    // Returning  an empty list if no players exist
       if (players.isEmpty()) {  
           return new ArrayList<>();
       } else {
           return players;
       }
   }
   //fetching players by id 
   @GetMapping("/getbyid/{PlayerId}")
   public Player findPlayerById( @PathVariable int  PlayerId) {
	   return service.getPlayerById(PlayerId);
   }
   //deleting the player by id 
   
   @DeleteMapping("/dele/{PlayerId}")
   
   public List<Player> deletePlayer(@PathVariable int PlayerId) {
	   
	   return service.deletePlayerById(PlayerId);
   }
 
   
   // updating the players 
   
   @PutMapping("/update/{id}")
   public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
       return service.updatePlayer(id, player);
   }
   
}
