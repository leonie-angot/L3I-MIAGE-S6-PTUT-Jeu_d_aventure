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
 * @author Léonie A. et Ylli P. 
 */
public class Jeu {
	
	// ArrayList répertoriant les Objets présents sur la map
	ArrayList<Objet> tabObjet = new ArrayList<Objet>();
	
	
	ArrayList<Objet> inventaire = new ArrayList<Objet>();
	
	/*
	 * Initialisation des variables pour la Téléportation et l'Affichage du Plan de la maison
	 */
	boolean tpPossible = false;
	boolean visionCartePossible = false;
	boolean visionInventairePossible = false;
	boolean discussionEnCours = false;
	
    boolean clefPorteUtilisee = false;
    boolean clefCoffreUtilisee = false;
    
    boolean clefPorteUtilisation = false;
    boolean clefCoffreUtilisation = false;
	
	private Zone zonePrecedente;

	/*
	 * Initialisation des objets sur la map
	 */
	public void creerObjet() {
		this.tabObjet.add(new Objet("Bouton", "Ceci est un bouton de veste, il semblerait qu'il provient d'un uniforme de travail. Je devrais demander aux employés.", zones[8]));
		this.tabObjet.add(new Objet("Clef de la cave", "Ceci est la clef permettant d'ouvrir la porte de la cave.", zones[9]));
		this.tabObjet.add(new Objet("Boucle d'oreille", "Une boucle d'oreille, à qui peut-elle appartenir ? Je devrais interroger la Mère ou la Femme de Chambre... ", zones[10]));
		this.tabObjet.add(new Objet("Lettre Compromettante", "Lettre dévoilant une relation adultère entre le Père et la Femme de Chambre. Je me demande si la Mère était au courant...", zones[17]));
		this.tabObjet.add(new Objet("Lettre d'Amour", "Lettre de déclaration d'amour du Cuisiner envers la Femme de Chambre. Il semblerait qu'il avait des sentiments pour elle...", zones[18]));
		this.tabObjet.add(new Objet("Clef du coffre de la cave", "Ceci est la clef permettant d'ouvrir le coffre situé dans la cave. Que peut-il bien y avoir dedans ?", zones[15]));
		this.tabObjet.add(new Objet("Couteau", "Les seules empreintes trouvées sur le couteau sont celles du Cuisiner.", zones[14]));
		this.tabObjet.add(new Objet("Lettre de Licenciement", "Lettre de licenciement du Cuisinier rédigée par le Père", zones[1]));
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
    Zone [] zones = new Zone [26];
    
    /**
     * Cree et initialise les zones.
     * Associe à chaque zone ses sorties.
	 * initialise la zone courante avec la zone de depart
	 * 
	 * @author Léonie A.
     */
    private void creerCarte() {
        zones[0] = new Zone("Tableau", "0-Tableau.jpg" );
        zones[1] = new Zone("l'Entree", "1-Entree.jpg" );
        zones[2] = new Zone("le Couloir Ouest", "2-CouloirWest.jpg" );
        zones[3] = new Zone("le Couloir Est", "3-CouloirEast.jpg" );
        zones[4] = new Zone("le Couloir Nord", "4-CouloirNorth.jpg" );
        zones[5] = new Zone("le Garage", "5-Garage.jpg" );
        zones[6] = new Zone("la Salle a manger", "6-SalleAManger.jpg" );
        zones[7] = new Zone("la Cuisine", "7-Cuisine.jpg" );
        zones[8] = new Zone("le Salon", "8-Salon.jpg" );
        zones[9] = new Zone("le Bureau", "9-Bureau.jpg" );
        zones[10] = new Zone("la Chambre Parentale", "10-ChambreParentale.jpg" );
        zones[11] = new Zone("la Chambre de la Fille", "11-ChambreDeLaFille.jpg" );
        zones[12] = new Zone("la Chambre du Fils", "12-ChambreDuFils.jpg" );
        zones[13] = new Zone("l'Escalier avec couloir", "13-EscalierAvecCouloir.jpg" );
        zones[14] = new Zone("la Cave", "14-Cave.jpg" );
        zones[15] = new Zone("le Jardin", "15-Jardin.jpg" );
        zones[16] = new Zone("la Salle de Bain", "16-SalleDeBain.jpg" );
        zones[17] = new Zone("le Grenier", "17-Grenier.jpg" );
        zones[18] = new Zone("la Chambre du Majordome", "18-ChambreDuMajordome.jpg" );
        zones[19] = new Zone("la Maison du Gardien", "19-MaisonDuGardien.jpg" );
        zones[20] = new Zone("le Plan du Sous Sol", "20-PlanMaisonSousSol.jpg");
        zones[21] = new Zone("le Plan du Rez de Chaussée", "21-PlanMaisonRezDeChaussee.jpg");
        zones[22] = new Zone("le Plan du Premier Étage", "22-PlanMaison1erEtage.jpg");
        zones[23] = new Zone("le Plan du Second Étage","23-PlanMaison2emeEtage.jpg");
        zones[24] = new Zone("l'Inventaire","24-Inventaire.jpg");
        zones[25] = new Zone("la Poubelle","25-Poubelle.jpg");

        zones[0].ajouteSortie(Sortie.SUD, zones[1]); 		// Depuis le Tableau aller dans l'Entrée
        
        zones[1].ajouteSortie(Sortie.OUEST, zones[2]); 		// Depuis l'Entrée aller dans le couloir Ouest
        zones[1].ajouteSortie(Sortie.EST, zones[3]); 		// Depuis l'Entrée aller dans le couloir Est
        zones[1].ajouteSortie(Sortie.NORD, zones[4]); 		// Depuis l'Entrée aller dans le couloir Nord
        zones[1].ajouteSortie(Sortie.SUD, zones[5]); 		// Depuis l'Entrée aller dans le garage
        zones[1].ajouteSortie(Sortie.TABLEAU, zones[0]); 	// Depuis l'Entrée aller sur le Tableau

        zones[2].ajouteSortie(Sortie.EST, zones[1]);  		// Depuis le couloir Ouest aller dans l'Entrée
        zones[2].ajouteSortie(Sortie.OUEST, zones[6]);		// Depuis le couloir Ouest aller dans la Cuisine
        zones[2].ajouteSortie(Sortie.NORD, zones[7]);		// Depuis le couloir Ouest aller dans la Salle à Manger
        
        zones[3].ajouteSortie(Sortie.OUEST, zones[1]); 		// Depuis le couloir Est aller dans l'Entrée
        zones[3].ajouteSortie(Sortie.EST, zones[9]);		// Depuis le couloir Est aller dans le Bureau
        zones[3].ajouteSortie(Sortie.NORD, zones[8]);		// Depuis le couloir Est aller dans le Salon
        
        zones[4].ajouteSortie(Sortie.SUD, zones[1]);		// Depuis le couloir Nord aller dans l'Entrée
        zones[4].ajouteSortie(Sortie.OUEST, zones[10]);		// Depuis le couloir Nord aller dans la Chambre Parentale
        zones[4].ajouteSortie(Sortie.NORDOUEST, zones[11]);	// Depuis le couloir Nord aller dans la Chambre de la Fille
        zones[4].ajouteSortie(Sortie.NORDEST, zones[12]);	// Depuis le couloir Nord aller dans la Chambre du Fils
        zones[4].ajouteSortie(Sortie.EST, zones[13]);		// Depuis le couloir Nord aller dans l'Escalier avec le couloir
        
        zones[5].ajouteSortie(Sortie.SUD, zones[1]);		// Depuis le garage pour aller dans l'Entree
        zones[5].ajouteSortie(Sortie.EST, zones[14]);		// Depuis le garage pour aller dans la Cave
        
        zones[6].ajouteSortie(Sortie.SUD, zones[2]);		// Depuis la Salle à Manger pour aller dans le couloir Ouest

        zones[7].ajouteSortie(Sortie.SUD, zones[2]);		// Depuis la Cuisine pour aller dans le couloir Ouest
        zones[7].ajouteSortie(Sortie.EST, zones[15]);		// Depuis la Cuisine pour aller dans le Jardin
        zones[7].ajouteSortie(Sortie.POUBELLE, zones[25]);	// Depuis la Cuisine pour aller dans le Jardin

        zones[8].ajouteSortie(Sortie.SUD, zones[3]);		// Depuis le Salon pour aller dans le couloir Est
        zones[8].ajouteSortie(Sortie.NORD, zones[15]);		// Depuis le Salon pour aller dans le Jardin
        
        zones[9].ajouteSortie(Sortie.SUD, zones[3]);		// Depuis le Bureau pour aller dans le couloir Est

        zones[10].ajouteSortie(Sortie.SUD, zones[4]);		// Depuis la Chambre Parentale pour aller dans le couloir Nord
        zones[10].ajouteSortie(Sortie.NORD, zones[16]);		// Depuis la Chambre Parentale pour aller dans la Salle de Bain
        
        zones[11].ajouteSortie(Sortie.SUD, zones[4]);		// Depuis la Chambre de la Fille pour aller dans le couloir Nord

        zones[12].ajouteSortie(Sortie.SUD, zones[4]);		// Depuis la Chambre du Fils pour aller dans le couloir Nord

        zones[13].ajouteSortie(Sortie.OUEST, zones[4]);		// Depuis le couloir avec l'escalier pour aller dans le couloir Nord
        zones[13].ajouteSortie(Sortie.EST, zones[17]);		// Depuis le couloir avec l'escalier pour aller dans le Grenier
        zones[13].ajouteSortie(Sortie.NORD, zones[18]);		// Depuis le couloir avec l'escalier pour aller dans la Chambre des Domestiques
        
        zones[14].ajouteSortie(Sortie.OUEST, zones[5]);		// Depuis la Cave pour aller dans le Garage
        
        zones[15].ajouteSortie(Sortie.SUD, zones[7]);		// Depuis le Jardin pour aller dans la Cuisine
        zones[15].ajouteSortie(Sortie.OUEST, zones[8]);		// Depuis le Jardin pour aller dans le Salon
        zones[15].ajouteSortie(Sortie.NORD, zones[19]);		// Depuis le Jardin pour aller dans la Maison du Gardien

        zones[16].ajouteSortie(Sortie.SUD, zones[10]);		// Depuis la Salle de Bain pour aller dans la Chambre Parentale
        
        zones[17].ajouteSortie(Sortie.SUD, zones[13]);		// Depuis le Grenier pour aller dans le couloir avec l'escalier
        
        zones[18].ajouteSortie(Sortie.SUD, zones[13]);		// Depuis la Chambre du Majordome pour aller dans le couloir avec l'escalier
        
        zones[19].ajouteSortie(Sortie.SUD, zones[15]);		// Depuis la Maison du Gardien pour aller le Jardin
        
       
        
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
     * Donne ou enlève la permission au joueur de se téléporter dans la map de son choix
     */
    private void permissionTeleportation() {
    	if (tpPossible) {
        	tpPossible = false;
    	} else {
        	tpPossible = true;
    	}
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
     * Donne ou enlève la permission au joueur de voir la carte
     */
    private void permissionCarte() {
    	if (visionCartePossible) {
        	visionCartePossible = false;
    	} else {
        	visionCartePossible = true;
    	}
    }
    
    /*
     * Donne ou enlève la permission au joueur de voir son inventaire
     */
    private void permissionInventaire() {
    	if (visionInventairePossible) {
    		visionInventairePossible = false;
    	} else {
    		visionInventairePossible = true;
    	}
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
    	for (int i = 1; i <= 24; i++) {
    		if (zoneCourante == zones[i]) {
    			zonePrecedente = zones[i];
    		}
    	}
    }
    
    /*
     * Permet de faire retourner le joueur à sa position initiale avant de consulter le plan du manoir
     */
    private void revenirZonePrecedente() {
    	for (int i = 1; i <= 24; i++) {
    		if (zonePrecedente == zones[i]) {
    			zoneCourante = zones[i];
    			montrerCarteJoueur(i);
    		}
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
        	this.inventaire.add(tabObjet.get(0));
    	} else if (zoneCourante == zones[9] && tabObjet.get(1).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(1).getNom()); 
        	gui.afficher();
        	tabObjet.get(1).setObjetRecupere();
        	zones[9].setNomImage("9-Bureau_vide.jpg");
        	modifierCarte();
        	this.inventaire.add(tabObjet.get(1));
    	} else if (zoneCourante == zones[10] && tabObjet.get(2).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(2).getNom()); 
        	gui.afficher();
        	tabObjet.get(2).setObjetRecupere();
        	zones[10].setNomImage("10-ChambreParentale_vide.jpg");
        	modifierCarte();
        	this.inventaire.add(tabObjet.get(2));
    	} else if (zoneCourante == zones[17] && tabObjet.get(3).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(3).getNom()); 
        	gui.afficher();
        	tabObjet.get(3).setObjetRecupere();
        	zones[17].setNomImage("17-Grenier_vide.jpg");
        	modifierCarte();
        	this.inventaire.add(tabObjet.get(3));
    	} else if (zoneCourante == zones[18] && tabObjet.get(4).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(4).getNom()); 
        	gui.afficher();
        	tabObjet.get(4).setObjetRecupere();
        	zones[18].setNomImage("18-ChambreDuMajordome_vide.jpg");
        	modifierCarte();
        	this.inventaire.add(tabObjet.get(4));
    	} else if (zoneCourante == zones[15] && tabObjet.get(5).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(5).getNom()); 
        	gui.afficher();
        	tabObjet.get(5).setObjetRecupere();
        	zones[15].setNomImage("15-Jardin_vide.jpg");
        	modifierCarte();
        	this.inventaire.add(tabObjet.get(5));
    	} else if (zoneCourante == zones[14] && tabObjet.get(6).getObjetRecupere() == false) {
        	gui.afficher("Tu viens de récupérer : " + tabObjet.get(6).getNom()); 
        	gui.afficher();
        	gui.afficher("Ce couteau est couvert de sang. Peut-être l'arme du crime ? Il faut l'examiner, c'est élémentaire mon cher Watson !"); 
        	gui.afficher();
        	tabObjet.get(6).setObjetRecupere();
        	zones[14].setNomImage("14-Cave_vide.jpg");
        	modifierCarte();
        	this.inventaire.add(tabObjet.get(6));
    	} else {
        	gui.afficher("Il n'y a rien à récupérer ici");
        	gui.afficher();
    	}
    }
    
    /*
     * 
     */
    private void afficherInventaire() {
		montrerCarteJoueur(24);
    	if (!this.inventaire.isEmpty()) {
        	gui.afficher("Voici le contenu de votre inventaire :");
        	gui.afficher();
        	gui.afficher(inventaire.toString());
        	gui.afficher();
    	} else {
        	gui.afficher("Votre inventaire est vide !");
        	gui.afficher();
    	}
    }
    
    /*
     * 
     */
    private void verificationObjetRecupere(int j) {
		boolean objetPresentInventaire = false; 
		for (int i = 0; i < inventaire.size() && objetPresentInventaire == false; i++) {
			if (inventaire.get(i).getNom() == tabObjet.get(j).getNom() ) {
				objetPresentInventaire = true;
	            gui.afficher(tabObjet.get(j).getDescription());
	            gui.afficher();
			}
		}
		if (!objetPresentInventaire) {
            gui.afficher("Tu n'as pas encore récupéré cet objet.");
            gui.afficher();
		}
    }
   
    /*
     * 
     */
    private void utiliserClef(int j) {
    	boolean clefPresenteInventaire = false; 
		for (int i = 0; i < inventaire.size() && clefPresenteInventaire == false; i++) {
			if (inventaire.get(i).getNom() == tabObjet.get(1).getNom() && clefPorteUtilisee == false && clefCoffreUtilisee == false && clefPorteUtilisation == true) {
	        	zones[5].setNomImage("5-Garage_ouvert.jpg");
	        	modifierCarte();
				clefPresenteInventaire = true;
				clefPorteUtilisee = true;
				gui.afficher("La porte est dévérouillée !");
				gui.afficher();
			} else if (inventaire.get(i).getNom() == tabObjet.get(5).getNom() && clefCoffreUtilisee == false && clefPorteUtilisee == true) {
	        	zones[14].setNomImage("14-Cave_couteau.jpg");
	        	modifierCarte();
				clefPresenteInventaire = true;
				clefCoffreUtilisee = true;
				gui.afficher("La coffre est dévérouillée !");
				gui.afficher();
			} else if (clefPorteUtilisee == true && zoneCourante == zones[5]) {
				gui.afficher("La porte est déjà dévérouillée ! A quoi bon faire deux fois la même chose ? C'est pas très fut fut quand même...");
				gui.afficher();
			} 			
    	} 
		if (zoneCourante == zones[5] && clefPresenteInventaire == false) {
			gui.afficher("La porte est vérouillée, il faut trouver la clef...");
			gui.afficher();
		} else if (zoneCourante == zones[14] && clefPresenteInventaire == false) {
			gui.afficher("Le coffre est vérouillé, il faut trouver la clef. On dirait que quelqu'un essaye de cacher de cacher quelque chose ici...");
			gui.afficher();
		}
    }
    
    /*
     * 
     */
    private void gameOver() {
    	if (zoneCourante == zones[25]) {
    		gui.afficher("Mais quelle idée d'aller dans la poubelle aussi ?!");
    		gui.afficher();
    		terminer();
    	}
    }
    
    /*
     * 
     */
    private void parler() {
    	if (zoneCourante == zones[1]) {
        	zones[1].setNomImage("1-Entree_Majordome.jpg");
        	modifierCarte();
			gui.afficher(" | " + "Bonjour, vous devez être le détective qui travaille sur cette enquête.\n" + " | " + "En quoi puis-je vous aider ?");
			gui.afficher();
			gui.afficher(" | " +  "1. Dites m'en plus sur vous.\n");
			gui.afficher(" | " +  "2. Que saviez-vous sur le père ?\n");
			gui.afficher(" | " +  "3. Dites m'en plus sur vous.\n");
			gui.afficher();
    	} else if (zoneCourante == zones[6]) {
        	zones[6].setNomImage("6-SalleAManger_FemmeDeMenage.jpg");
        	modifierCarte();
        	gui.afficher(" | " + "Bonjour, vous avez attrapé le meurtrier ? Mais quel malheur !\n" + " | " + "Comment est-ce que cela a pu se produire ?!");
			gui.afficher();
			gui.afficher(" | " +  "1. Dites m'en plus sur vous.\n");
			gui.afficher(" | " +  "2. Que savez vous sur cette maison ?\n");
			gui.afficher();
    	} else if (zoneCourante == zones[7]) {
        	zones[7].setNomImage("7-Cuisine_Cuisinier.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[9]) {
        	zones[9].setNomImage("9-Bureau_Mere.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[11]) {
        	zones[11].setNomImage("11-Chambre_Fille.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[12]) {
        	zones[12].setNomImage("12-Chambre_Fils.jpg");
        	modifierCarte();
    	} else if (zoneCourante == zones[15]) {
        	zones[15].setNomImage("15-Jardin_Jardinier.jpg");
        	modifierCarte();
    	}
    }
    
    /*
     * 
     */
    public void permissionParler() {
    	if (discussionEnCours) {
    		discussionEnCours = false;
    	} else {
    		discussionEnCours = true;
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
    	if (!tpPossible && !visionCartePossible && !visionInventairePossible && !discussionEnCours) {
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
            	if (zoneCourante == zones[5] && clefPorteUtilisee == false) {
            		gui.afficher("Vous devez ouvrir la porte avec la clef pour y rentrer ! Non mais c'est quoi ces manières ?!");
            		gui.afficher();
            	} else {
                	allerEn( "EST" ); 
            	}
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
            case "PO" : case "POUBELLE" :
            	zoneCourante = zones[25];
            	modifierCarte();
            	gameOver();
            	break;
            case "TAB" : case "TABLEAU" :
            	allerEn( "TABLEAU" ); 
            	break;
            case "PA" : case "PARLER" :
            	parler();
            	permissionParler();
            	break;
            case "PR" : case "PRENDRE" :
            	prendre();
            	break;
            case "I" : case "INVENTAIRE" :
            	retenirZone();
            	permissionInventaire();
            	afficherInventaire();
            	break;
            case "C" : case "CARTE" : 
            	retenirZone(); // Permet de retenir dans quelle zone on était pour y retourner quand on sortira de l'affichage du plan de la maison
            	permissionCarte(); // Permet d'activer la vision du plan de la maison
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
            	permissionTeleportation();
            	gui.afficher("Tu peux maintenant te téléporter dans tout le manoir sauf les zones auxquelles tu n'as pas accès.\nPour sortir de ce mode entre à nouveau la commande [TP]\nTu peux te servir du plan avec la commande [CARTE] pour savoir où aller, les pièces sont numérotées.\nIl faut donc taper le numéro de la salle désirée pour s'y rendre.");
            	gui.afficher();
            	break;
    		case "U CC" : case "U C C" : case "UTILISER CC" : case "UTILISER C C" : case "U CLEF CAVE" : case "UTILISER CLEF CAVE" : case "UTILISER CLEF DE LA CAVE" :
    			if (zoneCourante == zones[5]) {
                	clefPorteUtilisation = true;
                	utiliserClef(1);
    			} else {
    				gui.afficher("Tu n'es pas dans la bonne zone, tu n'as pas la permission de faire ça !");
    				gui.afficher();
    			}
            	break;
            case "U CCC" : case "U C C C" : case "UTILISER CCC" : case "UTILISER C C C" : case "U CLEF CAVE COFFRE" : case "UTILISER CLEF CAVE COFFRE" : case "UTILISER CLEF DU COFFRE DE LA CAVE" :
            	if (zoneCourante == zones[14]) {
                	clefCoffreUtilisation = true;
                	utiliserClef(5);
            	} else {
    				gui.afficher("Tu n'es pas dans la bonne zone, tu n'as pas la permission de faire ça !");
    				gui.afficher();
    			}
            	break;
            case "Q" : case "QUITTER" :
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                gui.afficher();
                break;
            }
    	} else if (discussionEnCours && !visionInventairePossible && !tpPossible && !visionCartePossible) {
    		if (zoneCourante == zones[1]) {
    			switch (commandeLue.toUpperCase()) {
    			case "1" :
    				gui.afficher(" | " + "Je suis le Majordome, je travaille ici depuis ... 27 ans déjà ? Comme le temps passe vite !\n" + " | " + "Je connais toute cette famille et leurs employés comme s'ils faisaient partie de la mienne !\n" + " | " + "Si vous avez la moindre interrogation n'hésitez pas !\n" + " | " + "Je souhaite vous aider à résoudre cette enquête au plus vite !");
    				gui.afficher();
    				break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		}
    	} else if (visionInventairePossible && !tpPossible && !visionCartePossible && !discussionEnCours) { 
    		switch (commandeLue.toUpperCase() ) {
    		case "EX B" : case "EXAMINER BOUTON" :
    			verificationObjetRecupere(0);
    			break;
    		case "EX CC" : case "EX C C" : case "EX CLEF CAVE" :case "EXAMINER CLEF CAVE" : case "EXAMINER CLEF DE LA CAVE" :
    			verificationObjetRecupere(1);
    			break;
    		case "EX BO" : case "EX B O" : case "EX BOUCLE OREILLE" : case "EXAMINER BOUCLE OREILLE" : case "EXAMINER BOUCLE DOREILLE" : case "EXAMINER BOUCLE D OREILLE"  : case "EXAMINER BOUCLE D\'OREILLE" :
    			verificationObjetRecupere(2);
    			break;
    		case "EX LC" : case "EX L C" : case "EX LETTRE COMPROMETTANTE" : case "EXAMINER LETTRE COMPROMETTANTE" :
    			verificationObjetRecupere(3);
    			break;
    		case "EX LA" : case "EX L A" : case "EX LETTRE AMOUR" : case "EXAMINER LETTRE AMOUR" : case "EXAMINER LETTRE DAMOUR" : case "EXAMINER LETTRE D AMOUR" : case "EXAMINER LETTRE D\'AMOUR" :
    			verificationObjetRecupere(4);
    			break;
    		case "EX CCC" : case "EX C C C" : case "EX CLEF COFFRE" : case "EXAMINER CLEF COFFRE CAVE" : case "EXAMINER CLEF COFFRE" : case "EXAMINER CLEF DU COFFRE DE LA CAVE" :
    			verificationObjetRecupere(5);
    			break;
    		case "EX C" : case "EX COUTEAU" : case "EXAMINER COUTEAU" :
    			verificationObjetRecupere(6);
    			break;
    		case "EX LL" : case "EX L L" : case "EX LETTRE LICENCIEMENT" : case "EXAMINER LETTRE LICENCIEMENT" : case "EXAMINER LETTRE DE LICENCIEMENT" : 
    			verificationObjetRecupere(7);
    			break;
    		case "I" : case "INVENTAIRE" :
            	revenirZonePrecedente();
            	permissionInventaire();
    			break;
           	default : 
                gui.afficher("Commande inconnue");
                gui.afficher();
                break;
    		}
    	} else if (visionCartePossible && !tpPossible && !visionInventairePossible && !discussionEnCours) {
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
            	permissionCarte();
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
    	} else if (tpPossible && !visionCartePossible && !visionInventairePossible && !discussionEnCours) {
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
            	if (!clefPorteUtilisee) {
            		gui.afficher("Tu n'as pas la permission de te téléporter la bas, tu dois d'abord trouver la clef ! Espèce de tricheur !");
            		gui.afficher();
            	} else {
                    teleporterJoueur(14);
            	}
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
            	permissionTeleportation();
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