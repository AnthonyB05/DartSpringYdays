package com.ydays.dart.gamePlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamePlayerService {

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    public Iterable<GamePlayer> getGamePlayer() {
        return gamePlayerRepository.findAll();
    }
}
