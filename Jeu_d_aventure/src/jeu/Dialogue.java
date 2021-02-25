package jeu;


/**
 * Nom de Class : Dialogue.
 * 
 * Description : .
 * 
 * Version : 1.0.
 * 
 * Date : 23/02/2021.
 * 
 * @author Tarik D et Sami B
 */
public class Dialogue extends Indices{

	private String question;
	private String reponse;
	
	private Personne recepteur;
	
	//Essayez avec StringBuilder
	public Dialogue(String q, String rep, Personne r, Zone z) {
		question = q;
		reponse = rep;
		recepteur = r;
		zoneIndice = z;
	    idIndice = numeroIndices;
        numeroIndices++;
	}
	
	public String question() {
		return this.question;
	}
	
	public String reponse() {
		return this.reponse;
	}
	
	public Personne recepteur() {
		return this.recepteur;
	}
	
	public String toString() {
		return "J'ai posé la question : "+question()+" à "+ recepteur()+ " et il m'a repondu : "+ reponse();
	}
}