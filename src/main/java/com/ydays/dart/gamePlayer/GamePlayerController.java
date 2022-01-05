package com.ydays.dart.gamePlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gamePlayers")
public class GamePlayerController {

    @Autowired
    private GamePlayerService gamePlayerService;

    /**
     * Read - Get all GamePlayer
     * @return - An Iterable object of GamePlayer full filled
     */
    @GetMapping()
    public Iterable<GamePlayer> getGamePlayers() {
        return gamePlayerService.getGamePlayers();
    }

    /**
     * Read - Get one gamePlayer
     * @param id The id of the gamePlayer
     * @return A gamePlayer object full filled
     */
    @GetMapping("/{id}")
    public GamePlayer getGamePlayer(@PathVariable("id") final Long id) {
        return gamePlayerService.getGamePlayer(id).orElse(null);
    }

    /**
     * Create - Add a new gamePlayer
     * @param gamePlayer An object gamePlayer
     * @return The gamePlayer object saved
     */
    @PostMapping()
    public GamePlayer createGamePlayer(@RequestBody GamePlayer gamePlayer) {
        return gamePlayerService.saveGamePlayer(gamePlayer);
    }

    /**
     * Update - Update an existing gamePlayer
     * @param id - The id of the gamePlayer to update
     * @param gamePlayer - The gamePlayer object updated
     * @return The update gamePlayer
     */
    @PutMapping("/{id}")
    public GamePlayer updateGamePlayer(@PathVariable("id") final Long id, @RequestBody GamePlayer gamePlayer) {
        GamePlayer currentGamePlayer =gamePlayerService.getGamePlayer(id).orElse(null);

        if(gamePlayer.getPlayer().getId() != 0){
            currentGamePlayer.setPlayer(gamePlayer.getPlayer());
        }
        if(gamePlayer.getGame().getId() != 0){
            currentGamePlayer.setGame(gamePlayer.getGame());
        }
        if(gamePlayer.getRemainingShots() != 0){
            currentGamePlayer.setRemainingShots(gamePlayer.getRemainingShots());
        }
        if(gamePlayer.getScore() != 0){
            currentGamePlayer.setScore(gamePlayer.getScore());
        }
        if(gamePlayer.getOrder() != 0){
            currentGamePlayer.setOrder(gamePlayer.getOrder());
        }
        if(gamePlayer.getRank() != 0){
            currentGamePlayer.setRank(gamePlayer.getRank());
        }

        gamePlayerService.saveGamePlayer(currentGamePlayer);
        return currentGamePlayer;
    }

    /**
     * Delete - Delete an gamePlayer
     * @param id - The id of the gamePlayer to delete
     */
    @DeleteMapping("/{id}")
    public void deleteGamePlayer(@PathVariable("id") final Long id) {
        gamePlayerService.deleteGamePlayer(id);
    }

}
