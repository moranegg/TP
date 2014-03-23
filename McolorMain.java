

import javax.swing.JFrame;
import java.awt.Color;

public class McolorMain {

	// Fonction affichant une fenêtre de la couleur demandée et
	// attend la fermeture de cette fenêtre pour terminer.
	public static void afficherCouleur(Color c){
		JFrame jf = new JFrame();
		jf.setSize(500,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Test de couleur, fermez cette fenêtre pour continuer");
		jf.getRootPane().getContentPane().setBackground(c);
		jf.setVisible(true);

	}

	public static void main(String [] args){
		// Tester vos MColor ici.

		// Exemple
		Mcolor c = new Mcolor(100,50,50);
		afficherCouleur(c.getColor());
		c.brighter();
		afficherCouleur(c.getColor());

		// Exemple (fermez la fenêtre qui apparaît pour terminer
		// l'appel de la fonction.):


		afficherCouleur(Color.green);
	}
}
