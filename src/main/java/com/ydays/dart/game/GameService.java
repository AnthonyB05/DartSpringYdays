package com.ydays.dart.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }
}
