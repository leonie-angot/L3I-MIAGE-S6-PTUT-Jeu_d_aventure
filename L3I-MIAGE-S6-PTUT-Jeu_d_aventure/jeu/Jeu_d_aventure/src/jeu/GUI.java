package jeu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;


/**
 * Nom de classe : GUI.
 * 
 * Description : La classe GUI est utilis�e pour creer un interface utilisateur graphique.
 * 
 * Version : 1.0.
 * 
 * Date : 06/02/2021.
 * 
 * @author 
 */
public class GUI implements ActionListener
{
	private Jeu jeu;
	
    /**
     * Fen�tre principale qui poss�de un titre, une taille modifiable et �ventuellement un menu.
     */
    private JFrame fenetre;
    
    /**
     * Zone d'�dition de texte comportant une seule ligne.
     */
    private JTextField entree;
    
    /**
     * Composant qui permet la saisie en mode multiligne de texte simple.
     */
    private JTextArea texte;
    
    /**
     * Composant qui est capable d'afficher du texte aussi que une image.
     */
    private JLabel image;

    /**
     * Cr�e un Interface utilisateur graphique pour le jeu donnee en parametre.
     * @param j de type Jeu
     */
    public GUI(Jeu j) 
    {
        jeu = j;
        creerGUI();
    }

    /**
     * Ajoute de text donnee au parametre et d�placer le curseur 
     * dans le texte � la position pr�cis� en param�tre de la fonction setCaretPosition
     * @param s chaine de caractere � afficher 
     */
    public void afficher(String s) 
    {
        texte.append(s);
        texte.setCaretPosition(texte.getDocument().getLength());
    }
    
    /**
     * Retour � la ligne
     */
    public void afficher() {
        afficher("\n");
    }

    /**
     * Affiche l'image donnee en parametre.
     * @param nomImage de type String represente le nom de l'image.
     */
   public void afficheImage( String nomImage) 
   {
	   	URL imageURL = this.getClass().getClassLoader().getResource("jeu/images/" + nomImage);
	   	if( imageURL != null ) 
	   	{
        	image.setIcon( new ImageIcon( imageURL ));
            fenetre.pack();
        }
   }

   /**
    * Pr�cise si les donn�es du composant sont �ditables ou non.
    * Arr�te le curseur de clignoter si le parametre ok est false.
    * @param ok de type boolean
    */
    public void enable(boolean ok) {
        entree.setEditable(ok);
        if ( ! ok )
            entree.getCaret().setBlinkRate(0);
    }

    /**
     * Cree l'interface utilisateur graphique.
     */
    private void creerGUI() {
        fenetre = new JFrame("Jeu");
        
        entree = new JTextField(34);

        texte = new JTextArea();
        texte.setEditable(false);
        JScrollPane listScroller = new JScrollPane(texte);
        listScroller.setPreferredSize(new Dimension(200, 200));
        listScroller.setMinimumSize(new Dimension(100,100));

        JPanel panel = new JPanel();
        image = new JLabel();

        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entree, BorderLayout.SOUTH);

        fenetre.getContentPane().add(panel, BorderLayout.CENTER);
        
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        entree.addActionListener(this);

        fenetre.pack();
        fenetre.setVisible(true);
        entree.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        executerCommande();
    }

    /**
     * Executer la commande lue dans la zone text.
     */
    private void executerCommande() {
        String commandeLue = entree.getText();
        entree.setText("");
        jeu.traiterCommande( commandeLue);
    }
    
    /** 
     * Permet de simuler l'action d'un utilisateur cot� machine, c'est la machine qui l'ex�cute au lieu de l'utilisateur
     * @param String s le texte extrait du fichier
     */
    public void executerCommande(String s)
    {
        entree.setText(s);
        String commandeLue = entree.getText();
        entree.setText("");
        jeu.traiterCommande(commandeLue);
    }
}