package jeu;

/**
 * Nom de Class : Indice.
 * 
 * Description : .
 * 
 * Version : 1.0.
 * 
 * Date : 23/02/2021.
 * 
 * @author Tarik D et Sami B
 */

public abstract class Indice {

	protected static int numeroIndice = 0;
	protected Zone zoneIndice;
	protected String nomIndice;
	protected String descriptionIndice;
	protected boolean objetRecupere = false;
	protected boolean indiceRecup=false;
	abstract protected boolean getIndiceRecup();
	abstract protected void setIndiceRecup();
}
