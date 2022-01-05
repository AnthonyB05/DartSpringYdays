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

		Player player1 = new Player(1L,"Cuffet", "solene.cuffet@hotmail.fr");
		Player player2 = new Player(2L,"Bastard", "bastard@hotmail.fr");

		Game game = new Game(1L,1,"test",0,1);
		ArrayList<GamePlayer> tabJoueur = new ArrayList<>();
		GamePlayer j1 = new GamePlayer(1L,player1,game,0,0,0,0);
		GamePlayer j2 = new GamePlayer(2L,player2,game,0,0,0,0);
		//GamePlayer j3 = new GamePlayer(3,3,3,0,0,0,0,true);

		tabJoueur.add(j1);
		tabJoueur.add(j2);
		//tabJoueur.add(j3);

/*        int nombreJoueur = start.nbrJoueur();
        int modeJeu = start.modeJeu();*/

		ArrayList<GamePlayer> JoueurOrdre;
		JoueurOrdre = start.ordreJoueur(tabJoueur);
		aroundTheWorld.startAroundTheWorld(JoueurOrdre);



	}

}
