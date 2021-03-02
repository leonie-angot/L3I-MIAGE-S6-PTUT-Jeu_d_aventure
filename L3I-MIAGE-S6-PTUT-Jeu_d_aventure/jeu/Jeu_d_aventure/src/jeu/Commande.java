package jeu;
import java.util.ArrayList;
import java.util.List;

/**
 * Nom de l'enumeration : Commande.
 * 
 * Description : Represente les commandes permettant de réaliser des actions, seront
 * utilisable en écrivant s'abreviation dans l’invite de commande.
 * 
 * Version : 1.0.
 * 
 * Date : 06/02/2021.
 * 
 * @author 
 */
public enum Commande {
	NORD("N", "N (aller Ã  la sortie nord)"), 
	NORDOUEST("N", "NO (aller Ã  la sortie nord ouest)"),
	NORDEST("N", "NE (aller Ã  la sortie nord est)"),
	SUD("S", "S (aller Ã  la sortie sud)"), 
	EST("E", "E (aller Ã  la sortie est)"), 
	OUEST("O", "O (aller Ã  la sortie ouest)"),
	TABLEAU("N", "T (aller au tableau)"),
	INVENTAIRE("I", "I (afficher votre inventaire)"),
	RECUPERER("R", "R (recuperer l\'objet)"),
	PARLER("P", "P (parler avec la personne)"),
	AIDE("?", "? (aide)"), 
	QUITTER("Q", "Q (quitter)");

	private String abreviation;
	private String description;
	
	/**
	 * Cree une énumération Commande dont l'abreviation et la description sont donnee en parametre.
	 * @param c l'abrégement de la commande.
	 * @param d la description de la commande.
	 */
	private Commande(String c, String d ) { 
		abreviation = c;
		description = d; 
	}
	
	/**
	 * Renvoie le nom de la commande
	 * @return name() le nom de la commande
	 */
	@Override
	public String toString() { 
		return name();
	}
	
	/**
	 * Renvoie la liste des descriptions des commandes existes.
	 * @return La liste des descriptions.
	 */
	public static List<String> toutesLesDescriptions() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.description);
		}
		return resultat;
	}
	
	/**
	 * Renvoie la liste des abreviations des commandes existes.
	 * @return La liste des abreviations.
	 */
	public static List<String> toutesLesAbreviations() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.abreviation);
		}
		return resultat;
	}
	
	/**
	 * Renvoie la liste des noms des commandes existes.
	 * @return La liste des noms.
	 */
	public static List<String> tousLesNoms() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.name());
		}
		return resultat;
	}

}
