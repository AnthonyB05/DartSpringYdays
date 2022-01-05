package com.ydays.dart.gamePlayer;

import com.ydays.dart.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamePlayerController {

    @Autowired
    private GamePlayerService gamePlayerService;

    /**
     * Read - Get all GamePlayer
     * @return - An Iterable object of GamePlayer full filled
     */
    @GetMapping("/gamePlayer")
    public Iterable<GamePlayer> getGamePlayer() {
        return gamePlayerService.getGamePlayer();
    }
}
