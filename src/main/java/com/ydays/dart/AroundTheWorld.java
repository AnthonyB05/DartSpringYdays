package com.ydays.dart;


import com.ydays.dart.gamePlayer.GamePlayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AroundTheWorld {
    Scanner scanner = new Scanner(System.in);


    protected void startAroundTheWorld(ArrayList<GamePlayer> listGamer){
        Long winner = 0L;
        int ordre = 1;
        //trie la liste en fonction de l'ordre de passage
        listGamer.sort(Comparator.comparing(GamePlayer::getOrder));

        do {
            for (GamePlayer gamePlayer : listGamer) {
                if (ordre == gamePlayer.getOrder()) {
                    winner = getScoreFleche(gamePlayer);
                    if (winner != 0) {
                        break;
                    }
                    ordre++;
                } else {
                    ordre = 1;
                }
            }
            ordre = 1;
        } while (winner == 0);
    }

    protected Long getScoreFleche(GamePlayer joueurEnCours){
        Long winner = 0L;
        int repNumeroCase;
        joueurEnCours.setRemainingShots(3);
        int nbrTour = joueurEnCours.getRemainingShots();
        for (int i = 1; i <= 3; i++){
            System.out.println("Fleche " + i + " autour du joueur " + joueurEnCours.getPlayer().getName() + " tu dois viser la case " + (joueurEnCours.getScore()+ 1));
            String rep = scanner.next();
            repNumeroCase = Integer.parseInt(rep);
            nbrTour --;
            joueurEnCours.setRemainingShots(nbrTour);
            if (repNumeroCase == joueurEnCours.getScore() + 1){
                joueurEnCours.setScore(repNumeroCase);
                if (joueurEnCours.getScore() == 20){
                    System.out.println("Le joueur " + joueurEnCours.getPlayer().getName() + " a gagné");
                    winner = joueurEnCours.getPlayer().getId();
                }
            }
            else{
                System.out.println("Raté il vous reste " + joueurEnCours.getRemainingShots() + " tours");
            }

            if (winner != 0){
                break;
            }
        }
        return winner;
    }

}
