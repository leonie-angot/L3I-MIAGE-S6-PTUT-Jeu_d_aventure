package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.Objet;
import jeu.Zone;

class ObjetTest {

	Objet o;
	Zone z;
	
	@BeforeEach
	void setUp() throws Exception {
		z = new Zone("le Tableau des Suspects","0-Tableau.jpg");
		o = new Objet("Couteau", "Les seules empreintes trouvées sur le couteau sont celles du Cuisiner.",z );
	}

	@Test
	void testGetObjetRecupere() {
		assertFalse(o.getObjetRecupere());
		o.setObjetRecupere();
		assertTrue(o.getObjetRecupere());
	}
	
	@Test
	void testGetNom() {
		assertEquals(o.getNom(),"Couteau");
	}
	
	@Test
	void testGetDescription() {
		assertEquals(o.getDescription(),"Les seules empreintes trouvées sur le couteau sont celles du Cuisiner.");
		o.setDescriptionObjet("TocToc");
		assertEquals(o.getDescription(),"TocToc");
	}
	
	@Test
	void testSetDescriptionObjet() {
		o.setDescriptionObjet("TocToc");
		assertEquals(o.getDescription(),"TocToc");
	}
	
	
	
	

}
