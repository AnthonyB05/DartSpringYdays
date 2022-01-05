package com.ydays.dart;


import com.ydays.dart.gamePlayer.GamePlayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AroundTheWorld {
    Scanner scanner = new Scanner(System.in);


    protected void startAroundTheWorld(ArrayList<GamePlayer> listGamer){
        boolean winner = false;
        int ordre = 1;
        //trie la liste en fonction de l'ordre de passage
        listGamer.sort(Comparator.comparing(GamePlayer::getOrder));

        while (!winner){
            for (GamePlayer gamePlayer : listGamer) {
                if (ordre == gamePlayer.getOrder()) {
                    winner = getScoreFleche(gamePlayer);
                    ordre++;
                    if (winner) {
                        break;
                    }
                } else {
                    ordre = 1;
                }
            }
            ordre = 1;
        }
    }

    protected boolean getScoreFleche(GamePlayer joueurEnCours){
        boolean winner = false;
        int repNumeroCase;
        joueurEnCours.setRemainingShots(3);
        int nbrTour = joueurEnCours.getRemainingShots();
        for (int i = 1; i <= 3; i++){
            //TODO : A corriger constructor manque id et corriger current id
            joueurEnCours.getGame().setCurrentplayerid(joueurEnCours.getPlayer().getId());
            System.out.println("Fleche " + i + " autour du joueur " + joueurEnCours.getPlayer().getName() + " tu dois viser la case " + (joueurEnCours.getScore()+ 1));
            String rep = scanner.next();
            repNumeroCase = Integer.parseInt(rep);
            nbrTour --;
            joueurEnCours.setRemainingShots(nbrTour);
            if (repNumeroCase == joueurEnCours.getScore() + 1){
                joueurEnCours.setScore(repNumeroCase);
                if (joueurEnCours.getScore() == 5){
                    System.out.println("Le joueur " + joueurEnCours.getPlayer().getName() + " a gagné");
                    joueurEnCours.getGame().setStatus(0);
                    joueurEnCours.setRank(1);
                    winner = true;
                }
            }
            else{
                System.out.println("Raté il vous reste " + joueurEnCours.getRemainingShots() + " tours");
            }

            if (winner){
                break;
            }
        }
        return winner;
    }

}
