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
 * @author L�onie A. et Ylli P.
 */

public class Dialogue extends Indice{
	
	private int numeroDialogue;
	private String dialogueTexte;
	private String dialogueIndice;
	boolean dejaParle;
    private boolean indiceRecup=false;

	public Dialogue(int numeroDialogue, String dialogueTexte){
		this.numeroDialogue = numeroDialogue ;
	    this.dialogueTexte = " | " + dialogueTexte + "\n";
	}
	
	public Dialogue(int numeroDialogue, String dialogueTexte, boolean dejaParle){
		this.numeroDialogue = numeroDialogue ;
	    this.dialogueTexte = " | " + dialogueTexte + "\n";
	    this.dejaParle = dejaParle;
	}
	
	/*
	 * On utilise cette surcharge pour pouvoir creer des Indices qui seront visibles avec la commande [INDICE]
	 */
	public Dialogue(String dialogueIndice) {
		this.dialogueIndice = dialogueIndice;
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
	
	@Override
	public String toString() {
		return "\n" + "(Indice) " + this.dialogueIndice ;
	}
	
	/**
     *@author Ylli P
     */
    public void setIndiceRecup() {
		this.indiceRecup=true;
	}
	public boolean getIndiceRecup()
	{
		return this.indiceRecup;
	}
}