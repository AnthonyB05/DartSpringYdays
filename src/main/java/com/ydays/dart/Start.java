package com.ydays.dart;

import com.ydays.dart.joueur.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Start {
    public Start(){}

    Scanner scanner = new Scanner(System.in);

    protected int nbrJoueur() {
        String rep;
        int nombre = 0;
        try {
            System.out.println("Combien y a t'il de joueur ? ");
            rep = scanner.next();
            nombre = Integer.parseInt(rep);
            if (nombre < 2) {
                System.out.println("Le nombre de joueur minimum est 2");
                nbrJoueur();
            }
        } catch (Exception e) {
            System.out.println("Veuillez rentrer un nombre valide");
        }
        return nombre;
    }

    protected int modeJeu() {
        String rep;
        int nombre = 0;
        try {
            System.out.println("Quelle mode de jeu ? (saisissez un nombre)");
            System.out.println("1 - Le tour du monde");
            rep = scanner.next();
            nombre = Integer.parseInt(rep);
            if(nombre < 1 || nombre > 1){
                System.out.println("Veuillez saisir un nombre valide");
                modeJeu();
            }
        } catch (Exception e) {
            System.out.println("Veuillez rentrer un nombre valide");
        }
        return nombre;
    }

    protected ArrayList<Player> ordreJoueur(ArrayList<Player> tabPlayer){
        ArrayList<Player> ordrePlayerTab = new ArrayList<Player>();
        Player playerRandom;
        int index;
        for (int i = 0; i < tabPlayer.size(); i++){
            index = new Random().nextInt(tabPlayer.size());
            playerRandom = tabPlayer.get(index);

            while (ordrePlayerTab.contains(playerRandom)){
                index = new Random().nextInt(tabPlayer.size());
                playerRandom = tabPlayer.get(index);
            }
            //playerRandom.setOrdre(i+1);
            ordrePlayerTab.add(playerRandom);
        }
        return ordrePlayerTab;
    }
}
