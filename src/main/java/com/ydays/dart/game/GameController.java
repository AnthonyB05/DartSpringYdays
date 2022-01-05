package com.ydays.dart.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController{

    @Autowired
    private GameService gameService;

    /**
     * Read - Get all game
     * @return - An Iterable object of Game full filled
     */
    @GetMapping()
    public Iterable<Game> getGames() {
        return gameService.getGames();
    }

    /**
     * Read - Get one game
     * @param id The id of the game
     * @return A game object full filled
     */
    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") final Long id) {
        return gameService.getGame(id).orElse(null);
    }

    /**
     * Create - Add a new game
     * @param game An object game
     * @return The game object saved
     */
    @PostMapping()
    public Game createGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    /**
     * Update - Update an existing game
     * @param id - The id of the game to update
     * @param game - The game object updated
     * @return The update game
     */
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable("id") final Long id, @RequestBody Game game) {
        Game currentGame =gameService.getGame(id).orElse(null);

        if(game.getMode() != 0){
            currentGame.setMode(game.getMode());
        }
        if(game.getName() != null){
            currentGame.setName(game.getName());
        }
        if(game.getCurrentplayerid() != 0){
            currentGame.setCurrentplayerid(game.getCurrentplayerid());
        }
        if(game.getStatus() != 0){
            currentGame.setStatus(game.getStatus());
        }

        gameService.saveGame(currentGame);
        return currentGame;
    }

    /**
     * Delete - Delete a game
     * @param id - The id of the game to delete
     */
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable("id") final Long id) {
        gameService.deleteGame(id);
    }

}
