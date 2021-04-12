package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Jeu.Sortie;
import Jeu.Zone;

class ZoneTest {

    Zone z;
    Zone zoneVoisine;

    @BeforeEach
    void setUp() throws Exception {
        z = new Zone("le Tableau des Suspects", "0-Tableau.jpg");
        zoneVoisine = new Zone("l'Entree", "1-Entree.jpg");

    }

    @Test
    void testAjouteSortie() {
        int size = z.sizeOfSorties();
        z.ajouteSortie(Sortie.SUD, zoneVoisine);
        assertEquals(z.sizeOfSorties(), size + 1);
    }

    @Test
    void testNomImage() {
        assertEquals(z.nomImage(), "0-Tableau.jpg");
        assertEquals(zoneVoisine.nomImage(), "1-Entree.jpg");
    }

    @Test
    void testSetNomImage() {
        assertEquals(z.nomImage(), "0-Tableau.jpg");
        z.setNomImage("100-DanDan.jpg");
        assertEquals(z.nomImage(), "100-DanDan.jpg");
    }
    @Test
    void testToString(){
        assertEquals("le Tableau des Suspects",z.toString());
    }
    @Test
    void testdescriptionLongue(){
        String s ="Vous �tes dans " + z.description + "\nSorties : " + z.sorties();
        assertEquals(s,z.descriptionLongue());
    }




}