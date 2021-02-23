package jeu;

/**
 * Nom de classe : Main.
 * 
 * Description : la classe lanceuse du jeu.
 * 
 * Version : 1.0.
 * 
 * Date : 06/02/2021.
 * 
 * @author 
 */
public class Main {
	/**
	 * Cree le jeu avec une inteface utilisataur graphique.
	 * @param args
	 */
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		GUI gui = new GUI( jeu);
		jeu.setGUI( gui);
	}
}