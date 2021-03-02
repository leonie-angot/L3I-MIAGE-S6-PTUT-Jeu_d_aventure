package jeu;

/**
 * Nom de Class : Personne.
 * 
 * Description : .
 * 
 * Version : 1.0.
 * 
 * Date : 23/02/2021.
 * 
 * @author Tarik D et Sami B
 */
public class Personne {
	
	private String namePersonne;
	Objet premierObjet;
	Objet deuxiemeObjet;
	private Zone localisation;
	
	public Personne(String nom, Objet o, Zone l) {
		namePersonne = nom;
		premierObjet = o;
		localisation = l;
	}
	
	
	public Personne(String nom,Zone l, Objet o1, Objet o2) {
		this(nom,o1,l);
		deuxiemeObjet = o2;
	}
	
	public Zone getZone() {
		return localisation;
	}
	
	public String getName() {
		return namePersonne;
	}
}
