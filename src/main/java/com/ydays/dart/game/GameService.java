package com.ydays.dart.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGame(final Long id) {
        return gameRepository.findById(id);
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(final long id) {
        gameRepository.deleteById(id);
    }

}
