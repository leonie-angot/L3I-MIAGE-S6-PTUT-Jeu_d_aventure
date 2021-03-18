package jeu;

import java.util.ArrayList;

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
 * @author L�onie A. et Ylli P. 
 */
public class Jeu {
	
	// ArrayList r�pertoriant les Objets pr�sents sur la map
	ArrayList<Objet> tabObjet = new ArrayList<Objet>();
	
	ArrayList<Objet> inventaire = new ArrayList<Objet>();
	
	ArrayList<Dialogue> tabDialogue = new ArrayList<Dialogue>();
	
	ArrayList<Indice> listeIndice = new ArrayList<Indice>();
	
	/*
	 * Initialisation des variables pour la T�l�portation et l'Affichage du Plan de la maison
	 */
	boolean tpPossible = false;
	boolean visionCartePossible = false;
	boolean visionInventairePossible = false;
	boolean discussionEnCours = false;
	boolean accuserPossible = false;
	
    boolean clefPorteUtilisee = false;
    boolean clefCoffreUtilisee = false;
    
    boolean clefPorteUtilisation = false;
    boolean clefCoffreUtilisation = false;
    
    boolean caveVisitee=false;
    
	private Zone zonePrecedente;

	/*
	 * Initialisation des objets sur la map
	 */
	public void creerObjet() {
		this.tabObjet.add(new Objet("Bouton", "Ceci est un bouton de veste, il semblerait qu'il provient d'un uniforme de travail. Je devrais demander aux employ�s.", zones[8]));
		this.tabObjet.add(new Objet("Clef de la cave", "Ceci est la clef permettant d'ouvrir la porte de la cave.", zones[9]));
		this.tabObjet.add(new Objet("Boucle d'oreille", "Une boucle d'oreille, � qui peut-elle appartenir ? Je devrais interroger la M�re ou la Femme de Chambre... ", zones[10]));
		this.tabObjet.add(new Objet("Lettre Compromettante", "Lettre d�voilant une relation adult�re entre le P�re et la Femme de Chambre. Je me demande si la M�re �tait au courant...", zones[1]));
		this.tabObjet.add(new Objet("Lettre d'Amour", "Lettre de d�claration d'amour du Cuisiner envers la Femme de Chambre. Il semblerait qu'il avait des sentiments pour elle...", zones[18]));
		this.tabObjet.add(new Objet("Clef du coffre de la cave", "Ceci est la clef permettant d'ouvrir le coffre situ� dans la cave. Que peut-il bien y avoir dedans ?", zones[15]));
		this.tabObjet.add(new Objet("Couteau", "Les seules empreintes trouv�es sur le couteau sont celles du Cuisiner.", zones[14]));
		this.tabObjet.add(new Objet("Lettre de Licenciement", "Lettre de licenciement du Cuisinier r�dig�e par le P�re", zones[1]));
	}
	
	/**
	 * 
	 * @author L�onie A.
	 */
	public void creerDialogue() { // TODO
		//Questions
		this.tabDialogue.add(new Dialogue(1, "1. Dites-m'en plus sur vous."));
		this.tabDialogue.add(new Dialogue(2, "2. Que saviez-vous sur le P�re et cette famille?"));
		this.tabDialogue.add(new Dialogue(3, "3. Que faisiez-vous hier au moment du meurtre ?")); 
		this.tabDialogue.add(new Dialogue(4, "4. Est-ce que cette boucle d'oreille est � vous ?"));
		this.tabDialogue.add(new Dialogue(5, "5. Est-ce que le P�re avait des conflits avec certains des employ�s ?"));
		this.tabDialogue.add(new Dialogue(6, "4. Est-ce que c'est toi qui a �crit sur le tableau dans la Cave ?"));
		this.tabDialogue.add(new Dialogue(7, "5. Pouriez-vous m'expliquer quelle �tait votre relation avec le P�re ? J'ai trouv� cette lettre dans la salle de bain..."));
		this.tabDialogue.add(new Dialogue(8, "6. J'ai trouv� une lettre d�voilant une relation adult�re entre le P�re et la Femme de M�nage, �tiez-vous au courant ?"));
		this.tabDialogue.add(new Dialogue(9, "4. Pouvez-vous m'expliquer ce que signifie cette Lettre d'Amour envers la Femme de Chambre ?"));
		this.tabDialogue.add(new Dialogue(20, "7. Etiez-vous au courant que le P�re souhaitait licencier le Cuisinier ?"));
		
		// Majordome
		this.tabDialogue.add(new Dialogue(10, "Bonjour, vous devez �tre le d�tective qui travaille sur cette enqu�te.\n" + " | " + "En quoi puis-je vous aider ?", false));//6
		this.tabDialogue.add(new Dialogue(11, "Je suis le Majordome, je travaille ici depuis ... 27 ans d�j� ? Comme le temps passe vite !\n" + 
		" | " + "Je connais toute cette famille et leurs employ�s comme s'ils faisaient partie de la mienne !\n" + 
		" | " + "Si vous avez la moindre interrogation n'h�sitez pas !\n" + " | " + "Je souhaite vous aider � r�soudre cette enqu�te au plus vite !"));//7
		this.tabDialogue.add(new Dialogue(12, "Il y avait des tensions dans cette famille... Mais comme dans toutes non ?"));//8
		this.tabDialogue.add(new Dialogue(13, "J'�tais avec la Femme de Chambre, nous d�barassions la table apr�s le souper alors que la famille allait se coucher."));//9
		this.tabDialogue.add(new Dialogue(14, "Je viens de me rappeler ! J'ai retrouv� �a hier dans le bureau du P�re, tenez !"));//10
		this.tabDialogue.add(new Dialogue(15, "Je l'ai trouv�e dans la Cuisine, je l'avais prise pou d�courager le Cuisinier d'avouer ses sentiments...\n" + 
		" | " + "Ainsi, il n'aurait pas eu la peine d'�tre rejet�... enfin, vous voyez quoi."));
		this.tabDialogue.add(new Dialogue(16 ,"Oui, il m'en avait inform� il y a quelques jours maintenant, mais ce n'est qu'hier qu'il l'a r�dig�e.\n" + 
		" | " + "Je l'ai trouv�e dans le couloir Est hier soir et ai trouv� �a �trange. J'ai donc pens� qu'il fallait vous la donner"));
		
		// Femme de Chambre
		this.tabDialogue.add(new Dialogue(60, "Bonjour, vous avez attrap� le meurtrier ? Mais quel malheur !\n" + " | " + "Comment est-ce que cela a pu se produire ?!", false));//11
		this.tabDialogue.add(new Dialogue(61, "Je suis Femme de Chambre, de M�nage, un peu tout ce que vous voulez. Ca fait presque 2 ans maintenant que je travaille ici... Quel malheur..."));//12
		this.tabDialogue.add(new Dialogue(62, "La P�re... Il ne m�ritait pas �a... Il y avait des disputes au sein de ce foyer, mais jamais rien d'aussi grave !"));//13
		this.tabDialogue.add(new Dialogue(63, "Hier soir ? J'�tais entrain de d�barasser la table apr�s le diner et nous rangions la cuisine avant de finir notre service."));//14
		this.tabDialogue.add(new Dialogue(64, "Oui... C'est ma boucle d'oreille, je la cherche depuis un moment !\n" + 
		" | " + "O� l'avez-vous trouv�e ?\n" + 
		" | " + ". . .\n " + 
		" | " + "Ah dans la chambre parentale ? C'est bizarre, j'ai du la perdre en faisant le m�nage."));//15
		this.tabDialogue.add(new Dialogue(67, "*silence* ... Oui, en effet, nous entretenions une relation intime avec le P�re ! On s'aimait ! *sanglots*\n" + 
		" | " + "Il m'avait promis qu'il allait quitter la M�re ! Je suis s�re qu'elle a du l'apprendre et que pour l'en emp�cher elle... elle l'a... *sanglots"));
		
		// Cuisinier
		this.tabDialogue.add(new Dialogue(70, "Bonjour, je suis le Cuisinier, vous devez �tre le d�tective." + " | " + "Que voulez-vous savoir ?", false));//16
		this.tabDialogue.add(new Dialogue(71, "Comme je l'ai dis, je suis Cuisinier ici depuis 4 ans maintenant..."));//17
		this.tabDialogue.add(new Dialogue(72, "Cette famille avait beaucoup de probl�mes, vraiment pas un foyer sain..."));//18
		this.tabDialogue.add(new Dialogue(73, "J'�tais entrain de rentrer chez moi, comme le diner �tait termin�, javais fini mon service."));//19
		this.tabDialogue.add(new Dialogue(79, "O� avez-vous trouv� �a ? �a ne vous regarde pas ! Rendez-la moi !\n" + 
		" | " + ". . .\n" + 
		" | " + "Comment �a c'est une preuve ? Oui je l'aime ! A en mourir ! Elle est si belle et gentille... *soupire*"));

		// Mere
		this.tabDialogue.add(new Dialogue(90, "Mon cher mari est mort ! Je vous en prie, trouvez l'assassin et mettez-le en prison !!!", false));//20
		this.tabDialogue.add(new Dialogue(91, "Je suis la M�re et maitenant veuve... Nous nous sommes mari�s il y 18 ans... Il est parti bien trop vite... oh mon ch�ri..."));//21
		this.tabDialogue.add(new Dialogue(92, "Nous n'�tions pas une famille parfaite, loin de l�... Mais nous pouvions toujours compter les uns sur les autres..."));//22
		this.tabDialogue.add(new Dialogue(93, "J'�tais en train de mettre les enfants au lit au moment o�... o�... *sanglots*"));//23
		this.tabDialogue.add(new Dialogue(94, "Non ce n'est pas ma boucle d'oreille, elle est surement � la Femme de Chambre. Vous devriez-aller lui demander."));//24
		this.tabDialogue.add(new Dialogue(95, "Mmmh... Il est vrai que r�c�mment, le P�re s'�tait pris d'une col�re (un peu injustifi�e) contre le Jardinier qui avait coup� les b�goniats trop courts !")); //25
		this.tabDialogue.add(new Dialogue(98, "Comment dire... Oui j'�tais au courant... Mais ne vous m�prenez pas !\n" + 
		" | " + "Oui j'avais vu cette lettre, et avait donc compris leur relation... Mais... *sanglots*\n" + 
		" | " + "Je n'aurai jamais tu� le P�re de mes enfants pour �a ! Les priver de leur P�re serait inhumain...\n"  + 
		" | " + "J'�tais triste en l'apprenant, mais pas en col�re... *sanglots*"));
		
		// Fille
		this.tabDialogue.add(new Dialogue(110, "Mon petit Papa... Qui a bien pu lui faire �a ?! Trouvez celui qui a tu� mon p�re !", false));//26
		this.tabDialogue.add(new Dialogue(111, "Je suis la Fille, j'ai 15 ans. Mon P�re �tait un homme bon, il ne m�ritait pas de mourir ainsi... *sanglots*"));//27
		this.tabDialogue.add(new Dialogue(112, "Mes parents s'aimaient beaucoup, �a n'allait pas toujours entre eux, mais pour j'essayais de ne pas trop y penser..."));//28
		this.tabDialogue.add(new Dialogue(113, "Ma m�re venait de me mettre au lit, j'�tais sur mon t�l�phone comme � mon habitude avant d'essayer de dormir..."));//29
		this.tabDialogue.add(new Dialogue(115, "Mon P�re avait pour habitude de se disputer avec le Cuisinier dont il insultait r�guli�rement la Cuisine...\n" + 
		" | " + "Pourtant Maman, mon Fr�re et moi n'avions rien � redire, c'�tait tr�s bon en r�alit� !\n" + 
		" | " + "Ah oui et il s\'est violement disput� � propos d'une... plante ?... avec le Jardinier l\'autre jour, c'�tait ridicule..."));
		this.tabDialogue.add(new Dialogue(116, "Ces �critures sur le tableau ? Ca doit �tre mon Fr�re qui a �crit �a... Ils ne s'entendaient pas bien avec notre P�re...\n" + 
		" | " + "Il �tait trop exigeant avec mon fr�re, il en attendait toujours trop de lui..."));//30
		
		// Fils
		this.tabDialogue.add(new Dialogue(120, "Qui a bien pu faire �a ? Tuer mon p�re de sang froid... Comment peut-on faire �a ?", false));//31
		this.tabDialogue.add(new Dialogue(121, "Je suis le Fils, j'ai 14 ans... Que voulez-vous savoir de plus ?"));//32
		this.tabDialogue.add(new Dialogue(122, "Pas grand chose, rien qui pourrait vous int�resser."));//33
		this.tabDialogue.add(new Dialogue(123, "Je venais tout juste de me mettre au lit au moment o�... l'incident est survenu."));//34
		this.tabDialogue.add(new Dialogue(126, "Non ! Enfin... Oui c'est moi, mais c'est pas ce que vous croyez, je l'aimais mon p�re...\n" + 
		" | " + "Je veux devenir Musicien mais lui voulait me forcer � devenir avocat comme lui... Je savais que je ne serai pas heureux en suivant cette voie, mais il n'arrivait pas � l'accepter" + 
		" | " +  "Parfois il �tait vraiment difficile � vivre..."));
		
		// Jardinier
		this.tabDialogue.add(new Dialogue(150, "Bonjour, vous �tes le d�tective qui travaille sur cette enqu�te ?\n" + " | " + "J'esp�re que vous allez vite attraper le malade qui a commis ce crime !", false));
		this.tabDialogue.add(new Dialogue(131, "Je suis Jardinier et Gardien dans ce manoir depuis 9 ans maintenant\n " + " | " + "J'habite donc dans cette propri�t� dans une annexe dans le Jardin qui m'est destin�e."));
		this.tabDialogue.add(new Dialogue(132, "Le P�re et la M�re se disputaient souvent, mais il se disputait aussi beaucoup avec son Fils.\n " + " | " + "C'�tait un homme dur et exigeant, souvent d'humeur �xecrable..."));
		this.tabDialogue.add(new Dialogue(133, "J'�tais dans ma Chambre � mon habitude, entrain de me pr�parer � manger."));
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
    Zone [] zones = new Zone [27];
    
    /**
     * Cree et initialise les zones.
     * Associe � chaque zone ses sorties.
	 * initialise la zone courante avec la zone de depart
	 * 
	 * @author L�onie A.
     */
    private void creerCarte() {
        zones[0] = new Zone("le Tableau des Suspects", "0-Tableau.jpg" );
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
        zones[21] = new Zone("le Plan du Rez de Chauss�e", "21-PlanMaisonRezDeChaussee.jpg");
        zones[22] = new Zone("le Plan du Premier �tage", "22-PlanMaison1erEtage.jpg");
        zones[23] = new Zone("le Plan du Second �tage","23-PlanMaison2emeEtage.jpg");
        zones[24] = new Zone("l'Inventaire","24-Inventaire.jpg");
        zones[25] = new Zone("la Poubelle","25-Poubelle.jpg");
        zones[26] = new Zone("l'Accueil","26-EcranDAccueil.jpg");

        zones[0].ajouteSortie(Sortie.SUD, zones[1]); 		// Depuis le Tableau aller dans l'Entr�e
        
        zones[1].ajouteSortie(Sortie.OUEST, zones[2]); 		// Depuis l'Entr�e aller dans le couloir Ouest
        zones[1].ajouteSortie(Sortie.EST, zones[3]); 		// Depuis l'Entr�e aller dans le couloir Est
        zones[1].ajouteSortie(Sortie.NORD, zones[4]); 		// Depuis l'Entr�e aller dans le couloir Nord
        zones[1].ajouteSortie(Sortie.SUD, zones[5]); 		// Depuis l'Entr�e aller dans le garage
        zones[1].ajouteSortie(Sortie.TABLEAU, zones[0]); 	// Depuis l'Entr�e aller sur le Tableau

        zones[2].ajouteSortie(Sortie.EST, zones[1]);  		// Depuis le couloir Ouest aller dans l'Entr�e
        zones[2].ajouteSortie(Sortie.OUEST, zones[6]);		// Depuis le couloir Ouest aller dans la Cuisine
        zones[2].ajouteSortie(Sortie.NORD, zones[7]);		// Depuis le couloir Ouest aller dans la Salle � Manger
        
        zones[3].ajouteSortie(Sortie.OUEST, zones[1]); 		// Depuis le couloir Est aller dans l'Entr�e
        zones[3].ajouteSortie(Sortie.EST, zones[9]);		// Depuis le couloir Est aller dans le Bureau
        zones[3].ajouteSortie(Sortie.NORD, zones[8]);		// Depuis le couloir Est aller dans le Salon
        
        zones[4].ajouteSortie(Sortie.SUD, zones[1]);		// Depuis le couloir Nord aller dans l'Entr�e
        zones[4].ajouteSortie(Sortie.OUEST, zones[10]);		// Depuis le couloir Nord aller dans la Chambre Parentale
        zones[4].ajouteSortie(Sortie.NORDOUEST, zones[11]);	// Depuis le couloir Nord aller dans la Chambre de la Fille
        zones[4].ajouteSortie(Sortie.NORDEST, zones[12]);	// Depuis le couloir Nord aller dans la Chambre du Fils
        zones[4].ajouteSortie(Sortie.EST, zones[13]);		// Depuis le couloir Nord aller dans l'Escalier avec le couloir
        
        zones[5].ajouteSortie(Sortie.SUD, zones[1]);		// Depuis le garage pour aller dans l'Entree
        zones[5].ajouteSortie(Sortie.EST, zones[14]);		// Depuis le garage pour aller dans la Cave
        
        zones[6].ajouteSortie(Sortie.SUD, zones[2]);		// Depuis la Salle � Manger pour aller dans le couloir Ouest

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
        zones[14].ajouteSortie(Sortie.POUBELLE, zones[25]);	// Depuis la Cave pour aller dnas la Poubelle
        
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
        
        zones[26].ajouteSortie(Sortie.JOUER, zones[1]);
        
        zoneCourante = zones[26];
        
        creerObjet();
        creerDialogue();
    }

    /*
     * Donne ou enl�ve la permission au joueur de se t�l�porter dans la map de son choix
     */
    private void permissionTeleportation() {
    	tpPossible = (tpPossible) ? false : true;
    }
    
    /*
     * Permet de t�l�porter le joueur de se t�l�porter dans la map de son choix
     */
    private void teleporterJoueur(int idZone) {
    	zoneCourante = zones[idZone];
    	gui.afficher(zoneCourante.descriptionLongue());
    	gui.afficher();
    	gui.afficheImage(zoneCourante.nomImage());
    }
    
    /*
     * Donne ou enl�ve la permission au joueur de voir la carte
     */
    private void permissionCarte() {
    	visionCartePossible = (visionCartePossible) ? false : true;
    }
    
    /*
     * Donne ou enl�ve la permission au joueur de voir son inventaire
     */
    private void permissionInventaire() {
    	visionInventairePossible = (visionInventairePossible) ? false : true;
    }
    
    /*
     * 
     */
    private void permissionAccuser() {
    	accuserPossible = (accuserPossible) ? false : true;
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
     * Permet de faire retourner le joueur � sa position initiale avant de consulter le plan du manoir
     */
    private void revenirZonePrecedente() {
    	for (int i = 1; i <= 24; i++) {
    		if (zonePrecedente == zones[i]) {
    			zoneCourante = zones[i];
    			montrerCarteJoueur(i);
    		}
    	}
    }
    
    /**
     * 
     * @author L�onie A. et Ylli P.
     */
    private void utiliserPrendre()
    {
        if(zoneCourante == zones[8] || zoneCourante == zones[9] ||zoneCourante == zones[10] || zoneCourante == zones[14] || zoneCourante == zones[15] || zoneCourante == zones[16] ||zoneCourante == zones[18]) 
        {
            prendre(8,0,"8-Salon_vide.jpg");
            prendre(9,1,"9-Bureau_vide.jpg");
            prendre(10,2,"10-ChambreParentale_vide.jpg");
            prendre(14,6,"14-Cave_vide.jpg");
            prendre(15,5,"15-Jardin_vide.jpg"); 
            prendre(16,3,"16-SalleDeBain_vide.jpg"); 
            prendre(18,4,"18-ChambreDuMajordome_vide.jpg"); 
        } else {
            gui.afficher("Il n'y a rien � r�cup�rer ici.");
            gui.afficher();
        }
    }
    
    /**
     * 
     * @author L�onie A. et Ylli P.
     */
    private void prendre(int idZone, int idTabObjet, String nomImage) {
        {
            for (int i = 0; i < inventaire.size(); i++) {
            	if (tabObjet.get(idTabObjet).getNom() == inventaire.get(i).getNom()) {
                    gui.afficher("Il n'y a plus rien � r�cup�rer ici.");
                    gui.afficher();
            	}
            }
            if (zoneCourante == zones[idZone] && tabObjet.get(idTabObjet).getObjetRecupere() == false) {
                gui.afficher("==> Tu viens de r�cup�rer : " + tabObjet.get(idTabObjet).getNom()); 
                gui.afficher();
                if(idZone==14)
                {
                gui.afficher("Ce couteau est couvert de sang. Peut-�tre l'arme du crime ? Il faut l'examiner, c'est �l�mentaire mon cher Watson !"); 
                gui.afficher();
                }
                tabObjet.get(idTabObjet).setObjetRecupere();
                zones[idZone].setNomImage(nomImage);
                modifierCarte();
                this.inventaire.add(tabObjet.get(idTabObjet));
            } 
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
    private void afficherIndice() {
    	if (!this.listeIndice.isEmpty()) {
        	gui.afficher("Voici les indices que vous avez trouv� :");
        	gui.afficher();
        	gui.afficher(listeIndice.toString());
        	gui.afficher();
    	} else {
        	gui.afficher("Vous n'avez pas encore trouv� d'indices ! Il faut commencer � en chercher !");
        	gui.afficher();
    	}
    }
    
    /*
     * 
     */
    private void verificationObjetRecupere(int numObjet) {
    	if (verifierObjetPresentInventaire(numObjet)) {
            gui.afficher(tabObjet.get(numObjet).getDescription());
            gui.afficher();
    	} else {
            gui.afficher("Tu n'as pas encore r�cup�r� cet objet.");
            gui.afficher();
		}
    }
    
    /*
     * 
     */
    private boolean verifierObjetPresentInventaire(int numObjet) {
		boolean objetPresentInventaire = false; 
		for (int i = 0; i < inventaire.size() && objetPresentInventaire == false; i++) {
			if (inventaire.get(i).getNom() == tabObjet.get(numObjet).getNom() ) {
				objetPresentInventaire = true;
				return objetPresentInventaire;
			}
		}
		return objetPresentInventaire;
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
				gui.afficher("La porte est d�v�rouill�e !");
				gui.afficher();
			} else if (inventaire.get(i).getNom() == tabObjet.get(5).getNom() && clefCoffreUtilisee == false && clefPorteUtilisee == true) {
	        	zones[14].setNomImage("14-Cave_couteau.jpg");
	        	modifierCarte();
				clefPresenteInventaire = true;
				clefCoffreUtilisee = true;
				gui.afficher("La coffre est d�v�rouill�e !");
				gui.afficher();
			} else if (clefPorteUtilisee == true && zoneCourante == zones[5]) {
				gui.afficher("La porte est d�j� d�v�rouill�e ! A quoi bon faire deux fois la m�me chose ? C'est pas tr�s fut fut quand m�me...");
				gui.afficher();
			} 			
    	} 
		if (zoneCourante == zones[5] && clefPresenteInventaire == false) {
			gui.afficher("La porte est v�rouill�e, il faut trouver la clef...");
			gui.afficher();
		} else if (zoneCourante == zones[14] && clefPresenteInventaire == false) {
			gui.afficher("Le coffre est v�rouill�, il faut trouver la clef. On dirait que quelqu'un essaye de cacher de cacher quelque chose ici...");
			gui.afficher();
		}
    }
    
    /*
     * 
     */
    private void gameOver() {
    	if (zoneCourante == zones[25]) {
    		gui.afficher("Mais quelle id�e d'aller dans la poubelle aussi ?!");
    		gui.afficher();
    		terminer();
    	}
    }
    
    /*
     * 
     */
    private void question() { //TODO
    	for (int i = 0; i < tabDialogue.size(); i++) {
    		if (tabDialogue.get(i).getNumeroDialogue() == 1 || tabDialogue.get(i).getNumeroDialogue() == 2 || tabDialogue.get(i).getNumeroDialogue() == 3) {
    			gui.afficher(tabDialogue.get(i).getDialogueTexte());
    		}
    	}
    	if (zoneCourante == zones[1]) { // MAJORDOME
    		if (verifierObjetPresentInventaire(4)) {
    			gui.afficher(tabDialogue.get(8).getDialogueTexte());
    		}
    		if (verifierObjetPresentInventaire(7)) {
    			gui.afficher(tabDialogue.get(9).getDialogueTexte());
    		}
    	} else if (zoneCourante == zones[6]) { // FEMME DE CHAMBRE
    		if (verifierObjetPresentInventaire(2)) {
        		gui.afficher(tabDialogue.get(3).getDialogueTexte());
    		}
    		if (verifierObjetPresentInventaire(3)) {
    			gui.afficher(tabDialogue.get(6).getDialogueTexte());
    		}
    	} else if (zoneCourante == zones[7]) {
    		if (verifierObjetPresentInventaire(4)) {
    			gui.afficher(tabDialogue.get(8).getDialogueTexte());
    		}
    	} else if (zoneCourante == zones[9]) { // MERE
    		if (verifierObjetPresentInventaire(2)) {
    			gui.afficher(tabDialogue.get(3).getDialogueTexte());
    		} 
    		gui.afficher(tabDialogue.get(4).getDialogueTexte());
    		if (verifierObjetPresentInventaire(3)) {
    			gui.afficher(tabDialogue.get(7).getDialogueTexte());
    		}
    		if (verifierObjetPresentInventaire(7)) {
    			gui.afficher(tabDialogue.get(9).getDialogueTexte());
    		}
    	} else if (zoneCourante == zones[11]) { // FILLE
    		if (caveVisitee == true) {
        		gui.afficher(tabDialogue.get(5).getDialogueTexte());
    		}
    		gui.afficher(tabDialogue.get(4).getDialogueTexte());

    	} else if (zoneCourante == zones[12] && caveVisitee==true) { // FILS
    		gui.afficher(tabDialogue.get(5).getDialogueTexte());
        }
    }
    
    /*
     * 
     */
    private void reponse(int numeroDialogue) {
    	for (int i = 0; i < tabDialogue.size(); i++) {
    		if (tabDialogue.get(i).getNumeroDialogue() == numeroDialogue)
    		gui.afficher(tabDialogue.get(i).getDialogueTexte());
    	}
    }
    
    private void dejaParleAuPersonnage(int numeroDialogue) {
    	for (int i = 0; i < tabDialogue.size(); i++) {
    		if (tabDialogue.get(i).getNumeroDialogue() == numeroDialogue)
    		tabDialogue.get(i).setDejaParle();
    	}
    }
    
    private boolean verifDejaParle(int numeroDialogue) {
    	for (int i = 0; i < tabDialogue.size(); i++) {
    		if (tabDialogue.get(i).getDejaParle() == true) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
     * Cette m�thode permet de parler � un suspect et affiche les choix disponibles de questions
     */
    private void parler() { // TODO
    	if (zoneCourante == zones[1]) { // MAJORDOME
        	zones[1].setNomImage("1-Entree_Majordome.jpg");
        	modifierCarte();
        	if (!verifDejaParle(10)) {
            	reponse(10);
            	dejaParleAuPersonnage(10);
        	} else if (!verifierObjetPresentInventaire(7)){
        		reponse(14);
            	gui.afficher("==> Tu viens de r�cup�rer : " + tabObjet.get(7).getNom()); 
        		gui.afficher();
            	this.inventaire.add(tabObjet.get(7));
        	}
        	question();
    	} else if (zoneCourante == zones[6]) { // FEMME DE CHAMBRE
        	zones[6].setNomImage("6-SalleAManger_FemmeDeMenage.jpg");
        	modifierCarte();
        	if (!verifDejaParle(60)) {
            	reponse(60);
            	dejaParleAuPersonnage(60);
        	}
        	question();
    	} else if (zoneCourante == zones[7]) {
        	zones[7].setNomImage("7-Cuisine_Cuisinier.jpg");
        	modifierCarte();
        	if (!verifDejaParle(70)) {
            	reponse(70);
            	dejaParleAuPersonnage(70);
        	}
        	question();
    	} else if (zoneCourante == zones[9]) { 
        	zones[9].setNomImage("9-Bureau_Mere.jpg");
        	modifierCarte();
        	if (!verifDejaParle(90)) {
            	reponse(90);
            	dejaParleAuPersonnage(90);
        	}
        	question();
    	} else if (zoneCourante == zones[11]) { // FILLE
        	zones[11].setNomImage("11-Chambre_Fille.jpg");
        	modifierCarte();
        	if (!verifDejaParle(110)) {
            	reponse(110);
            	dejaParleAuPersonnage(110);
        	}
        	question();
    	} else if (zoneCourante == zones[12]) { // FILS
        	zones[12].setNomImage("12-Chambre_Fils.jpg");
        	modifierCarte();
        	if (!verifDejaParle(120)) {
            	reponse(120);
            	dejaParleAuPersonnage(120);
        	}
        	question();
    	} else if (zoneCourante == zones[15]) { 
        	zones[15].setNomImage("15-Jardin_Jardinier.jpg");
        	modifierCarte();
        	if (!verifDejaParle(150)) {
            	reponse(150);
            	dejaParleAuPersonnage(150);
        	}
        	question();
    	}
    }
    
    /*
     * Cette m�thode est utilis�e dans traiterCommande pour acc�der au switch case permettant de choisir quelle question poser au suspect
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
    
    /*
     * 
     */
    private void commandeImpossible(int numeroObjet, int numeroDialogue) {
    	if (!verifierObjetPresentInventaire(numeroObjet)) {
    		gui.afficher("Commande inconnue");
    		gui.afficher();
    	} else {
    		reponse(numeroDialogue);
    	}
    }
    
    /**
     * Traite la commande lue en parametre
     * @param commandeLue la commande saisie par l'utilisateur.
     */
    public void traiterCommande(String commandeLue) {
    	gui.afficher( "> "+ commandeLue + "\n");
    	if (!tpPossible && !visionCartePossible && !visionInventairePossible && !discussionEnCours && !accuserPossible) { // Permet d'acc�der aux commandes g�n�rales
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
            		gui.afficher("Vous devez ouvrir la porte avec la clef pour y rentrer ! Non mais c'est quoi ces mani�res ?!");
            		gui.afficher();
            	} else {
                	allerEn( "EST" ); 
            	}
            	if (zoneCourante == zones[14]) {
            		gui.afficher("Tiens... Qu'est-ce qui est �crit sur le tableau ?\nUn des enfants devait en vouloir au p�re... Je devrais aller leur demander");
            		gui.afficher();
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
            case "JOUER" :
            	allerEn( "JOUER" ); 
            	break;
            case "PO" : case "POUBELLE" :
            	zoneCourante = zones[25];
            	modifierCarte();
            	gameOver();
            	break;
            case "TAB" : case "TABLEAU" :
            	allerEn( "TABLEAU" ); 
            	gui.afficher("Pour accuser un suspect, entrez la commande [ACCUSER].");
            	gui.afficher();
            	break;
            case "PA" : case "PARLER" :
            	if (zoneCourante == zones[1] || zoneCourante == zones[6] || zoneCourante == zones[7] || zoneCourante == zones[9] || zoneCourante == zones[11] || zoneCourante == zones[12]  || zoneCourante == zones[15]) {
            		parler();
                	permissionParler();
            	} else {
            		gui.afficher("T'as vu quelqu'un toi ici ? Non je crois pas non, donc pourquoi t'essaye de parler ?!");
            		gui.afficher();
            	}
            	break;
            case "PR" : case "PRENDRE" :
            	utiliserPrendre();
            	break;
            case "IV" : case "INVENTAIRE" :
            	retenirZone();
            	permissionInventaire();
            	afficherInventaire();
            	break;
            case "ID" : case "INDICE" :
            	afficherIndice();
            	break;
            case "C" : case "CARTE" : 
            	retenirZone(); // Permet de retenir dans quelle zone on �tait pour y retourner quand on sortira de l'affichage du plan de la maison
            	permissionCarte(); // Permet d'activer la vision du plan de la maison
            	gui.afficher("Tu peux maintenant voir la carte, pour changer de plan utilise les commandes [SOUSSOL, REZDECHAUSSEE, 1ERETAGE, 2EMEETAGE]");
            	gui.afficher(); 
            	// Pour permettre d'afficher le plan de l'�tage o� le joueur se trouve
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
            case "TP" : case "TELEPORTATION" : // Commandes disponibles dans le mode T�l�portation
            	permissionTeleportation();
            	gui.afficher("Tu peux maintenant te t�l�porter dans tout le manoir sauf les zones auxquelles tu n'as pas acc�s.\nPour sortir de ce mode entre � nouveau la commande [TP]\nTu peux te servir du plan avec la commande [CARTE] pour savoir o� aller, les pi�ces sont num�rot�es.\nIl faut donc taper le num�ro de la salle d�sir�e pour s'y rendre.");
            	gui.afficher();
            	break;
            case "AC" : case "ACCUSER" :
            	if (zoneCourante != zones[0]) {
            		gui.afficher("Tu dois aller sur le Tableau dans l'Entr�e pour pouvoir accuser un suspect.");
            		gui.afficher();
            	} else {
            		gui.afficher("Veuillez entrer le nom de la personne que vous souhaitez mettre derri�re les barreaux !");
            		gui.afficher();
                	permissionAccuser();
            	}
            	break;
    		case "U CC" : case "U C C" : case "UTILISER CC" : case "UTILISER C C" : case "U CLEF CAVE" : case "UTILISER CLEF CAVE" : case "UTILISER CLEF DE LA CAVE" :
    			if (zoneCourante == zones[5]) {
                	clefPorteUtilisation = true;
                	utiliserClef(1);
    			} else {
    				gui.afficher("Tu n'es pas dans la bonne zone, tu n'as pas la permission de faire �a !");
    				gui.afficher();
    			}
            	break;
            case "U CCC" : case "U C C C" : case "UTILISER CCC" : case "UTILISER C C C" : case "U CLEF CAVE COFFRE" : case "UTILISER CLEF CAVE COFFRE" : case "UTILISER CLEF DU COFFRE DE LA CAVE" :
            	if (zoneCourante == zones[14]) {
                	clefCoffreUtilisation = true;
                	utiliserClef(5);
            	} else {
    				gui.afficher("Tu n'es pas dans la bonne zone, tu n'as pas la permission de faire �a !");
    				gui.afficher();
    			}
            	break;
            case "Q" : case "QUITTER" :
            	for (int i = 0; i <= 25; i++) {
    	        	zones[i].setNomImage("26-EcranQuitter.jpg");
    	        	modifierCarte();
            	}
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                gui.afficher();
                break;
            }
    	} else if (accuserPossible && !discussionEnCours && !visionInventairePossible && !tpPossible && !visionCartePossible) {
    		switch (commandeLue.toUpperCase()) {
    			case "AC" : case "ACCUSER" :
    				permissionAccuser();
    				teleporterJoueur(1);
    				break;
    			case "CUISINIER" :
    				gui.afficher("Bravo vous avez trouv� le meurtrier ! C'est gagn� !");
    				gui.afficher();
    			case "MAJORDOME" : case "FEMME DE CHAMBRE" : case "FEMME DE MENAGE" : case "MERE" : case "FILLE" : case "FILS" : case "JARDINIER" :
    				gui.afficher("Vous avez perdu !");
    				gui.afficher();
    				break;
	            case "Q" : case "QUITTER" :
	            	for (int i = 0; i <= 25; i++) {
	    	        	zones[i].setNomImage("26-EcranQuitter.jpg");
	    	        	modifierCarte();
	            	}
	            	terminer();
	            	break;
	           	default : 
	                gui.afficher("Commande inconnue");
	                gui.afficher();
	                break;
    		}
    	} else if (discussionEnCours && !visionInventairePossible && !tpPossible && !visionCartePossible && !accuserPossible) { // Commandes disponibles dans le mode Parler
    		if (zoneCourante == zones[1]) { // MAJORDOME
    			switch (commandeLue.toUpperCase()) { //TODO
    			case "1" :
    				reponse(11);
    				break;
    			case "2" :
    				reponse(12);
    				break;
    			case "3" :
    				reponse(13);
    				break;
    			case "4" :
    				commandeImpossible(4,14);
    				break;
    			case "7" :
    				commandeImpossible(7, 16);
    				break;
    			case "PA" : case "PARLER" : case "RETOUR" :
    	        	zones[1].setNomImage("1-Entree.jpg");
    	        	modifierCarte();
                	permissionParler();
    	        	break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		} else if (zoneCourante == zones[6]) { // FEMME DE CHAMBRE
    			switch (commandeLue.toUpperCase()) { //TODO
    			case "1" :
    				reponse(61);
    				break;
    			case "2" :
    				reponse(62);
    				break;
    			case "3" :
    				reponse(63);
    				break;
    			case "4" :
    				commandeImpossible(2, 64);
    				break;
    			case "5" :
    				commandeImpossible(3, 67);
    				break;
    			case "PA" : case "PARLER" : case "RETOUR" :
    	        	zones[6].setNomImage("6-SalleAManger.jpg");
    	        	modifierCarte();
                	permissionParler();
    	        	break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		} else if (zoneCourante == zones[7]) { // CUISINIER
    			switch (commandeLue.toUpperCase()) { //TODO
    			case "1" :
    				reponse(71);
    				break;
    			case "2" :
    				reponse(72);
    				break;
    			case "3" :
    				reponse(73);
    				break;
    			case "4" :
    				commandeImpossible(4, 79);
    				break;
    			case "PA" : case "PARLER" : case "RETOUR" :
    	        	zones[7].setNomImage("7-Cuisine.jpg");
    	        	modifierCarte();
                	permissionParler();
    	        	break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		}  else if (zoneCourante == zones[9]) { // MERE
    			switch (commandeLue.toUpperCase()) { //TODO
    			case "1" :
    				reponse(91);
    				break;
    			case "2" :
    				reponse(92);
    				break;
    			case "3" :
    				reponse(93);
    				break;
    			case "4" :
    				commandeImpossible(2, 94);
    				break;
    			case "5" :
    				reponse(95);
    				break;
    			case "6" :
    				commandeImpossible(3, 98);
    				break;
      			case "7" :
    				commandeImpossible(7, 98);
    				break;
    			case "PA" : case "PARLER" : case "RETOUR" :
    	        	zones[9].setNomImage("9-Bureau.jpg");
    	        	modifierCarte();
                	permissionParler();
    	        	break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		} else if (zoneCourante == zones[11]) { // FILLE
    			switch (commandeLue.toUpperCase()) { //TODO
    			case "1" :
    				reponse(111);
    				break;
    			case "2" :
    				reponse(112);
    				break;
    			case "3" :
    				reponse(113);
    				break;
    			case "4" :
    				reponse(116);
    				break;
    			case "PA" : case "PARLER" : case "RETOUR" :
    	        	zones[11].setNomImage("11-ChambreDeLaFille.jpg");
    	        	modifierCarte();
                	permissionParler();
    	        	break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		} else if (zoneCourante == zones[12]) { // FILS
    			switch (commandeLue.toUpperCase()) { //TODO
    			case "1" :
    				reponse(121);
    				break;
    			case "2" :
    				reponse(122);
    				break;
    			case "3" :
    				reponse(123);
    				break;
    			case "4" :
    				reponse(126);
    				break;
    			case "PA" : case "PARLER" : case "RETOUR" :
    	        	zones[12].setNomImage("12-ChambreDuFils.jpg");
    	        	modifierCarte();
                	permissionParler();
    	        	break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		} else if (zoneCourante == zones[15]) { // JARDINIER
    			switch (commandeLue.toUpperCase()) { //TODO
    			case "1" :
    				reponse(151);
    				break;
    			case "2" :
    				reponse(152);
    				break;
    			case "3" :
    				reponse(153);
    				break;
    			case "PA" : case "PARLER" : case "RETOUR" :
    	        	zones[15].setNomImage("15-Jardin.jpg");
    	        	modifierCarte();
                	permissionParler();
    	        	break;
               	default : 
                    gui.afficher("Commande inconnue");
                    gui.afficher();
                    break;
    			}
    		}
    		
    	} else if (visionInventairePossible && !tpPossible && !visionCartePossible && !discussionEnCours && !accuserPossible) { // Commande disponibles dans le mode Inventaire
    		
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
    		case "I" : case "INVENTAIRE" : case "RETOUR" :
            	revenirZonePrecedente();
            	permissionInventaire();
    			break;
            case "Q" : case "QUITTER" :
            	for (int i = 0; i <= 25; i++) {
    	        	zones[i].setNomImage("26-EcranQuitter.jpg");
    	        	modifierCarte();
            	}
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                gui.afficher();
                break;
    		}
    		
    	} else if (visionCartePossible && !tpPossible && !visionInventairePossible && !discussionEnCours && !accuserPossible) { // Commandes disponibles dans le mode Carte
    		
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
            case "C" : case "CARTE" : case "RETOUR" :
            	revenirZonePrecedente();
            	permissionCarte();
            	gui.afficher();
            	break;
            case "Q" : case "QUITTER" :
            	for (int i = 0; i <= 25; i++) {
    	        	zones[i].setNomImage("26-EcranQuitter.jpg");
    	        	modifierCarte();
            	}
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                gui.afficher();
                break;
    		}
    		
    	} else if (tpPossible && !visionCartePossible && !visionInventairePossible && !discussionEnCours && !accuserPossible) { //Commandes disponibles dans le mode T�l�porter
    		
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
            		gui.afficher("Tu n'as pas la permission de te t�l�porter la bas, tu dois d'abord trouver la clef ! Esp�ce de tricheur !");
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
            case "TP" : case "TELEPORTATION" : case "RETOUR" :
            	permissionTeleportation();
            	gui.afficher("On arr�te enfin de tricher ?");
            	gui.afficher();
            	break;
            case "Q" : case "QUITTER" :
            	for (int i = 0; i <= 25; i++) {
    	        	zones[i].setNomImage("26-EcranQuitter.jpg");
    	        	modifierCarte();
            	}
            	terminer();
            	break;
           	default : 
                gui.afficher("Commande inconnue");
                break;
            }
    	}
    }

    /**
     * Affiche la description de chaque commande autoris�e
     */
    private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autoris�es sont :");
        gui.afficher();
        gui.afficher(Commande.toutesLesDescriptions().toString());
        gui.afficher();
    }

    /**
     * Changement de la localisation du joueur si la sortie demand�e existe
     * @param direction La sortie demand�e par le joueur
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
    	if(zoneCourante== zones[14] && caveVisitee==false)
    	{
    		caveVisitee=true;
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