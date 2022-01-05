package com.ydays.dart;

import com.ydays.dart.model.GamePlayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AroundTheWorld {
    Scanner scanner = new Scanner(System.in);


    protected void startAroundTheWorld(ArrayList<GamePlayer> listGamer){
        int winner = 0;
        int ordre = 1;
        //trie la liste en fonction de l'ordre de passage
        listGamer.sort(Comparator.comparing(GamePlayer::getOrder));

        while(true){
            for (int i = 0; i < listGamer.size(); i++){
                if (ordre == listGamer.get(i).getOrder()){
                    winner = getScoreFleche(listGamer.get(i));
                    if (winner != 0){
                        break;
                    }
                    ordre ++;
                }
                else {
                    ordre = 1;
                }
            }
            ordre = 1;
            if (winner != 0){
                break;
            }
        }
    }

    protected int getScoreFleche(GamePlayer joueurEnCours){
        int winner = 0;
        int repNumeroCase;
        int score = joueurEnCours.getScore();
        joueurEnCours.setRemainingShots(3);
        int nbrTour = joueurEnCours.getRemainingShots();
        for (int i = 1; i <= 3; i++){
            System.out.println("Fleche " + i + " autour du joueur " + joueurEnCours.getPlayerId() + " tu dois viser la case " + score + 1);
            String rep = scanner.next();
            repNumeroCase = Integer.parseInt(rep);
            nbrTour --;
            joueurEnCours.setRemainingShots(nbrTour);
            if (repNumeroCase == score + 1){
                joueurEnCours.setScore(repNumeroCase);
                if (joueurEnCours.getScore() == 20){
                    winner = joueurEnCours.getPlayerId();
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
