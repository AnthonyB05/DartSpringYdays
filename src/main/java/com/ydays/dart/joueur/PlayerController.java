package com.ydays.dart.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /**
     * Read - Get all players
     * @return - An Iterable object of Player full filled
     */
    @GetMapping("/players")
    public Iterable<Player> getPlayers() {
        return playerService.getPlayers();
    }

}
