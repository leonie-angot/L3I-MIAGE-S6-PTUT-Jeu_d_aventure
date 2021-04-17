package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.Dialogue;
import jeu.GUI;
import jeu.Jeu;
import jeu.Zone;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

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
    @Test
    void testQuestion(){
        String qst="Bonjour, vous devez être le détective qui travaille sur cette enquête.\\n\" + \" | \" + \"En quoi puis-je vous aider ?\"";
        Zone z=new Zone("l'Entree", "1-Entree.jpg" );
        jeu.setZoneCourante(z);
        jeu.question();
        assertEquals(qst,jeu.tabDialogue.get(8).getDialogueTexte());
    }
    @Test
    void testReponse(){
        int n=3;
        String test="4. Est-ce que cette boucle d'oreille est à  vous ?";
        assertEquals(test,jeu.tabDialogue.get(n).getDialogueTexte());
    }

    @Test
    void testdejaParleAuPersonnage(){
    int n=4;
    Zone z=new Zone("l'Entree", "1-Entree.jpg" );
    jeu.setZoneCourante(z);
     Dialogue d;
        for (int i = 0; i < jeu.tabDialogue.size(); i++) {
            if (jeu.tabDialogue.get(i).getNumeroDialogue() == n)
                jeu.tabDialogue.get(i).setDejaParle();
                d = jeu.tabDialogue.get(i);
                assertTrue(d.getDejaParle());
        }


    }

    @Test
    void testverifDejaparler(){
        int n=4;
        Zone z=new Zone("l'Entree", "1-Entree.jpg" );
        jeu.setZoneCourante(z);
        Dialogue d;
        for (int i = 0; i < jeu.tabDialogue.size(); i++) {
            if (jeu.tabDialogue.get(i).getNumeroDialogue() == n)
                jeu.tabDialogue.get(i).setDejaParle();
            d = jeu.tabDialogue.get(i);
            assertTrue(d.getDejaParle());
        }
    }

    @Test
    void testafficherLocalisation(){
        Zone z =new Zone("l'Entree", "1-Entree.jpg" );
        jeu.setZoneCourante(z);
        String zc=z.descriptionLongue();
        assertEquals(zc,z.descriptionLongue());
    }
    
    
   /* @Test
    void  afficherMessageDeBienvenue(){
        gui.afficher("Bienvenue");
        assertEquals("Bienvenue",gui.afficher("Bienvenue"));
    }*/
    @Test
    void testgetStringFromFile() throws URISyntaxException, FileNotFoundException{
        String textFromFile="";
        URL u = this.getClass().getClassLoader().getResource("jeu/text/sam.txt");
        URI uri;
        uri = u.toURI();
        File file = new File(uri);
        Scanner s= new Scanner(file);
        while(s.hasNext())
        {
            textFromFile=textFromFile+s.nextLine();
        }
        assertEquals("L3 INFO",textFromFile);
    }
    @Test
    void testCommandelue(){
        String s="RETOUR";
        Zone z=new Zone("le Couloir Ouest", "2-CouloirWest.jpg" );
        Zone c =new Zone("l'Entree", "1-Entree.jpg" );
        jeu.setZoneCourante(z);
        jeu.traiterCommande(s);
        assertEquals(c,jeu.getZoneCourante());

    }

    @Test
    void testallerEn(){
        Zone c =new Zone("l'Entree", "1-Entree.jpg" );
        Zone z = new Zone("le Couloir Nord", "4-CouloirNorth.jpg" );
        jeu.setZoneCourante(z);
        jeu.allerEn("SUD");
        assertEquals(c,jeu.getZoneCourante());
    }
}