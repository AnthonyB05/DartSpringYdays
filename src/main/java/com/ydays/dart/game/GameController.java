package com.ydays.dart.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * Read - Get all joueurs
     * @return - An Iterable object of Joueur full filled
     */
    @GetMapping("/games")
    public Iterable<Game> getGames() {
        return gameService.getGames();
    }
}
