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
	
	ArrayList<Objet> tabObjet = new ArrayList<Objet>();
	
	/*
	 * Initialisation des variables pour la Téléportation et l'Affichage du Plan de la maison
	 */
	boolean tpPossible = false;
	boolean visionCartePossible = false;
	private Zone zonePrecedente;

	/*
	 * 
	 */
	public void creerObjet() {
		this.tabObjet.add(new Objet("Bouton", "Ceci est un bouton de veste, à qui peut-il appartenir ?", zones[8]));
		this.tabObjet.add(new Objet("Clef de la cave", "Ceci est la clef permettant d'ouvrir la porte de la cave", zones[9]));
		this.tabObjet.add(new Objet("Boucle d'oreille", "Une boucle d'oreille, à qui peut-elle être ? Je devrais interroger la Mère ou la Femme de Chambre... ", zones[10]));
		this.tabObjet.add(new Objet("Lettre Compromettante", "Lettre dévoilant une relation adultère entre le Père et la Femme de Chambre", zones[17]));
		this.tabObjet.add(new Objet("Lettre d'Amour", "Lettre de déclaration d'amour du Cuisiner envers la Femme de Chambre", zones[18]));
		this.tabObjet.add(new Objet("Clef du coffre de la cave", "Ceci est la clef permettant d'ouvrir le coffre situé dans la cave. Que peut-il bien y avoir dedans ?", zones[15]));
		this.tabObjet.add(new Objet("Couteau", "Ce couteau est couvert de sang. Peut-être l'arme du crime ? Il faut l'Examiner !", zones[14]));
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
    public void setGUI( GUI g ) { gui = g; afficherMessageDeBienvenue(); }
    
    /*
     * 
     */
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
        zones[22] = new Zone("Plan du Premier Étage", "22-PlanMaison1erEtage.jpg");
        zones[23] = new Zone("Plan du Second Étage","23-PlanMaison2emeEtage.jpg");

        zones[0].ajouteSortie(Sortie.SUD, zones[1]); 	// Depuis le Tableau aller dans l'Entrée
        
        zones[1].ajouteSortie(Sortie.OUEST, zones[2]); 	// Depuis l'Entrée aller dans le couloir Ouest
        zones[1].ajouteSortie(Sortie.EST, zones[3]); 	// Depuis l'Entrée aller dans le couloir Est
        zones[1].ajouteSortie(Sortie.NORD, zones[4]); 	// Depuis l'Entrée aller dans le couloir Nord
        zones[1].ajouteSortie(Sortie.SUD, zones[5]); 	// Depuis l'Entrée aller dans le garage
        zones[1].ajouteSortie(Sortie.TABLEAU, zones[0]); 	// Depuis l'Entrée aller sur le Tableau
        
        zones[2].ajouteSortie(Sortie.EST, zones[1]);  	// Depuis le couloir Ouest aller dans l'Entrée
        zones[2].ajouteSortie(Sortie.OUEST, zones[6]);	// Depuis le couloir Ouest aller dans la Cuisine
        zones[2].ajouteSortie(Sortie.NORD, zones[7]);	// Depuis le couloir Ouest aller dans la Salle à Manger
        
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
        
        zones[20].ajouteSortie(Sortie.REZDECHAUSSEE, zones[21]);
        zones[20].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
        zones[20].ajouteSortie(Sortie.SECONDETAGE, zones[23]);
        
        zones[21].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[21].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
        zones[21].ajouteSortie(Sortie.SECONDETAGE, zones[23]);

        zones[22].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[22].ajouteSortie(Sortie.REZDECHAUSSEE, zones[21]);
        zones[22].ajouteSortie(Sortie.SECONDETAGE, zones[23]);

        zones[23].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[23].ajouteSortie(Sortie.REZDECHAUSSEE, zones[21]);
        zones[23].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
        
        zoneCourante = zones[1]; 
        
        creerObjet();
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
    
    /*
     * Permet de retenir dans quelle Zone le joueur se trouvait avant de regarder le plan du manoir
     */
    private void retenirZone() {
    	if (zoneCourante == zones[1]) {
    		zonePrecedente = zones[1];
    	} else if (zoneCourante == zones[2]) {
    		zonePrecedente = zones[2];
    	} else if (zoneCourante == zones[3]) {
    		zonePrecedente = zones[3];
    	} else if (zoneCourante == zones[4]) {
    		zonePrecedente = zones[4];
    	} else if (zoneCourante == zones[5]) {
    		zonePrecedente = zones[5];
    	} else if (zoneCourante == zones[6]) {
    		zonePrecedente = zones[6];
    	} else if (zoneCourante == zones[7]) {
    		zonePrecedente = zones[7];
    	} else if (zoneCourante == zones[8]) {
    		zonePrecedente = zones[8];
    	} else if (zoneCourante == zones[9]) {
    		zonePrecedente = zones[9];
    	} else if (zoneCourante == zones[10]) {
    		zonePrecedente = zones[10];
    	} else if (zoneCourante == zones[11]) {
    		zonePrecedente = zones[11];
    	} else if (zoneCourante == zones[12]) {
    		zonePrecedente = zones[12];
    	} else if (zoneCourante == zones[13]) {
    		zonePrecedente = zones[13];
    	} else if (zoneCourante == zones[14]) {
    		zonePrecedente = zones[14];
    	} else if (zoneCourante == zones[15]) {
    		zonePrecedente = zones[15];
    	} else if (zoneCourante == zones[16]) {
    		zonePrecedente = zones[16];
    	} else if (zoneCourante == zones[17]) {
    		zonePrecedente = zones[17];
    	} else if (zoneCourante == zones[18]) {
    		zonePrecedente = zones[18];
    	} else if (zoneCourante == zones[19]) {
    		zonePrecedente = zones[19];
    	}
    }
    
    /*
     * Permet de faire retourner le joueur à sa position initiale avant de consulter le plan du manoir
     */
    private void revenirZonePrecedente() {
    	if (zonePrecedente == zones[1]) {
    		zoneCourante = zones[1];
            montrerCarteJoueur(1);
    	} else if (zonePrecedente == zones[2]) {
    		zoneCourante = zones[2];
            montrerCarteJoueur(2);
    	} else if (zonePrecedente == zones[3]) {
    		zoneCourante = zones[3];
            montrerCarteJoueur(3);
    	} else if (zonePrecedente == zones[4]) {
    		zoneCourante = zones[4];
            montrerCarteJoueur(4);
    	} else if (zonePrecedente == zones[5]) {
    		zoneCourante = zones[5];
            montrerCarteJoueur(5);
    	} else if (zonePrecedente == zones[6]) {
    		zoneCourante = zones[6];
            montrerCarteJoueur(6);
    	} else if (zonePrecedente == zones[7]) {
    		zoneCourante = zones[7];
            montrerCarteJoueur(7);
    	} else if (zonePrecedente == zones[8]) {
    		zoneCourante = zones[8];
            montrerCarteJoueur(8);
    	} else if (zonePrecedente == zones[9]) {
    		zoneCourante = zones[9];
            montrerCarteJoueur(9);
    	} else if (zonePrecedente == zones[10]) {
    		zoneCourante = zones[10];
            montrerCarteJoueur(10);
    	} else if (zonePrecedente == zones[11]) {
    		zoneCourante = zones[11];
            montrerCarteJoueur(11);
    	} else if (zonePrecedente == zones[12]) {
    		zoneCourante = zones[12];
            montrerCarteJoueur(12);
    	} else if (zonePrecedente == zones[13]) {
    		zoneCourante = zones[13];
            montrerCarteJoueur(13);
    	} else if (zonePrecedente == zones[14]) {
    		zoneCourante = zones[14];
            montrerCarteJoueur(14);
    	} else if (zonePrecedente == zones[15]) {
    		zoneCourante = zones[15];
            montrerCarteJoueur(15);
    	} else if (zonePrecedente == zones[16]) {
    		zoneCourante = zones[16];
            montrerCarteJoueur(16);
    	} else if (zonePrecedente == zones[17]) {
    		zoneCourante = zones[17];
            montrerCarteJoueur(17);
    	} else if (zonePrecedente == zones[18]) {
    		zoneCourante = zones[18];
            montrerCarteJoueur(18);
    	} else if (zonePrecedente == zones[19]) {
    		zoneCourante = zones[19];
            montrerCarteJoueur(19);
    	}
    }
    
    /*
     * 
     */
    private void prendre() {
    	if (zoneCourante == zones[8] && tabObjet.get(0).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(0).getNom()); 
        	gui.afficher();
        	tabObjet.get(0).setObjetRecupere();
        	zones[8].setNomImage("8-Salon_vide.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[9] && tabObjet.get(1).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(1).getNom()); 
        	gui.afficher();
        	tabObjet.get(1).setObjetRecupere();
        	zones[9].setNomImage("9-Bureau_vide.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[10] && tabObjet.get(2).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(2).getNom()); 
        	gui.afficher();
        	tabObjet.get(2).setObjetRecupere();
        	zones[10].setNomImage("10-ChambreParentale_vide.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[17] && tabObjet.get(3).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(3).getNom()); 
        	gui.afficher();
        	tabObjet.get(3).setObjetRecupere();
        	zones[17].setNomImage("17-Grenier_vide.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[18] && tabObjet.get(4).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(4).getNom()); 
        	gui.afficher();
        	tabObjet.get(4).setObjetRecupere();
        	zones[18].setNomImage("18-ChambreDuMajordome_vide.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[15] && tabObjet.get(5).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(5).getNom()); 
        	gui.afficher();
        	tabObjet.get(5).setObjetRecupere();
        	zones[15].setNomImage("15-Jardin_vide.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[14] && tabObjet.get(6).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(6).getNom()); 
        	gui.afficher();
        	tabObjet.get(6).setObjetRecupere();
        	zones[14].setNomImage("14-Cave_vide.jpg");
        	modifierCarte();
    	} else {
        	gui.afficher("Il n'y a rien à récupérer ici");
        	gui.afficher();
    	}
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
    	if (!tpPossible && !visionCartePossible) {
    		switch (commandeLue.toUpperCase()) {
            case "?" : case "AIDE" : 
                afficherAide(); 
            	break;
            case "N" : case "NORD" :
            	allerEn( "NORD" ); 
            	break;
           case "S" : case "SUD" :
            	allerEn( "SUD" ); 
            	break;
            case "E" : case "EST" :
            	allerEn( "EST" ); 
            	break;
            case "O" : case "OUEST" :
            	allerEn( "OUEST" ); 
            	break;
            case "NO" : case "NORDOUEST" :
            	allerEn( "NORDOUEST" ); 
            	break;
            case "NE" : case "NORDEST" :
            	allerEn( "NORDEST" ); 
            	break;
            case "TAB" : case "TABLEAU" :
            	allerEn( "TABLEAU" ); 
            	break;
            case "PA" : case "PARLER" :
            	parler(zones[7],"lol");
            	break;
            case "PR" : case "PRENDRE" :
            	prendre();
            	break;
            case "C" : case "CARTE" : 
            	retenirZone(); // Permet de retenir dans quelle zone on était pour y retourner quand on sortira de l'affichage du plan de la maison
            	permettreCarte(); // Permet d'activer la vision du plan de la maison
            	gui.afficher("Tu peux maintenant voir la carte, pour changer de plan utilise les commandes [SOUSSOL, REZDECHAUSSEE, 1ERETAGE, 2EMEETAGE]");
            	gui.afficher(); 
            	// Pour permettre d'afficher le plan de l'étage où le joueur se trouve
            	if (zoneCourante == zones[14]) { 
                    montrerCarteJoueur(20);
            	} else if (zoneCourante == zones[1] || zoneCourante == zones[2] || zoneCourante == zones[3] || zoneCourante == zones[5] || zoneCourante == zones[6] || zoneCourante == zones[7] || zoneCourante == zones[8] || zoneCourante == zones[9] || zoneCourante == zones[15] || zoneCourante == zones[19]) {
                    montrerCarteJoueur(21);
            	} else if (zoneCourante == zones[4] || zoneCourante == zones[10] || zoneCourante == zones[11] || zoneCourante == zones[12] || zoneCourante == zones[16]) {
                    montrerCarteJoueur(22);
            	} else if (zoneCourante == zones[13] || zoneCourante == zones[17] || zoneCourante == zones[18]) {
                    montrerCarteJoueur(23);
            	}
            	gui.afficher();
            	break;
            case "TP" : case "TELEPORTATION" :
            	permettreTeleportation();
            	gui.afficher("Tu peux maintenant te téléporter dans tout le manoir sauf les zones auxquelles tu n'as pas accès.\nPour sortir de ce mode entre à nouveau la commande [TP]\nTu peux te servir du plan avec la commande [CARTE] pour savoir où aller, les pièces sont numérotées.\nIl faut donc taper le numéro de la salle désirée pour s'y rendre.");
            	gui.afficher();
            	break;
            case "Q" : case "QUITTER" :
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                gui.afficher();
                break;
            }
    	} else if (visionCartePossible && !tpPossible) {
    		switch (commandeLue.toUpperCase()) {
            case "SS": case "SOUSSOL" :
                montrerCarteJoueur(20);
                break;
            case "RDC" : case "REZDECHAUSSE" : case "REZDECHAUSSEE" :
            	montrerCarteJoueur(21);
            	break;
            case "1ER" : case "1ERETAGE" : case "PREMIERETAGE" :
            	montrerCarteJoueur(22);
            	break;
            case "2EME" : case "2EMEETAGE" : case "SECONDETAGE" :
            	montrerCarteJoueur(23);
            	break;
            case "C" : case "CARTE" :
            	revenirZonePrecedente();
            	desactiverCarte();
            	gui.afficher();
            	break;
            case "Q" : case "QUITTER" :
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                gui.afficher();
                break;
    		}
    	} else if (tpPossible && !visionCartePossible) {
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
            case "Q" : case "QUITTER" :
            	terminer();
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
    
    /*
     * 
     */
    private void modifierCarte() {
    	gui.afficher(zoneCourante.descriptionLongue());
    	gui.afficher();
    	gui.afficheImage(zoneCourante.nomImage());
    }
    
    /*
     * 
     */
    public void parler(Zone z, String dialogue)
    {
        if(z==zoneCourante)
        {
            gui.afficher(dialogue);
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