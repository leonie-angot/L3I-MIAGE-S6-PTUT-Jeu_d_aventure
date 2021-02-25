package jeu;

import java.util.ArrayList;

/**
 * Nom de classe : Jeu.
 * 
 * Description : La classe jeu est utilisée pour interagir avec 
 * les personnages et les éléments de notre jeu.
 * 
 * Version : 1.0.
 * 
 * Date : 06/02/2021.
 * 
 * @author 
 */
public class Jeu {
	
	
	ArrayList<Indices> tabIndice = new ArrayList<Indices>();
	
	boolean tpPossible = false;
	boolean visionCartePossible = false;

	public void creerIndices() {
		Indices[] tab = new Indices[10];
		
		//Initialisez les indices
	}
	/**
	 * Interface utilisateur graphique.
	 */
    private GUI gui; 
    /**
	 * Represente la localisation du joueur.
	 */
	private Zone zoneCourante;
	/**
	 * Cree la carte du jeu avec ses differentes zones.
	 * initialise l'interface utilisateur graphique avec null.
	 */
    public Jeu() {
        creerCarte();
        gui = null;
    }

    /**
     * Initialise le GUI du jeu. 
     * @param g interface utilisateur graphique.
     */
    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }
    
    Zone [] zones = new Zone [24];
    
    /**
     * Cree et initialise les zones.
     * Associe à chaque zone ses sorties.
	 * initialise la zone courante avec la zone de depart
	 * 
	 * @author Léonie A.
     */
    private void creerCarte() {
        zones[0] = new Zone("Tableau", "0-Tableau.jpg" );
        zones[1] = new Zone("Entree", "1-Entree.jpg" );
        zones[2] = new Zone("Couloir Ouest", "2-CouloirWest.jpg" );
        zones[3] = new Zone("Couloir Est", "3-CouloirEast.jpg" );
        zones[4] = new Zone("Couloir Nord", "4-CouloirNorth.jpg" );
        zones[5] = new Zone("Garage", "5-Garage.jpg" );
        zones[6] = new Zone("Salle a manger", "6-SalleAManger.jpg" );
        zones[7] = new Zone("Cuisine", "7-Cuisine.jpg" );
        zones[8] = new Zone("Salon", "8-Salon.jpg" );
        zones[9] = new Zone("Bureau", "9-Bureau.jpg" );
        zones[10] = new Zone("Chambre Parentale", "10-ChambreParentale.jpg" );
        zones[11] = new Zone("Chambre de la Fille", "11-ChambreDeLaFille.jpg" );
        zones[12] = new Zone("Chambre du Fils", "12-ChambreDuFils.jpg" );
        zones[13] = new Zone("Escalier avec couloir", "13-EscalierAvecCouloir.jpg" );
        zones[14] = new Zone("Cave", "14-Cave.jpg" );
        zones[15] = new Zone("Jardin", "15-Jardin.jpg" );
        zones[16] = new Zone("Salle de Bain", "16-SalleDeBain.jpg" );
        zones[17] = new Zone("Grenier", "17-Grenier.jpg" );
        zones[18] = new Zone("Chambre du Majordome", "18-ChambreDuMajordome.jpg" );
        zones[19] = new Zone("Maison du Gardien", "19-MaisonDuGardien.jpg" );
        zones[20] = new Zone("Plan du Sous Sol", "20-PlanMaisonSousSol.jpg");
        zones[21] = new Zone("Plan du Rez de Chaussée", "21-PlanMaisonRezDeChaussee.jpg");
        zones[22] = new Zone("Plan du Sous Sol", "22-PlanMaison1erEtage.jpg");
        zones[23] = new Zone("Plan du Second etage","23-PlanMaison2emeEtage.jpg");

        zones[0].ajouteSortie(Sortie.SUD, zones[1]); 	// Depuis le Tableau aller dans l'Entrée
        
        zones[1].ajouteSortie(Sortie.OUEST, zones[2]); 	// Depuis l'Entrée aller dans le couloir Ouest
        zones[1].ajouteSortie(Sortie.EST, zones[3]); 	// Depuis l'Entrée aller dans le couloir Est
        zones[1].ajouteSortie(Sortie.NORD, zones[4]); 	// Depuis l'Entrée aller dans le couloir Nord
        zones[1].ajouteSortie(Sortie.SUD, zones[5]); 	// Depuis l'Entrée aller dans le garage
        zones[1].ajouteSortie(Sortie.TABLEAU, zones[0]); 	// Depuis l'Entrée aller sur le Tableau
        
        zones[2].ajouteSortie(Sortie.EST, zones[1]);  	// Depuis le couloir Ouest aller dans l'Entrée
        zones[2].ajouteSortie(Sortie.OUEST, zones[7]);	// Depuis le couloir Ouest aller dans la Cuisine
        zones[2].ajouteSortie(Sortie.NORD, zones[6]);	// Depuis le couloir Ouest aller dans la Salle à Manger
        
        zones[3].ajouteSortie(Sortie.OUEST, zones[1]); 	// Depuis le couloir Est aller dans l'Entrée
        zones[3].ajouteSortie(Sortie.EST, zones[9]);	// Depuis le couloir Est aller dans le Bureau
        zones[3].ajouteSortie(Sortie.NORD, zones[8]);	// Depuis le couloir Est aller dans le Salon
        
        zones[4].ajouteSortie(Sortie.SUD, zones[1]);	// Depuis le couloir Nord aller dans l'Entrée
        zones[4].ajouteSortie(Sortie.OUEST, zones[10]);	// Depuis le couloir Nord aller dans la Chambre Parentale
        zones[4].ajouteSortie(Sortie.NORDOUEST, zones[11]);	// Depuis le couloir Nord aller dans la Chambre de la Fille
        zones[4].ajouteSortie(Sortie.NORDEST, zones[12]);	// Depuis le couloir Nord aller dans la Chambre du Fils
        zones[4].ajouteSortie(Sortie.EST, zones[13]);	// Depuis le couloir Nord aller dans l'Escalier avec le couloir
        
        zones[5].ajouteSortie(Sortie.SUD, zones[1]);	// Depuis le garage pour aller dans l'Entree
        zones[5].ajouteSortie(Sortie.EST, zones[14]);	// Depuis le garage pour aller dans la Cave
        
        zones[6].ajouteSortie(Sortie.SUD, zones[2]);	// Depuis la Salle à Manger pour aller dans le couloir Ouest
        
        zones[7].ajouteSortie(Sortie.SUD, zones[2]);	// Depuis la Cuisine pour aller dans le couloir Ouest
        zones[7].ajouteSortie(Sortie.EST, zones[15]);	// Depuis la Cuisine pour aller dans le Jardin
        
        zones[8].ajouteSortie(Sortie.SUD, zones[3]);	// Depuis le Salon pour aller dans le couloir Est
        zones[8].ajouteSortie(Sortie.NORD, zones[15]);	// Depuis le Salon pour aller dans le Jardin
        
        zones[9].ajouteSortie(Sortie.SUD, zones[3]);	// Depuis le Bureau pour aller dans le couloir Est
        
        zones[10].ajouteSortie(Sortie.SUD, zones[4]);	// Depuis la Chambre Parentale pour aller dans le couloir Nord
        zones[10].ajouteSortie(Sortie.NORD, zones[16]);	// Depuis la Chambre Parentale pour aller dans la Salle de Bain
        
        zones[11].ajouteSortie(Sortie.SUD, zones[4]);	// Depuis la Chambre de la Fille pour aller dans le couloir Nord
        
        zones[12].ajouteSortie(Sortie.SUD, zones[4]);	// Depuis la Chambre du Fils pour aller dans le couloir Nord
        
        zones[13].ajouteSortie(Sortie.OUEST, zones[4]);	// Depuis le couloir avec l'escalier pour aller dans le couloir Nord
        zones[13].ajouteSortie(Sortie.EST, zones[17]);	// Depuis le couloir avec l'escalier pour aller dans le Grenier
        zones[13].ajouteSortie(Sortie.NORD, zones[18]);	// Depuis le couloir avec l'escalier pour aller dans la Chambre des Domestiques
        
        zones[14].ajouteSortie(Sortie.OUEST, zones[5]);	// Depuis la Cave pour aller dans le Garage
        
        zones[15].ajouteSortie(Sortie.SUD, zones[7]);	// Depuis le Jardin pour aller dans la Cuisine
        zones[15].ajouteSortie(Sortie.OUEST, zones[8]);	// Depuis le Jardin pour aller dans le Salon
        zones[15].ajouteSortie(Sortie.NORD, zones[19]);	// Depuis le Jardin pour aller dans la Maison du Gardien
        
        zones[16].ajouteSortie(Sortie.SUD, zones[10]);	// Depuis la Salle de Bain pour aller dans la Chambre Parentale
        
        zones[17].ajouteSortie(Sortie.SUD, zones[13]);	// Depuis le Grenier pour aller dans le couloir avec l'escalier
        
        zones[18].ajouteSortie(Sortie.SUD, zones[13]);	// Depuis la Chambre du Majordome pour aller dans le couloir avec l'escalier
        
        zones[19].ajouteSortie(Sortie.SUD, zones[15]);	// Depuis la Maison du Gardien pour aller le Jardin
        
        zones[20].ajouteSortie(Sortie.SOUSSOL, zones[21]);
        zones[20].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
        zones[20].ajouteSortie(Sortie.SECONDETAGE, zones[23]);
        
        zones[21].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[21].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
        zones[21].ajouteSortie(Sortie.SECONDETAGE, zones[23]);

        zones[22].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[22].ajouteSortie(Sortie.REZDECHAUSSE, zones[21]);
        zones[22].ajouteSortie(Sortie.SECONDETAGE, zones[23]);

        zones[23].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[23].ajouteSortie(Sortie.REZDECHAUSSE, zones[21]);
        zones[23].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
        
        zoneCourante = zones[1]; 
    }

    /*
     * Donne la permission au joueur de se téléporter dans la map de son choix
     */
    private void permettreTeleportation() {
    	tpPossible = true;
    }
    
    /*
     * Enlève la permission au joueur de se téléporter dans la map de son choix
     */
    private void desactiverTeleportation() {
    	tpPossible = false;
    }
    
    /*
     * Permet de téléporter le joueur de se téléporter dans la map de son choix
     */
    private void teleporterJoueur(int idZone) {
    	zoneCourante = zones[idZone];
    	gui.afficher(zoneCourante.descriptionLongue());
    	gui.afficher();
    	gui.afficheImage(zoneCourante.nomImage());
    }
    
    /*
     * Donne la permission au joueur de voir la carte
     */
    private void permettreCarte() {
    	visionCartePossible = true;
    }
    
    /*
     * Enlève la permission au joueur de voir la carte
     */
    private void desactiverCarte() {
    	visionCartePossible = false;
    }
    
    /*
     * Permet de montrer le plan au Joueur
     */
    private void montrerCarteJoueur(int idCarte) {
    	zoneCourante = zones[idCarte];
    	gui.afficher(zoneCourante.descriptionLongue());
    	gui.afficher();
    	gui.afficheImage(zoneCourante.nomImage());
    }
    
    /**
     * Affiche la localisation du joueur
     */
    private void afficherLocalisation() {
    	gui.afficher( zoneCourante.descriptionLongue());
        gui.afficher();
    }

    /**
     * Affiche un message de bienvenue
     */
    private void afficherMessageDeBienvenue() {
    	gui.afficher("Bienvenue !");
    	gui.afficher();
        gui.afficher("Tapez '?' pour obtenir de l'aide.");
        gui.afficher();
        afficherLocalisation();
        gui.afficheImage(zoneCourante.nomImage());
    }
    
    /**
     * Traite la commande lue en parametre
     * @param commandeLue la commande saisie par l'utilisateur.
     */
    public void traiterCommande(String commandeLue) {
    	gui.afficher( "> "+ commandeLue + "\n");
    	if (!tpPossible) {
    		switch (commandeLue.toUpperCase()) {
            case "?" : case "AIDE" : 
                afficherAide(); 
            	break;
            case "N" : case "NORD" :
            	allerEn( "NORD"); 
            	break;
           case "S" : case "SUD" :
            	allerEn( "SUD"); 
            	break;
            case "E" : case "EST" :
            	allerEn( "EST"); 
            	break;
            case "O" : case "OUEST" :
            	allerEn( "OUEST"); 
            	break;
            case "NO" : case "NORDOUEST" :
            	allerEn( "NORDOUEST"); 
            	break;
            case "NE" : case "NORDEST" :
            	allerEn( "NORDEST"); 
            	break;
            case "TAB" : case "TABLEAU" :
            	allerEn( "TABLEAU"); 
            	break;
            case "C" : case "CARTE" : 
            	permettreCarte();
            	gui.afficher("Tu peux maintenant voir la carte, pour changer de plan utilise les commandes [SOUSSOL, REZDECHAUSSE, 1ERETAGE, 2EMEETAGE]");
            	gui.afficher();
            case "TP" : case "TELEPORTATION" :
            	permettreTeleportation();
            	//gui.afficher("Tu peux maintenant te téléporter dans tout le manoir, pour sortir de ce mode entre à nouveau la commande [TP]\nTu peux te servir du plan avec la commande [CARTE] pour savoir où aller");
            	gui.afficher();
            	break;
            case "Q" : case "QUITTER" :
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                break;
            }
    	} else if (visionCartePossible) {
    		switch (commandeLue.toUpperCase()) {
            case "SS": case "SOUSSOL" :
                montrerCarteJoueur(20);
                break;
            case "RDC" : case "REZDECHAUSSE" :
            	montrerCarteJoueur(21);
            	break;
            case "1ER" : case "1ERETAGE" :
            	montrerCarteJoueur(22);
            	break;
            case "2EME" : case "2EMEETAGE" :
            	montrerCarteJoueur(23);
            	break;
            case "C" : case "CARTE" :
            	desactiverCarte();
            	gui.afficher();
            default : 
                gui.afficher("Commande inconnue");
                break;
    		}
    	} else if (tpPossible) {
    		switch (commandeLue.toUpperCase()) {
            case "1":
                teleporterJoueur(1);
                break;
            case "2" : 
                teleporterJoueur(2);
            	break;
            case "3" :
            	teleporterJoueur(3);
            	break;
            case "4" :
            	teleporterJoueur(4);
            	break;
            case "5" : 
            	teleporterJoueur(5);
            	break;
            case "6" : 
            	teleporterJoueur(6);
            	break;
            case "7":
                teleporterJoueur(7);
                break;
            case "8":
                teleporterJoueur(8);
                break;
            case "9":
                teleporterJoueur(9);
                break;
            case "10":
                teleporterJoueur(10);
                break;
            case "11":
                teleporterJoueur(11);
                break;
            case "12":
                teleporterJoueur(12);
                break;
            case "13":
                teleporterJoueur(13);
                break;
            case "14":
                teleporterJoueur(14);
                break;
            case "15":
                teleporterJoueur(15);
                break;
            case "16":
                teleporterJoueur(16);
                break;
            case "17":
                teleporterJoueur(17);
                break;
            case "18":
                teleporterJoueur(18);
                break;
            case "19":
                teleporterJoueur(19);
                break;
            case "TP" : 
            	desactiverTeleportation();
            	gui.afficher("On arrête enfin de tricher ?");
            	gui.afficher();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                break;
            }
    	}
    }

    /**
     * Affiche la description de chaque commande autorisée
     */
    private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autorisées sont :");
        gui.afficher();
        gui.afficher(Commande.toutesLesDescriptions().toString());
        gui.afficher();
    }

    /**
     * Changement de la localisation du joueur si la sortie demandée existe
     * @param direction La sortie demandée par le joueur
     */
    private void allerEn(String direction) {
    	Zone nouvelle = zoneCourante.obtientSortie(direction);
    	if ( nouvelle == null ) {
        	gui.afficher( "Pas de sortie " + direction);
    		gui.afficher();
    	}
        else {
        	zoneCourante = nouvelle;
        	gui.afficher(zoneCourante.descriptionLongue());
        	gui.afficher();
        	gui.afficheImage(zoneCourante.nomImage());
        }
    }
    

    /**
     * Quitte le jeu
     */
    private void terminer() {
    	gui.afficher( "Au revoir...");
    	gui.enable( false);
    }
}