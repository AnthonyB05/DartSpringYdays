package com.ydays.dart;

import com.ydays.dart.gamePlayer.GamePlayer;

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

    protected ArrayList<GamePlayer> ordreJoueur(ArrayList<GamePlayer> tabJoueur){
        ArrayList<GamePlayer> ordreJoueurTab = new ArrayList<GamePlayer>();
        GamePlayer joueurRandom;
        int index;
        for (int i =0; i < tabJoueur.size(); i++){
            index = new Random().nextInt(tabJoueur.size());
            joueurRandom = tabJoueur.get(index);

            while (ordreJoueurTab.contains(joueurRandom)){
                index = new Random().nextInt(tabJoueur.size());
                joueurRandom = tabJoueur.get(index);
            }
            joueurRandom.setOrder(i+1);
            ordreJoueurTab.add(joueurRandom);
        }
        return  ordreJoueurTab;
    }
}
