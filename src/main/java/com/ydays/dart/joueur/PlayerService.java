package com.ydays.dart.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Iterable<Player> getPlayers() {
        return playerRepository.findAll();
    }
}
