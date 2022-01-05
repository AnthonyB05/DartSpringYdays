package com.ydays.dart;

import com.ydays.dart.game.Game;
import com.ydays.dart.gamePlayer.GamePlayer;
import com.ydays.dart.joueur.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DartApplication {
	public static void main(String[] args) {
		SpringApplication.run(DartApplication.class, args);
		Start start = new Start();
		AroundTheWorld aroundTheWorld = new AroundTheWorld();

		Game game = start.createGame();
		ArrayList<GamePlayer> listJoueurs = new ArrayList<GamePlayer>();
		listJoueurs = start.createProcessusJeu(game);
		aroundTheWorld.startAroundTheWorld(listJoueurs);
	}

}
