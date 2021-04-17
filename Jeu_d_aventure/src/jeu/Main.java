package jeu;

/**
 * Nom de classe : Main.
 *
 * Description : la classe lanceuse du jeu.
 *
 * Version : 2.0.
 *
 * Date : 17/04/2021.
 *
 * @author Léonie A., Sami B., Tarik D., Ylli P.
 */
public class Main
{
	/**
	 * Cree le jeu avec une inteface utilisataur graphique.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Jeu jeu = new Jeu();
		GUI gui = new GUI(jeu);
		jeu.setGUI(gui);
	}
}
