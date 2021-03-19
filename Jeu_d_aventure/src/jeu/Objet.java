package jeu;


/**
 * Nom de Class : Objet.
 * 
 * Description : .
 * 
 * Version : 1.0.
 * 
 * Date : 23/02/2021.
 * 
 * @author Léonie A., Sami B., Tarik D. et Ylli P.
 */
public class Objet extends Indice {
	
    private String nomObjet ;
    private String descriptionObjet ;

    /*
     * 
     */
    public Objet(String nomObjet, String descriptionObjet, Zone zone){
        this.nomObjet = nomObjet ;
        this.descriptionObjet = descriptionObjet;
        this.zoneIndice = zone;
    }

    /*
     * Surcharge utilisée pour la création d'indices visibles avec la commande [INDINCE]
     */
    public Objet(String descriptionObjet) {
    	this.descriptionObjet = descriptionObjet;
    }
    
	/*
	 * 
	 */
	public boolean getObjetRecupere() {
		return this.objetRecupere;
	}
	
	/*
	 * Permet de récupérer le nom de l'Objet
	 */
	public String getNom() {
		return this.nomObjet;
	}
	
	/*
	 * Permet de récupérer le nom de l'Objet
	 */
	public String getDescription() {
		return this.descriptionObjet;
	}
	
	/*
	 * 
	 */
	public void setDescriptionObjet(String nouvelleDescription) {
		this.descriptionObjet = nouvelleDescription;
	}
	
	/*
	 * 
	 */
	public void setObjetRecupere() {
		this.objetRecupere = true;
	}
    
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
		if (nomObjet == null) {
			return "\n" + "(Indice) " + descriptionObjet ;
		}
    	return nomObjet;
    }
    
}