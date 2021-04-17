package jeu;


/**
 * Nom de Class : Objet.
 *
 * Description : Represente les objets à recuperer par le joueur.
 *
 * Version : 2.0.
 *
 * Date : 17/04/2021.
 *
 * @author Léonie A., Sami B., Tarik D., Ylli P.
 */
public class Objet extends Indice
{

    private String nomObjet ;
    private String descriptionObjet ;
    private boolean indiceRecup = false;

    /**
     * Crée un objet dont le nom d'objet, sa description et la zone où il est, sont donnee en parametre.
     * @param nomObjet nom d'objet
     * @param descriptionObjet discription d'objet
     * @param zone zone d'objet
     */
    public Objet(String nomObjet, String descriptionObjet, Zone zone)
    {
        this.nomObjet = nomObjet ;
        this.descriptionObjet = descriptionObjet;
        this.zoneIndice = zone;
    }

    /**
     * Surcharge utilisée pour la création d'indices visibles avec la commande [INDINCE]
     * @param descriptionObjet discription d'objet
     */
    public Objet(String descriptionObjet)
    {
    	this.descriptionObjet = descriptionObjet;
    }

	/**
	 * Renvoie true si l'objet est recuperé
	 * @return un boolean
	 */
	public boolean getObjetRecupere()
	{
		return this.objetRecupere;
	}

	/**
	 * Permet de récupérer le nom de l'Objet
	 * @return le nom de l'Objet
	 */
	public String getNom()
	{
		return this.nomObjet;
	}

	/**
	 * Permet de récupérer la description de l'Objet
	 * @return decription objet
	 */
	public String getDescription()
	{
		return this.descriptionObjet;
	}

	/**
	 * Change la description d'un objet
	 */
	public void setDescriptionObjet(String nouvelleDescription)
	{
		this.descriptionObjet = nouvelleDescription;
	}

	/**
	 * Change l'etat de recuperation d'objet à true
	 */
	public void setObjetRecupere()
	{
		this.objetRecupere = true;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString()
	{
		if (nomObjet == null)
		{
			return "\n" + "(Indice) " + descriptionObjet ;
		}
    	return nomObjet;
    }

    /**
     * Change l'etat de recuperation d'indice à true
     */
    public void setIndiceRecup()
    {
		this.indiceRecup = true;
	}

    /**
     * Renvoie true si l'indice est recuperé, false sinon
     * @return etat de recuperation d'indice
     */
	public boolean getIndiceRecup()
	{
		return this.indiceRecup;
	}
}
