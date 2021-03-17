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
 * @author Tarik D et Sami B
 */
public class Objet extends Indices {
    private String name;
    private String description;

    public Objet(String nom, String d){
        name=nom;
        description=d;
        idIndice = numeroIndices;
        numeroIndices++;
    }

    public String toString() {
    	return "l\'indice numero "+idIndice+" est un "+ name + " sa description est "+ description;
    }
    
}
