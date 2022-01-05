package com.ydays.dart;

import com.ydays.dart.game.Game;
import com.ydays.dart.gamePlayer.GamePlayer;
import com.ydays.dart.joueur.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Start {
    public Start(){}

    Scanner scanner = new Scanner(System.in);

    private int nbrJoueur() {
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

    protected ArrayList<GamePlayer> createProcessusJeu(Game game){
        int nbrJoueur = nbrJoueur();
        String nom;
        String email;
        ArrayList<GamePlayer> listJoueurs = new ArrayList<GamePlayer>();
        for (int i = 0; i < nbrJoueur; i++){
            System.out.println("Quel est votre nom ? ");
            nom = scanner.next();
            System.out.println("Quel est votre email ? ");
            email = scanner.next();
            Player player = new Player(nom,email);
            GamePlayer gamePlayer = new GamePlayer(player,game,0,0,0,0);
            listJoueurs.add(gamePlayer);
        }
        listJoueurs = ordreJoueur(listJoueurs);
        return listJoueurs;
    }

    protected Game createGame(){
        int modeJeu = modeJeu();
        String nomJeu = nomJeu();

        Game game = new Game(modeJeu,nomJeu,0L,1);
        return game;
    }

    private int modeJeu() {
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

    private String nomJeu(){
        System.out.println("Comment voulez-vous nommer votre partie ? ");
        String rep = scanner.next();
        return rep;
    }

    private ArrayList<GamePlayer> ordreJoueur(ArrayList<GamePlayer> tabJoueur){
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
