package com.ydays.dart.repository;

import com.ydays.dart.model.Joueur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends CrudRepository<Joueur, Long> {

}
