package jeu;
import java.util.HashMap;

/**
 * Nom de Class : Zone.
 * 
 * Description : La Classe Zone est utilis�e pour cr�er une zone avec
 * une description, nom de l'image et ses diff�rentes sorties.
 * 
 * Version : 1.0.
 * 
 * Date : 06/02/2021.
 * 
 * @author 
 */
public class Zone 
{
    private String description;
    private String nomImage;
    /**
     * Les sorties de notre zone avec un cl� de type String repr�sente le nom de la sortie 
     * et une valeur de type Zone repr�sente la zone voisine.
     */
    private HashMap<String,Zone> sorties;   

    /**
     * Cree une zone dont la description et l'image sont donnee en parametre.
     * Cree une HashMap vide repr�sente les sorties.
     * @param description la description de la zone.
     * @param image l'image de la Zone.
     */ 
    public Zone(String description, String image) {
        this.description = description;
        nomImage = image;
        sorties = new HashMap<>();
    }

    /**
     * Ajoute une sortie � notre Zone dont la sortie et la zone voisine sont donnee en parametre.
     * @param sortie La sortie.
     * @param zoneVoisine La zone voisine.
     */
    public void ajouteSortie(Sortie sortie, Zone zoneVoisine) {
        sorties.put(sortie.name(), zoneVoisine);
    }

    /**
     * Renvoie le nom de l'image de notre Zone.
     * @return le nom d'image
     */
    public String nomImage() {
        return nomImage;
    }
     
    /**
     * Renvoie la description de notre Zone.
     */
    public String toString() {
        return description;
    }

    /**
     * Renvoie la description et les diff�rentes sorties de la Zone.
     * @return une description longue.
     */
    public String descriptionLongue()  {
        return "Vous �tes dans " + description + "\nSorties : " + sorties();
    }

    /**
     * Renvoie l'ensemble des noms des sorties de la Zone
     * @return les cl�s representent les noms de la Zone.
     */
    private String sorties() {
        return sorties.keySet().toString();
    }

    /**
     * Renvoie la sortie correspond au nom de la sortie donne en parametre
     * @param direction le nom de la sortie
     * @return la sortie de type Zone
     */
    public Zone obtientSortie(String direction) {
    	return sorties.get(direction);
    }
}
