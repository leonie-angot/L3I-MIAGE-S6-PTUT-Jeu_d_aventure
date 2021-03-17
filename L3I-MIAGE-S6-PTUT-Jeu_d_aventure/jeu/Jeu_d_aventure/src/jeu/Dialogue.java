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
	public Dialogue(String q, String rep, Personne r) {
		question = q;
		reponse = rep;
		recepteur = r;
	    idIndice = numeroIndices;
        numeroIndices++;
	}
	
	public String question() {
		return this.question;
	}
	
	public String reponse() {
		return this.reponse;
	}
	
	public String recepteur() {
		return this.recepteur.getName();
	}
	
	public String toString() {
		return "La question : "+question()+" \n "+ recepteur()+ " : "+ reponse() + "\n";
	}
}
