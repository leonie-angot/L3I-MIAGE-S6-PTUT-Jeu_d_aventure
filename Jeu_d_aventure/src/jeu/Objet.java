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
 * @author L�onie A., Sami B., Tarik D. et Ylli P.
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
     * Surcharge utilis�e pour la cr�ation d'indices visibles avec la commande [INDINCE]
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
	 * Permet de r�cup�rer le nom de l'Objet
	 */
	public String getNom() {
		return this.nomObjet;
	}
	
	/*
	 * Permet de r�cup�rer le nom de l'Objet
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