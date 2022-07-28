package com.tennis.kata.tennis.entities;

public class Joueur {

	private String name;
	private int point;
	private int jeu;
	private int set;
	private boolean avantage;
	private boolean dernierPoint;

	public Joueur() {
		super();
		this.point = 0;
		this.jeu = 0;
		this.set = 0;
		this.avantage = false;
		this.dernierPoint = false;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}	
	
	public void setPoint(int point) {
		this.point = point;
	}

	public int getJeu() {
		return jeu;
	}

	public void setJeu(int jeu) {
		this.jeu = jeu;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public boolean isAvantage() {
		return avantage;
	}

	public void setAvantage(boolean avantage) {
		this.avantage = avantage;
	}

	public boolean isDernierPoint() {
		return dernierPoint;
	}

	public void setDernierPoint(boolean dernierPoint) {
		this.dernierPoint = dernierPoint;
	}

	
}
