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
	
	Zone [] zones;
	ArrayList<Indices> inventaire = new ArrayList<Indices>();
	ArrayList<Indices> inventaireTemp = new ArrayList<Indices>();
	Indices[] tabIndices;
	Personne [] personnes;
	

	/**
	 * Creation des indices(Objets et dialogues)
	 *
	 * @author Tarik D & Sami B
	 */
	public void creerIndices() {
		tabIndices = new Indices[25];
		// Les objets
		tabIndices[0] = new Objet("Bouton", "Ceci est un bouton de veste, il semblerait qu'il provient d'un uniforme de travail. Je devrais demander aux employés.");
		tabIndices[1] = new Objet("Clef de la cave", "Ceci est la clef permettant d'ouvrir la porte de la cave.");
		tabIndices[2] = new Objet("Boucle d'oreille", "Une boucle d'oreille, à qui peut-elle appartenir ? Je devrais interroger la Mère ou la Femme de Chambre... ");
		tabIndices[3] = new Objet("Lettre Compromettante", "Lettre dévoilant une relation adultère entre le Père et la Femme de Chambre. Je me demande si la Mère était au courant...");
		tabIndices[4] = new Objet("Lettre d'Amour", "Lettre de déclaration d'amour du Cuisiner envers la Femme de Chambre. Il semblerait qu'il avait des sentiments pour elle...");
		tabIndices[5] = new Objet("Clef du coffre de la cave", "Ceci est la clef permettant d'ouvrir le coffre situé dans la cave. Que peut-il bien y avoir dedans ?");
		tabIndices[6] = new Objet("Couteau", "Les seules empreintes trouvées sur le couteau sont celles du Cuisiner.");
		tabIndices[7] = new Objet("Lettre de Licenciement", "Lettre de licenciement du Cuisinier rédigée par le Père");
		// Les dialogues

		tabIndices[8] = new Dialogue("Bonjour jeune fille quelle information pourrais-tu me donner ?", "Mon pére et mon frere passais tout leur temps a se disputer", personnes[5]);
		tabIndices[9] = new Dialogue("Salut Garcon parle moi un peu de ta relation avec ton pére","Mon pére je l'aimais pas car il me rabaissait tout le temps et il acceptait jamais mes choix ", personnes[6]);
		tabIndices[10] = new Dialogue("Bonjour Madame, es ce que votre mari avait des problémes avec des personnes dans cette maison ?", "Mon mari c'est recemment disputer avec le jardinier ", personnes[4]);
		tabIndices[11] = new Dialogue("Es ce que cette Boucle d’oreille vous apartient ?", "Non elle ne m'appartient pas je crois qu'elle appartient a la femme de menage ", personnes[4]);
		tabIndices[12] = new Dialogue("Bonjour Madame, es ce que cette Boucle d’oreille vous apartient ?", "Oui elle m'appartient, j'ai la perdu hier en faisant le menage", personnes[1]);
		tabIndices[13] = new Dialogue("J'ai trouvé une lettre dans la salle de bain et en l\'examinant je comprend que vous aviez une relation secréte avec le pére pourriez vous m'en dire plus ?", "oui en effet on s\'aimait moi et le péreet il m'avais promis de quitter sa femme pour me marier, d\'ailleurs je me demande si la mére n\'etait pas au courant vu que la lettre etait posé dans la salle de bain ", personnes[1]);
		tabIndices[14] = new Dialogue("Avez-vous une idée sur la lettre d'amour trouvé dans la salle de bain ?", "Oui, mais je vais jamais tuer mon mari pour ca", personnes[4]);
		tabIndices[15] = new Dialogue("es que ton pére avez des problémes avec quelq'un dans cette maison ?", "oui mon pére insultait reguliérement le cuisinier pour sa bouffe qu'il n'appreciait pas ", personnes[5]);
		tabIndices[16] = new Dialogue(" Monsieur, es ce que vous avez trouvé cette lettre ?", "Oui, je l\'ai trouvé dans la Cuisine et je l'ai prise pour eviter que le cuisinier se decourage par la reponse de la femme de chambre ", personnes[0]);
		tabIndices[17] = new Dialogue("Bonjour Monsieur, Avez-vous des nouvelles?", "Oui, Un couteau est manquant mais que n’importe qui aurait pu le prendre", personnes[2]);
		tabIndices[18] = new Dialogue("vous qui conaissez la maison mieux que personne pourriez vous m'indiquer des choses dont je ne suis pas au courant ", "Oui,tennez cette clé je l'ai trouvé dans le Bureau ", personnes[0]);
		tabIndices[19] = new Dialogue("j'ai trouvé dans la cave une lettre de licenciement du cuisinier rédiger par votre mari ete vous au courrant de ca ?", "Mon mari m'en a deja parlé oui, mais je n'ai jamais cru qu’il allait passer à l’acte ", personnes[4]);
		tabIndices[20] = new Dialogue("j'ai trouvé ce boutton dans le Salon savez-vous a qui il appartient ?", "ce bouton ressemble a celui de la veste du cuisinier", personnes[0]);
		tabIndices[21] = new Dialogue("ce boutton vous appartient je l'ai trouvé dans le salon ou le crime a etait comis ", "euhh je sais pas je sais pas il est surement tomber tout seul", personnes[2]);
		tabIndices[22] = new Dialogue("Bonjour j'ai appris que vous vous etes disputé avec le pére  avant sa mort aviez vous des problémes avec lui ?", "Non, il etait juste un peu en colére car la pelouse etait mal tondue", personnes[7]);
		tabIndices[24] = new Dialogue("Bonjour avez vous remarque des comportements qui ont changé ces derniers temps ?","Non je n'ai rien remarqué tout etait normale",personnes[1]);
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
    	creerPersonnes();
    	creerIndices();
        creerCarte();
    	
    	
        gui = null;
    }

    /**
     * Initialise le GUI du jeu. 
     * @param g interface utilisateur graphique.
     */
    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }
    
    
    /**
	 * Creation des Personnes
	 *
	 * @author Tarik D & Sami B
	 */
    private void creerPersonnes() {
    	personnes = new Personne[8];
    	personnes[0] = new Personne("Majordome");
    	personnes[1] = new Personne("La femme de chambre");
    	personnes[2] = new Personne("Chef cuisinier");
    	personnes[3] = new Personne("Le pére");
    	personnes[4] = new Personne("La mére");
    	personnes[5] = new Personne("La fille");
    	personnes[6] = new Personne("Le fils");
    	personnes[7] = new Personne("Le jardinier");
    }
    
    /**
     * Cree et initialise les zones.
     * Associe à chaque zone ses sorties.
	 * initialise la zone courante avec la zone de depart
	 * initialise les zone avec les indices
	 * 
	 * @author Léonie A, Tarik D, Sami B.
     */
    private void creerCarte() {
        zones = new Zone [20];
        zones[0] = new Zone("Tableau", "0-Tableau.jpg");
        zones[1] = new Zone("Entree", "1-Entree.jpg" , personnes[0]);
        zones[2] = new Zone("Couloir Ouest", "2-CouloirWest .jpg" );
        zones[3] = new Zone("Couloir Est", "3-CouloirEast.jpg" );
        zones[4] = new Zone("Couloir Nord", "4-CouloirNorth.jpg" );
        zones[5] = new Zone("Garage", "5-Garage.jpg" );
        zones[6] = new Zone("Salle a manger", "6-SalleAManger.jpg", personnes[1]);
        zones[7] = new Zone("Cuisine", "7-Cuisine.jpg", personnes[2] );
        zones[8] = new Zone("Salon", "8-Salon.jpg", personnes[3] );
        zones[9] = new Zone("Burea", "9-Bureau.jpg", personnes[4] );
        zones[10] = new Zone("Chambre Parentale", "10-ChambreParentale.jpg" );
        zones[11] = new Zone("Chambre de la Fille", "11-ChambreDeLaFille.jpg", personnes[5] );
        zones[12] = new Zone("Chambre du Fils", "12-ChambreDuFils.jpg", personnes[6] );
        zones[13] = new Zone("Escalier avec couloir", "13-EscalierAvecCouloir.jpg" );
        zones[14] = new Zone("Cave", "14-Cave.jpg" );
        zones[15] = new Zone("Jardin", "15-Jardin.jpg", personnes[7]);
        zones[16] = new Zone("Salle de Bain", "16-SalleDeBain.jpg" );
        zones[17] = new Zone("Grenier", "17-Grenier.jpg" );
        zones[18] = new Zone("Chambre du Majordome", "18-ChambreDuMajordome.jpg" );
        zones[19] = new Zone("Maison du Gardien", "19-MaisonDuGardien.jpg" );
        
        //Les indices des zones
        //Objet
        zones[8].ajouteIndice(tabIndices[0]);
        zones[9].ajouteIndice(tabIndices[1]);
        zones[10].ajouteIndice(tabIndices[2]);
        zones[14].ajouteIndice(tabIndices[6]);
        zones[15].ajouteIndice(tabIndices[5]);
        zones[16].ajouteIndice(tabIndices[3]);
        zones[18].ajouteIndice(tabIndices[4]);
        zones[17].ajouteIndice(tabIndices[7]);
        //Dialogue
        zones[6].ajouteIndice(tabIndices[12]);
        zones[11].ajouteIndice(tabIndices[8]);
        zones[12].ajouteIndice(tabIndices[9]);
        zones[9].ajouteIndice(tabIndices[10]);
        zones[9].ajouteIndice(tabIndices[11]);
        zones[6].ajouteIndice(tabIndices[13]);
        zones[9].ajouteIndice(tabIndices[14]);
        zones[11].ajouteIndice(tabIndices[15]);
        zones[1].ajouteIndice(tabIndices[16]);
        zones[7].ajouteIndice(tabIndices[17]);
        zones[1].ajouteIndice(tabIndices[18]);
        zones[9].ajouteIndice(tabIndices[19]);
        zones[1].ajouteIndice(tabIndices[20]);
        zones[7].ajouteIndice(tabIndices[21]);
        zones[15].ajouteIndice(tabIndices[22]);
        zones[1].ajouteIndice(tabIndices[18]);
        zones[6].ajouteIndice(tabIndices[24]);
        
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
        
        zoneCourante = zones[1]; 
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
     * Triate la commande lue en parametre
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
        case "P" : case "PARLER" :
        	parler();
        	break;
        case "R" : case "RECUPERER" :
        	recuperer();
        	break;
        case "Q" : case "QUITTER" :
        	terminer();
        	break;
       	default : 
            gui.afficher("Commande inconnue");
            break;
        }
    }

    /**
     * Affiche la description de chaque commande autorisée
     */
    private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autorisÃ©es sont :");
        gui.afficher();
        gui.afficher(Commande.toutesLesDescriptions().toString());
        gui.afficher();
    }

    /**
     * Changement de la localisation du joueur si la sortie demandée existe
     * @param direction La sortie demandée par le joueur
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
        	gui.afficher(zoneCourante.descriptionIndices());
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
    
    /**
	 * en fonction de la zone ou on est et des indices(Objets et Dialogues) qu'on a recuperé on posera différentes questions et on aura différentes réponses
	 *
	 * @author Tarik D & Sami B
	 */
    public void parler() {
    	
    if(zoneCourante == zones[11]) {
    	
		Dialogue dialogue = null;
    		if(tabIndices[8].recuperer == true && tabIndices[15].recuperer == false) 
        	{
    			dialogue =((Dialogue) tabIndices[15]);
    			tabIndices[15].recuperer = true;
 		       	inventaire.add(tabIndices[15]);
        	}
    	
    	if(dialogue == null) {
            	dialogue = ((Dialogue) tabIndices[8]);
            	tabIndices[8].recuperer = true;
            	inventaire.add(tabIndices[8]);
    	}
    
    	gui.afficher(dialogue.toString());
	}
    
    if(zoneCourante == zones[12]) {
    	Dialogue dialogue = ((Dialogue) tabIndices[9]); 
    	tabIndices[9].recuperer = true;
    	inventaire.add(tabIndices[9]);
    	gui.afficher(dialogue.toString());
	}
    
    if(zoneCourante == zones[15]) {
    	Dialogue dialogue = ((Dialogue) tabIndices[22]); 
    	tabIndices[22].recuperer = true;
    	inventaire.add(tabIndices[22]);
    	gui.afficher(dialogue.toString());
	}
    
    if(zoneCourante == zones[9]) {
    	
    	Dialogue dialogue = null;
       
        	if(tabIndices[2].recuperer == true && tabIndices[11].recuperer==false) 
        	{
		       dialogue =((Dialogue) tabIndices[11]);
		       inventaire.add(tabIndices[11]);
		       tabIndices[11].recuperer=true;
        	}
        	if(tabIndices[13].recuperer == true && tabIndices[3].recuperer==true) {
        		for(int j = 0; j <= 7; j++) {
        			if(tabIndices[3].recuperer == true && tabIndices[14].recuperer==false) {
        				dialogue =((Dialogue) tabIndices[14]);
        			    inventaire.add(tabIndices[14]);
        			    tabIndices[14].recuperer=true;
        			}
        		}
        	}
        	if(tabIndices[7].recuperer == true && tabIndices[19].recuperer==false) {
        		dialogue =((Dialogue) tabIndices[19]);
			    inventaire.add(tabIndices[19]);
			    tabIndices[19].recuperer=true;
        	}
	        if(dialogue == null) {
	     	   dialogue = ((Dialogue) tabIndices[10]); 
	     	   inventaire.add(tabIndices[10]);
	     	   tabIndices[10].recuperer=true;
	     	}
	        gui.afficher(dialogue.toString());
      
	}
    if(zoneCourante == zones[6]) {
    	Dialogue dialogue = null;
        for(int i = 0; i < inventaire.size(); i++) 
        {
        	if(tabIndices[2].recuperer == true && tabIndices[12].recuperer==false) 
        	{
		       dialogue =((Dialogue) tabIndices[12]);
		       inventaire.add(tabIndices[12]);
		       tabIndices[12].recuperer=true;
        	}
        	if(tabIndices[4].recuperer == true && tabIndices[13].recuperer==false) 
        	{
		       dialogue =((Dialogue) tabIndices[13]);
		       inventaire.add(tabIndices[13]);
		       tabIndices[13].recuperer=true;
        	}  			
        }
        if(dialogue == null) {
      	   dialogue = ((Dialogue) tabIndices[24]); 
      	   inventaire.add(tabIndices[24]);
      	   tabIndices[24].recuperer=true;
      	}
        gui.afficher(dialogue.toString());
	}
    
    if(zoneCourante == zones[1]) {
    		Dialogue dialogue = null;
    		if(tabIndices[1].recuperer==true) {
	    		 if(tabIndices[4].recuperer==true && tabIndices[16].recuperer==false) {
	    		   dialogue =((Dialogue) tabIndices[16]);
	  		       inventaire.add(tabIndices[16]);
	  		       tabIndices[16].recuperer=true;
	    		 }
	    		 if(tabIndices[0].recuperer==true && tabIndices[20].recuperer==false) {
	      		   dialogue =((Dialogue) tabIndices[20]);
	    		       inventaire.add(tabIndices[20]);
	    		       tabIndices[20].recuperer=true;
	      		 }
    		 }
    		else {
    			   dialogue =((Dialogue) tabIndices[18]);
			       inventaire.add(tabIndices[18]);
			       tabIndices[18].recuperer=true;
			       inventaire.add(tabIndices[1]);
			       tabIndices[1].recuperer=true;
			       
    		}
    		 gui.afficher(dialogue.toString());
    		 if(tabIndices[1].recuperer==true && tabIndices[4].recuperer==false && tabIndices[0].recuperer==false ) {
    			
    			 gui.afficher(tabIndices[1].toString() + " \n");
    		 }
    		
		
	}
    
    if(zoneCourante == zones[7]) {
		Dialogue dialogue = null;
		
		 if(tabIndices[0].recuperer==true && tabIndices[21].recuperer==false) {
			   dialogue =((Dialogue) tabIndices[21]);
		       inventaire.add(tabIndices[21]);
		       tabIndices[21].recuperer=true;
		 }
		 if(dialogue == null) {
			  	dialogue =((Dialogue) tabIndices[17]);
		       inventaire.add(tabIndices[17]);
		       tabIndices[17].recuperer=true;
	     }
		 gui.afficher(dialogue.toString());
	
    }
    
	
    }
    
    /**
	 * En fonction de la zone courante, et de l'objet qui se trouve dans cette zone, on recupere de dernier et on affiche un message
	 *
	 * @author Tarik D & Sami B
	 */
    public void recuperer() {
    	
    	
    	for(int i = 0; i<tabIndices.length;i++) {
    		
	    		if(zoneCourante.indices.contains(tabIndices[i]) && tabIndices[i].getClass().equals(Objet.class)) {
	    			inventaire.add(tabIndices[i]);
	    			tabIndices[i].recuperer = true;
	    			gui.afficher(tabIndices[i].toString());
	    		}
	    		
    	}
    	
	
    }
}
