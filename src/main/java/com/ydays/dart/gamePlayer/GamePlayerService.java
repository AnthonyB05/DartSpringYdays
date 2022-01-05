package com.ydays.dart.gamePlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GamePlayerService {

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    public Iterable<GamePlayer> getGamePlayers() {
        return gamePlayerRepository.findAll();
    }

    public Optional<GamePlayer> getGamePlayer(final Long id) {
        return gamePlayerRepository.findById(id);
    }

    public GamePlayer saveGamePlayer(GamePlayer gamePlayer) {
        return gamePlayerRepository.save(gamePlayer);
    }

    public void deleteGamePlayer(final long id) {
        gamePlayerRepository.deleteById(id);
    }

}
