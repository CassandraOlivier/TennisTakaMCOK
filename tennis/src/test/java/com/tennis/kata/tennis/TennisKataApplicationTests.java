package com.tennis.kata.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tennis.kata.tennis.entities.Joueur;
import com.tennis.kata.tennis.entities.Partie;
import com.tennis.kata.tennis.services.CompteurDeScoreTennis;

@SpringBootTest
class TennisKataApplicationTests {

	@Autowired
	private CompteurDeScoreTennis compteurDeScoreTennis;

	@Test
	void contextLoads() {
	}

	@Test
	public void creationJoueur_returnName() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");

		assertEquals("joueur1", joueur1.getName());
	}

	@Test
	public void creationJoueur_returnNameEmpty() {

		assertThrows(Exception.class, () -> compteurDeScoreTennis.creationJoueur(""));
	}

	@Test
	public void creationPartie_return2Joueurs() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		assertEquals(joueur1, partie.getJoueur1());
		assertEquals(joueur2, partie.getJoueur2());
	}

	@Test
	public void creationPartie_return2JoueursAvec0Point() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		assertEquals(0, partie.getJoueur1().getPoint());
		assertEquals(0, partie.getJoueur2().getPoint());
	}

	@Test
	public void creationPartie_return2JoueursAvec0PointPassantJoueurAvecPoint() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");
		joueur1.setPoint(15);
		joueur2.setPoint(30);
		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		assertEquals(0, partie.getJoueur1().getPoint());
		assertEquals(0, partie.getJoueur2().getPoint());
	}

	@Test
	public void creationPartie_return2JoueursAvec0Jeu() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		assertEquals(0, partie.getJoueur1().getJeu());
		assertEquals(0, partie.getJoueur2().getJeu());
	}

	@Test
	public void creationPartie_return2JoueursAvec0PointPassantJoueurAvecJeu() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");
		joueur1.setJeu(1);
		joueur2.setJeu(2);
		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		assertEquals(0, partie.getJoueur1().getJeu());
		assertEquals(0, partie.getJoueur2().getJeu());
	}

	@Test
	public void creationPartie_return2JoueursAvec0Set() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		assertEquals(0, partie.getJoueur1().getSet());
		assertEquals(0, partie.getJoueur2().getSet());
	}

	@Test
	public void creationPartie_return2JoueursAvec0SetPassantJoueurAvecSet() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");
		joueur1.setSet(1);
		joueur2.setSet(2);
		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		assertEquals(0, partie.getJoueur1().getSet());
		assertEquals(0, partie.getJoueur2().getSet());
	}

	// Methode fail
	@Test
	public void creationPartie_returnJoueurAvec1Point() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		compteurDeScoreTennis.ajoutPointJoueur(joueur1);

		assertEquals(1, partie.getJoueur1().getPoint());
	}

	@Test
	public void creationPartie_return15Avec1Point() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		compteurDeScoreTennis.ajoutPointJoueur(joueur1);

		assertEquals(15, partie.getJoueur1().getPoint());
	}

	@Test
	public void creationPartie_return30Avec1Point() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur1);

		assertEquals(30, partie.getJoueur1().getPoint());
	}

	@Test
	public void creationPartie_return40Avec1Point() throws Exception {
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur1);

		assertEquals(40, partie.getJoueur1().getPoint());
	}

	@Test

	public void egaliteJoueurAucunAvantage() throws Exception {

		// GIVEN
		// joueur 1
		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur2);
		compteurDeScoreTennis.ajoutPointJoueur(joueur2);
		compteurDeScoreTennis.ajoutPointJoueur(joueur2);
		// WHEN
		compteurDeScoreTennis.ajoutAvantageJoueur(partie);
		// THEN

		assertTrue(joueur1.isAvantage());
	}

	@Test

	public void egaliteJoueurPerdAvantage() throws Exception {

		// GIVEN

		// joueur 1

		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");
		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur1);
		compteurDeScoreTennis.ajoutPointJoueur(joueur1);

		compteurDeScoreTennis.ajoutPointJoueur(joueur2);
		compteurDeScoreTennis.ajoutPointJoueur(joueur2);
		compteurDeScoreTennis.ajoutPointJoueur(joueur2);

		compteurDeScoreTennis.ajoutPointJoueur(joueur1);

		// WHEN

		compteurDeScoreTennis.ajoutAvantageJoueur(partie);

		// THEN

		assertFalse(joueur1.isAvantage());

	}

	@Test

	public void egaliteJoueurAUnAvantageGagneLeJeu() throws Exception {

		// GIVEN

		// joueur 1

		Joueur joueur1 = compteurDeScoreTennis.creationJoueur("joueur1");

		joueur1.setPoint(40);

		joueur1.setAvantage(true);

		// joueur 2

		Joueur joueur2 = compteurDeScoreTennis.creationJoueur("joueur2");

		joueur2.setPoint(40);

		// création de la partie

		Partie partie = compteurDeScoreTennis.creationPartie(joueur1, joueur2);

		// WHEN

		compteurDeScoreTennis.ajoutAvantageJoueur(partie);

		// THEN

		assertTrue(joueur1.isAvantage());

	}
}
