package com.ydays.dart.joueur;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends CrudRepository<Joueur, Long> {

}
