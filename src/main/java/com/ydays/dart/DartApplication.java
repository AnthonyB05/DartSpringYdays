package com.ydays.dart;

import com.ydays.dart.model.GamePlayer;
import com.ydays.dart.model.Joueur;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class DartApplication {
    public static void main(String[] args) {
        SpringApplication.run(DartApplication.class, args);
        Start start = new Start();
        ArrayList<GamePlayer> tabJoueur = new ArrayList<GamePlayer>();

        GamePlayer j1 = new GamePlayer(1,1,1,0,0,0,0,true);
        GamePlayer j2 = new GamePlayer(2,2,2,0,0,0,0,true);
        //GamePlayer j3 = new GamePlayer(3,3,3,0,0,0,0,true);

        tabJoueur.add(j1);
        tabJoueur.add(j2);
        //tabJoueur.add(j3);

/*        int nombreJoueur = start.nbrJoueur();
        int modeJeu = start.modeJeu();*/

        ArrayList<GamePlayer> JoueurOrdre = null;
        JoueurOrdre = start.ordreJoueur(tabJoueur);
        System.out.println(JoueurOrdre);



    }

}

