package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.GUI;
import jeu.Jeu;
import sun.applet.Main;

class JeuTest {

	Jeu jeu;
	GUI gui;


	@BeforeEach
	void setUp() throws Exception {
		jeu = new Jeu();
		gui = new GUI( jeu);
	}

	@Test
	void testJeuInit() {
		assertEquals(jeu.getNbIndices(), 10);
		assertEquals(jeu.getNbDialogues(), 57);
		assertEquals(jeu.getNbObjets(), 8);
		assertEquals(jeu.getNbZone(), 28);
	}
	
	@Test
	void testSetGUI() {
		jeu.setGUI(gui);
		assertNotEquals(jeu.gui, null);
	}
	
	@Test
	void testPermissionTeleportation() {
		jeu.setGUI(gui);
		jeu.traiterCommande("tp");
		assertTrue(jeu.getTpPossible());
	}
	
	@Test
	void testTeleporterJoueur() {
		jeu.setGUI(gui);
		jeu.permissionAccuser();
		jeu.traiterCommande("ACCUSER");
		assertEquals(jeu.getZoneCourante().nomImage(),"1-Entree.jpg");
		jeu.permissionTeleportation();
		jeu.traiterCommande("13");
		assertEquals(jeu.getZoneCourante().nomImage(),"13-EscalierAvecCouloir.jpg");
	}
	
	@Test
	void testPermissionCarte() {
		assertFalse(jeu.getVisionCartePossible());
		jeu.permissionCarte();
		assertTrue(jeu.getVisionCartePossible());
	}
	
	@Test
	void testPermissionInventaire() {
		assertFalse(jeu.getPermissionInventaire());
		jeu.permissionInventaire();
		assertTrue(jeu.getPermissionInventaire());
	}
	
	@Test
	void testPermissionAccuser() {
		assertFalse(jeu.getPermissionAccuser());
		jeu.permissionAccuser();
		assertTrue(jeu.getPermissionAccuser());
	}
	
	@Test
	void testMontrerCarteJoueur() {
		jeu.setGUI(gui);
		jeu.permissionCarte();
		jeu.traiterCommande("SS");
		assertEquals(jeu.getZoneCourante().nomImage(),"20-PlanMaisonSousSol.jpg");
	}
	
	@Test
	void testRetenirZone() {
		jeu.setGUI(gui);
		jeu.permissionAccuser();
		jeu.traiterCommande("AC");
		jeu.retenirZone();
		assertEquals(jeu.getZonePrec().nomImage(),"1-Entree.jpg");
	}
	
	@Test
	void testRevenirZonePrecedente() {
		jeu.setGUI(gui);
		jeu.retenirZone();
		jeu.revenirZonePrecedente();
		assertEquals(jeu.getZoneCourante().nomImage(),"26-EcranDAccueil.jpg");
	}
	
	@Test
	void testUtiliserPrendreAndPrendre() {
		jeu.setGUI(gui);
		int size = jeu.getSizeInventaire();
		jeu.traiterCommande("JOUER");
		jeu.traiterCommande("JOUER");
		jeu.traiterCommande("EST");
		jeu.traiterCommande("NORD");
		jeu.traiterCommande("PR");
		assertTrue(jeu.tabObjet.get(0).getObjetRecupere());
		assertEquals(jeu.getSizeInventaire(), size + 1);
	}
	
	@Test
	void testRecupererIndice() {
		jeu.setGUI(gui);
		int size = jeu.getSizeListeIndices();
		jeu.traiterCommande("JOUER");
		jeu.traiterCommande("JOUER");
		jeu.permissionParler();
		jeu.traiterCommande("4");
		assertTrue(jeu.tabIndice.get(3).getIndiceRecup());
		assertEquals(jeu.getSizeListeIndices(), size + 1);
	}

}
