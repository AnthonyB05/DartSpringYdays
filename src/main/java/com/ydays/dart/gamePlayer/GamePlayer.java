package com.ydays.dart.gamePlayer;

import com.ydays.dart.game.Game;
import com.ydays.dart.joueur.Player;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GAMEPLAYER")
public class GamePlayer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="player_id", nullable=false)
    private Player player;

    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private Game game;

    private int remainingShots;

    private int score;

    private int order;

    private int rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getRemainingShots() {
        return remainingShots;
    }

    public void setRemainingShots(int remainingShots) {
        this.remainingShots = remainingShots;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePlayer that = (GamePlayer) o;
        return id == that.id && remainingShots == that.remainingShots && score == that.score && order == that.order && rank == that.rank && Objects.equals(player, that.player) && Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player, game, remainingShots, score, order, rank);
    }

    @Override
    public String toString() {
        return "GamePlayer{" +
                "id=" + id +
                ", player=" + player +
                ", game=" + game +
                ", remainingShots=" + remainingShots +
                ", score=" + score +
                ", order=" + order +
                ", rank=" + rank +
                '}';
    }
}
