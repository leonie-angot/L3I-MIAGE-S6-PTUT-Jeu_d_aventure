package jeu;

/**
 * Nom de Class : Indice.
 *
 * Description : .
 *
 * Version : 2.0.
 *
 * Date : 17/04/2021.
 *
 * @author Léonie A., Sami B., Tarik D., Ylli P.
 */

public abstract class Indice
{

	protected static int numeroIndice = 0;
	protected Zone zoneIndice;
	protected String nomIndice;
	protected String descriptionIndice;
	protected boolean objetRecupere = false;

	/**
	 * Getter de IndiceRecup()
	 * @return l'indice
	 */
	public abstract boolean getIndiceRecup();

	/**
	 * Setter de IndiceRecup()
	 */
	abstract void setIndiceRecup();
}