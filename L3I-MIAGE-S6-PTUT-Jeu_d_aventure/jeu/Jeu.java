package jeu;

/**
 * Nom de classe : Jeu.
 * 
 * Description : La classe jeu est utilis�e pour interagir avec 
 * les personnages et les �l�ments de notre jeu.
 * 
 * Version : 1.0.
 * 
 * Date : 06/02/2021.
 * 
 * @author L�onie A.
 */
public class Jeu {

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
	private Zone precedent;
	private boolean a=true;
	
    public Jeu() {
        creerCarte();
        gui = null;
    }

    /**
     * Initialise le GUI du jeu. 
     * @param g interface utilisateur graphique.
     */
    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }
    
    /**
     * Cree et initialise les zones.
     * Associe � chaque zone ses sorties.
	 * initialise la zone courante avec la zone de depart
	 * 
	 * @author L�onie A.
     */
    private void creerCarte() {
        Zone [] zones = new Zone [24];
        zones[0] = new Zone("Tableau", "0-Tableau.jpg" );
        zones[1] = new Zone("Entree", "1-Entree.jpg" );
        zones[2] = new Zone("Couloir Ouest", "2-CouloirWest .jpg" );
        zones[3] = new Zone("Couloir Est", "3-CouloirEast.jpg" );
        zones[4] = new Zone("Couloir Nord", "4-CouloirNorth.jpg" );
        zones[5] = new Zone("Garage", "5-Garage.jpg" );
        zones[6] = new Zone("Salle a manger", "6-SalleAManger.jpg" );
        zones[7] = new Zone("Cuisine", "7-Cuisine.jpg" );
        zones[8] = new Zone("Salon", "8-Salon.jpg" );
        zones[9] = new Zone("Burea", "9-Bureau.jpg" );
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
        zones[21] = new Zone("Plan du Rez de Chauss�e", "21-PlanMaisonRezDeChaussee.jpg");
        zones[22] = new Zone("Plan du Sous Sol", "22-PlanMaison2emeEtage.jpg");
        zones[23] = new Zone("Plan du Second etage","23-PlanMaison2emeEtage.jpg");
        
        zones[0].ajouteSortie(Sortie.SUD, zones[1]); 	// Depuis le Tableau aller dans l'Entr�e
        
        zones[1].ajouteSortie(Sortie.OUEST, zones[2]); 	// Depuis l'Entr�e aller dans le couloir Ouest
        zones[1].ajouteSortie(Sortie.EST, zones[3]); 	// Depuis l'Entr�e aller dans le couloir Est
        zones[1].ajouteSortie(Sortie.NORD, zones[4]); 	// Depuis l'Entr�e aller dans le couloir Nord
        zones[1].ajouteSortie(Sortie.SUD, zones[5]); 	// Depuis l'Entr�e aller dans le garage
        zones[1].ajouteSortie(Sortie.TABLEAU, zones[0]); 	// Depuis l'Entr�e aller sur le Tableau
        
        zones[2].ajouteSortie(Sortie.EST, zones[1]);  	// Depuis le couloir Ouest aller dans l'Entr�e
        zones[2].ajouteSortie(Sortie.OUEST, zones[7]);	// Depuis le couloir Ouest aller dans la Cuisine
        zones[2].ajouteSortie(Sortie.NORD, zones[6]);	// Depuis le couloir Ouest aller dans la Salle � Manger
        
        zones[3].ajouteSortie(Sortie.OUEST, zones[1]); 	// Depuis le couloir Est aller dans l'Entr�e
        zones[3].ajouteSortie(Sortie.EST, zones[9]);	// Depuis le couloir Est aller dans le Bureau
        zones[3].ajouteSortie(Sortie.NORD, zones[8]);	// Depuis le couloir Est aller dans le Salon
        
        zones[4].ajouteSortie(Sortie.SUD, zones[1]);	// Depuis le couloir Nord aller dans l'Entr�e
        zones[4].ajouteSortie(Sortie.OUEST, zones[10]);	// Depuis le couloir Nord aller dans la Chambre Parentale
        zones[4].ajouteSortie(Sortie.NORDOUEST, zones[11]);	// Depuis le couloir Nord aller dans la Chambre de la Fille
        zones[4].ajouteSortie(Sortie.NORDEST, zones[12]);	// Depuis le couloir Nord aller dans la Chambre du Fils
        zones[4].ajouteSortie(Sortie.EST, zones[13]);	// Depuis le couloir Nord aller dans l'Escalier avec le couloir
        
        zones[5].ajouteSortie(Sortie.SUD, zones[1]);	// Depuis le garage pour aller dans l'Entree
        zones[5].ajouteSortie(Sortie.EST, zones[14]);	// Depuis le garage pour aller dans la Cave
        
        zones[6].ajouteSortie(Sortie.SUD, zones[2]);	// Depuis la Salle � Manger pour aller dans le couloir Ouest
        
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
        
        zoneCourante = zones[1]; 
        
        /**
         * Plan de la maison
         */
        
        
        zoneCourante.ajouteSortie(Sortie.REZDECHAUSSE, zones[21]); //Depuis n'importe ou vers la carte
       
        zones[21].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[21].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
        zones[21].ajouteSortie(Sortie.SECONDETAGE, zones[23]);
        
        zones[22].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[22].ajouteSortie(Sortie.REZDECHAUSSE, zones[21]);
        zones[22].ajouteSortie(Sortie.SECONDETAGE, zones[23]);

        zones[23].ajouteSortie(Sortie.SOUSSOL, zones[20]);
        zones[23].ajouteSortie(Sortie.REZDECHAUSSE, zones[21]);
        zones[23].ajouteSortie(Sortie.PREMIERETAGE, zones[22]);
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
        case "T" : case "TABLEAU" :
        	allerEn( "TABLEAU"); 
        	break;
        	/**
        	 * Carte
        	 */
        case "-1": case "SOUSSOL":
        	Carte("SOUSSOL");
        	break;
        case "C" : case "REZDECHAUSSE" : case "0" : case "CARTE":
        	Carte("REZDECHAUSSE");
        	break;
        case "1" : case "PREMIERETAGE":
        	Carte("PREMIERETAGE");
        	break;
        case "2" : case "SECONDETAGE":
        	Carte("SECONDETAGE");
        	break;
        case "XC" : case "XCARTE":
        	Carte("XCARTE");
        case "Q" : case "QUITTER" :
        	terminer();
        	break;
       	default : 
            gui.afficher("Commande inconnue");
            break;
        }
    }

    private void Carte(String commandeCarte)
    {
    	if(a==true)
    	{
    	precedent=zoneCourante;
    	a=false;
    	}
    	switch(commandeCarte)
    	{
    	case "-1": case "SOUSSOL":
    		allerEn("SOUSSOL");
    		break;
    	case "0": case "REZDECHAUSSE":
    		allerEn("REZDECHAUSSE");
    		break;
    	case "1": case "PREMIERETAGE":
    		allerEn("PREMIERETAGE");
    		break;
    	case "2": case "SECONDETAGE":
    		allerEn("SECONDETAGE");
    		break;
    	case "XC": case "XCARTE":
    		a=true;
    		zoneCourante=precedent;
    		gui.afficher(zoneCourante.descriptionLongue());
        	gui.afficher();
        	gui.afficheImage(zoneCourante.nomImage());
    		break;
    	
    	}
    }
    /**
     * Affiche la description de chaque commande autoris�e
     */
    private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autorisees sont :");
        gui.afficher();
        gui.afficher(Commande.toutesLesDescriptions().toString());
        gui.afficher();
    }

    /**
     * Affiche la localisation du joueur
     * @author L�onie A.
     */
    /**
    private void dialogues(String direction) {
    	Zone nouvelle = zoneCourante.obtientSortie( direction);
    	switch (zones[]) {
    	case "1" :
    		gui.afficher("Parler au majordome :");
    	}
    }
    */
    /**
     * Changement de la localisation du joueur si la sortie demand�e existe
     * @param direction La sortie demand�e par le joueur
     */
    private void allerEn(String direction) {
    	Zone nouvelle = zoneCourante.obtientSortie( direction);
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