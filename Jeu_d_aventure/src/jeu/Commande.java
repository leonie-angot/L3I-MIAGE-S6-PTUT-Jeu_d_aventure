package jeu;
import java.util.ArrayList;
import java.util.List;

/**
 * Nom de l'enumeration : Commande.
 * 
 * Description : Represente les commandes permettant de r�aliser des actions, seront
 * utilisable en �crivant s'abreviation dans l�invite de commande.
 * 
 * Version : 1.0.
 * 
 * Date : 06/02/2021.
 * 
 * @author 
 */
public enum Commande {
	NORD("N", "N (aller �  la sortie nord)"), 
	NORDOUEST("N", "NO (aller �  la sortie nord ouest)"),
	NORDEST("N", "NE (aller �  la sortie nord est)"),
	SUD("S", "S (aller �  la sortie sud)"), 
	EST("E", "E (aller �  la sortie est)"), 
	OUEST("O", "O (aller �  la sortie ouest)"),
	TABLEAU("TAB", "TAB (aller au tableau)"),
	TELEPORTATION("TP", "TP (se teleporter)"),
	PARLER("PA", "PA (parler avec un pnj)"),
	PRENDRE("PR", "PR (prendre l'objet)"),
	INVENTAIRE("IV", "I (permet d'afficher l'inventaire"),
	INDICE("ID", "I (permet d'afficher la liste des indices r�cup�r�s"),
	UTILISER("U", "U (utiliser l'objet)"),
	CARTE("C", "C (afficher le plan de la maison"),
	AIDE("?", "? (aide)"), 
	QUITTER("Q", "Q (quitter)");

	private String abreviation;
	private String description;
	
	/**
	 * Cree une �num�ration Commande dont l'abreviation et la description sont donnee en parametre.
	 * @param c l'abr�gement de la commande.
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