package com.ydays.dart.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Iterable<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayer(final Long id) {
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player Player) {
        return playerRepository.save(Player);
    }

    public void deletePlayer(final long id) {
        playerRepository.deleteById(id);
    }

}
