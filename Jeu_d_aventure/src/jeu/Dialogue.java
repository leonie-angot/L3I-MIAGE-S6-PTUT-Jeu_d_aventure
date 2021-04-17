package jeu;

/**
 * Nom de Class : Dialogue.
 *
 * Description : Represente les dialogues du jeu
 *
 * Version : 2.0.
 *
 * Date : 17/04/2021.
 *
 * @author Léonie A., Sami B., Tarik D., Ylli P.
 */

public class Dialogue extends Indice
{

	private int numeroDialogue;
	private String dialogueTexte;
	public String dialogueIndice;
	boolean dejaParle;
    private boolean indiceRecup = false;

    /**
     * Crée un dialogue dont le numero du dialogue et le texte de ce dernier sont donnee en parametre.
     * @param numeroDialogue numero du dialogue
     * @param dialogueTexte le texte du dialogue
     */
	public Dialogue(int numeroDialogue, String dialogueTexte)
	{
		this.numeroDialogue = numeroDialogue ;
	    this.dialogueTexte = " | " + dialogueTexte + "\n";
	}

	 /**
     * Crée un dialogue dont le numero du dialogue,le texte et l'etat de ce dernier sont donnee en parametre.
     * @param numeroDialogue numero du dialogue
     * @param dialogueTexte le texte du dialogue
     * @param dejaParle l'etat du dialogue
     */
	public Dialogue(int numeroDialogue, String dialogueTexte, boolean dejaParle)
	{
		this.numeroDialogue = numeroDialogue ;
	    this.dialogueTexte = " | " + dialogueTexte + "\n";
	    this.dejaParle = dejaParle;
	}

	/**
	 * On utilise cette surcharge pour pouvoir creer des Indices qui seront visibles avec la commande [INDICE]
	 * @param dialogueIndice
	 */
	public Dialogue(String dialogueIndice)
	{
		this.dialogueIndice = dialogueIndice;
	}

	/**
	 * Renvoie le numero du dialogue
	 * @return numero du dialogue
	 */
	public int getNumeroDialogue()
	{
		return this.numeroDialogue;
	}

	/**
	 * Renvoie le dialogue
	 * @return texte du dialogue
	 */
	public String getDialogueTexte()
	{
		return this.dialogueTexte;
	}

	/**
	 * Renvoie l'etat du dialogue vaut true si le dialogue est déjà affiché
	 * @return etat dialogue
	 */
	public boolean getDejaParle()
	{
		return this.dejaParle;
	}

	/**
	 * Change l'etat du dialogue au true
	 */
	public void setDejaParle()
	{
		this.dejaParle = true;
	}

	/**
	 * Affiche l'indice du dialogue
	 * @return indice du dialogue
	 */
	@Override
	public String toString()
	{
		return "\n" + "(Indice) " + this.dialogueIndice ;
	}

	/**
     * Change l'etat d'indice à true
     */
    public void setIndiceRecup()
    {
		this.indiceRecup = true;
	}
    /**
     * Renvoie true si l'indice est recuperé
     * @return etat indice
     */
	public boolean getIndiceRecup()
	{
		return this.indiceRecup;
	}
}
