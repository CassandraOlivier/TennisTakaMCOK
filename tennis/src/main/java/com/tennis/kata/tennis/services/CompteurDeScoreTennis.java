package com.tennis.kata.tennis.services;

import org.springframework.stereotype.Service;

import com.tennis.kata.tennis.entities.Joueur;
import com.tennis.kata.tennis.entities.Partie;

@Service
public class CompteurDeScoreTennis {
	
	public Joueur creationJoueur(String nom) throws Exception {
		if(nom.equals("")) {
			throw new Exception();
		}else {
			Joueur joueur1 = new Joueur();
		
			joueur1.setName(nom);
			return joueur1;
		}
	}
	
	public Partie creationPartie(Joueur joueur1, Joueur joueur2) {
		Partie partie = new Partie();
    	
		if(0 != joueur1.getPoint() || 0 != joueur2.getPoint()) {
			joueur1.setPoint(0);
			joueur2.setPoint(0);
		}
		
		if(0 != joueur1.getJeu() || 0 != joueur2.getJeu()) {
			joueur1.setJeu(0);
			joueur2.setJeu(0);
		}
		
		if(0 != joueur1.getSet() || 0 != joueur2.getSet()) {
			joueur1.setSet(0);
			joueur2.setSet(0);
		}
		
    	partie.setJoueurs(joueur1,joueur2);
    	
    	return partie;
	}

	public void ajoutPointJoueur(Joueur joueur1) {
		int point = joueur1.getPoint();
		joueur1.setPoint(point++);
	}
}
