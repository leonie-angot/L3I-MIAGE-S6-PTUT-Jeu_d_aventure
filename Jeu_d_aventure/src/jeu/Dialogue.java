package jeu;

/**
 * Nom de Class : Dialogue.
 * 
 * Description : .
 * 
 * Version : 1.0.
 * 
 * Date : 16/03/2021.
 * 
 * @author Léonie A. et Ylli P.
 */

public class Dialogue extends Indice{
	
	private int numeroDialogue;
	private String dialogueTexte;
	boolean dejaParle;

	public Dialogue(int numeroDialogue, String dialogueTexte){
		this.numeroDialogue = numeroDialogue ;
	    this.dialogueTexte = " | " + dialogueTexte + "\n";
	}
	
	public Dialogue(int numeroDialogue, String dialogueTexte, boolean dejaParle){
		this.numeroDialogue = numeroDialogue ;
	    this.dialogueTexte = " | " + dialogueTexte + "\n";
	    this.dejaParle = dejaParle;
	}
	
	public int getNumeroDialogue() {
		return this.numeroDialogue;
	}
	
	public String getDialogueTexte() {
		return this.dialogueTexte;
	}
	
	public boolean getDejaParle() {
		return this.dejaParle;
	}
	
	public void setDejaParle() {
		this.dejaParle = true;
	}
	
}
