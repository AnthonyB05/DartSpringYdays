package com.ydays.dart.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /**
     * Read - Get all players
     * @return - An Iterable object of Player full filled
     */
    @GetMapping()
    public Iterable<Player> getPlayers() {
        return playerService.getPlayers();
    }


    /**
     * Read - Get one player
     * @param id The id of the player
     * @return A player object full filled
     */
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") final Long id) {
        return playerService.getPlayer(id).orElse(null);
    }

    /**
     * Create - Add a new player
     * @param player An object player
     * @return The player object saved
     */
    @PostMapping()
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    /**
     * Update - Update an existing player
     * @param id - The id of the player to update
     * @param player - The player object updated
     * @return The update player
     */
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable("id") final Long id, @RequestBody Player player) {
        Player currentPlayer =playerService.getPlayer(id).orElse(null);
        if(player.getName() != null){
            currentPlayer.setName(player.getName());
        }
        if(player.getEmail() != null){
            currentPlayer.setEmail(player.getEmail());
        }
        playerService.savePlayer(currentPlayer);
        return currentPlayer;
    }

    /**
     * Delete - Delete a player
     * @param id - The id of the player to delete
     */
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") final Long id) {
        playerService.deletePlayer(id);
    }

}
