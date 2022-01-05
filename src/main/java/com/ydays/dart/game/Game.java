package com.ydays.dart.game;

import com.ydays.dart.gamePlayer.GamePlayer;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "GAMES")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int mode;

    private String name;

    private int currentplayerid;

    private int status;

    public Game(){}

    public Game(int mode, String name, int currentplayerid, int status) {
        this.mode = mode;
        this.name = name;
        this.currentplayerid = currentplayerid;
        this.status = status;
    }

    @OneToMany(mappedBy="game")
    private Set<GamePlayer> gamePlayers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentplayerid() {
        return currentplayerid;
    }

    public void setCurrentplayerid(int currentPlayerId) {
        this.currentplayerid = currentPlayerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(mode, game.mode) && Objects.equals(name, game.name) && Objects.equals(currentplayerid, game.currentplayerid) && Objects.equals(status, game.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mode, name, currentplayerid, status);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", mode='" + mode + '\'' +
                ", name='" + name + '\'' +
                ", currentPlayerId=" + currentplayerid +
                ", status='" + status + '\'' +
                '}';
    }
}
