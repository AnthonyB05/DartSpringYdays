package com.ydays.dart.service;

import com.ydays.dart.model.Joueur;
import com.ydays.dart.repository.JoueurRepository;
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
