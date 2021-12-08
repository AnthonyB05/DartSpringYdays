package com.ydays.dart.joueur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoueurService {

    @Autowired
    private JoueurRepository joueurRepository;

    public Iterable<Joueur> getJoueurs() {
        return joueurRepository.findAll();
    }
}
