package com.ydays.dart.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoueurController {

    @Autowired
    private JoueurService joueurService;

    /**
     * Read - Get all joueurs
     * @return - An Iterable object of Joueur full filled
     */
    @GetMapping("/joueurs")
    public Iterable<Joueur> getEmployees() {
        return joueurService.getJoueurs();
    }

}
