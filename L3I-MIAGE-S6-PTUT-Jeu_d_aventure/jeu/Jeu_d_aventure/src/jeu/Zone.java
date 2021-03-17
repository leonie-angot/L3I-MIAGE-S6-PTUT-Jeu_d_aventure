package jeu;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Nom de Class : Zone.
 * 
 * Description : La Classe Zone est utilisée pour créer une zone avec
 * une description, nom de l'image et ses différentes sorties.
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
    private Personne personne;
    /**
     * Les sorties de notre zone avec un clé de type String représente le nom de la sortie 
     * et une valeur de type Zone représente la zone voisine.
     */
    private HashMap<String,Zone> sorties;   
    public ArrayList<Indices> indices = new ArrayList<Indices>();
    
    public void ajouteIndice(Indices in) {
    	indices.add(in);
    }
    
    public String descriptionIndices()  {
    	String x = "";
    	boolean d = false;
    	boolean o = false;
    	for(int i = 0 ; i < indices.size(); i++) {
    		if(indices.get(i).getClass().equals(Dialogue.class) && d == false) {
    			x += "Parlez ";
    			d = true;
    		}
    		
    		if(indices.get(i).getClass().equals(Objet.class) && o == false) {
    				x += "Recuperez ";
    				o = true;
    		}
    		
    	}
        return "[" + x + "]";
    }
    
    /**
     * Cree une zone dont la description et l'image sont donnee en parametre.
     * Cree une HashMap vide représente les sorties.
     * @param description la description de la zone.
     * @param image l'image de la Zone.
     */ 
    public Zone(String description, String image) {
        this.description = description;
        nomImage = image;
        sorties = new HashMap<>();
        indices = new ArrayList<Indices>();
    }
    
    public Zone(String description, String image, Personne p) {
        this(description, image);
        personne = p;
    }

    

    /**
     * Ajoute une sortie à notre Zone dont la sortie et la zone voisine sont donnee en parametre.
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
     * Renvoie la description et les différentes sorties de la Zone.
     * @return une description longue.
     */
    public String descriptionLongue()  {
        return "Vous Ãªtes dans " + description + "\nSorties : " + sorties();
    }

    /**
     * Renvoie l'ensemble des noms des sorties de la Zone
     * @return les clés representent les noms de la Zone.
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
    
    public Personne getPersonne() {
    	return personne;
    }
}

