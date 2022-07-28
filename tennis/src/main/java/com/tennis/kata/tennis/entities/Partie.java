package com.tennis.kata.tennis.entities;

public class Partie {

	private Joueur joueur1;
	private Joueur joueur2;
	
	public Partie() {
		super();
	}

	
	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public boolean setJoueurs(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		
		if(null != this.joueur1 && null != this.joueur2) {
			return true;		
		}else {
			return false;
		}
	}
	
}
