package jeu;
import java.util.ArrayList;
import java.util.List;

/**
 * Nom de l'enumeration : Commande.
 *
 * Description : Represente les commandes permettant de r�aliser des actions, seront
 * utilisable en �crivant s'abreviation dans l�invite de commande.
 *
 * Version : 2.0.
 *
 * Date : 17/04/2021.
 *
 * @author L�onie A., Sami B., Tarik D., Ylli P.
 */
public enum Commande
{
	NORD("N", "NORD (aller �  la sortie nord)"),
	NORDOUEST("N", "NORD OUEST (aller �  la sortie nord ouest)"),
	NORDEST("N", "NORD EST (aller �  la sortie nord est)"),
	SUD("S", "SUD (aller �  la sortie sud)"),
	EST("E", "EST (aller �  la sortie est)"),
	OUEST("O", "OUEST (aller �  la sortie ouest)"),
	TABLEAU("TAB", "TABLEAU (aller au tableau)"),
	TELEPORTATION("TP", "TELEPORTATION (se teleporter)"),
	PARLER("PA", "PARLER (parler avec un pnj)"),
	PRENDRE("PR", "PRENDRE (prendre l'objet)"),
	INVENTAIRE("IV", "INVENTAIRE (permet d'afficher l'inventaire"),
	INDICE("ID", "INDICE (permet d'afficher la liste des indices r�cup�r�s"),
	UTILISER("U", "UTILISER (utiliser l'objet)"),
	RETOUR("R", "RETOUR (permet de revenir � la zone pr�c�dente ou de sortir des modes ACCUSER ou TP ou CARTE"),
	CARTE("C", "CARTE (afficher le plan de la maison"),
	AIDE("?", "? (aide)"),
	QUITTER("Q", "QUITTER (quitter)");

	private String abreviation;
	private String description;

	/**
	 * Cree une �num�ration Commande dont l'abreviation et la description sont donnee en parametre.
	 * @param c l'abr�gement de la commande.
	 * @param d la description de la commande.
	 */
	Commande(String c, String d)
	{
		abreviation = c;
		description = d;
	}

	/**
	 * Renvoie le nom de la commande
	 * @return name() le nom de la commande
	 */
	@Override
	public String toString()
	{
		return name() + "\n";
	}

	/**
	 * Renvoie la liste des descriptions des commandes existes.
	 * @return La liste des descriptions.
	 */
	public static List<String> toutesLesDescriptions()
	{
		ArrayList<String> resultat = new ArrayList<String>();
		for (Commande c : values())
		{
			resultat.add(c.description);
		}
		return resultat;
	}

	/**
	 * Renvoie la liste des abreviations des commandes existes.
	 * @return La liste des abreviations.
	 */
	public static List<String> toutesLesAbreviations()
	{
		ArrayList<String> resultat = new ArrayList<String>();
		for (Commande c : values())
		{
			resultat.add(c.abreviation);
		}
		return resultat;
	}

	/**
	 * Renvoie la liste des noms des commandes existes.
	 * @return La liste des noms.
	 */
	public static List<String> tousLesNoms()
	{
		ArrayList<String> resultat = new ArrayList<String>();
		for (Commande c : values())
		{
			resultat.add(c.name());
		}
		return resultat;
	}

}
