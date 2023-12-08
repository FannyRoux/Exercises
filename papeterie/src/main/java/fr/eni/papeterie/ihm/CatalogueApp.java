
package fr.eni.papeterie.ihm;

import javax.swing.SwingUtilities;

/**
 * @author Fanny Roux
 */
public class CatalogueApp {
	public static void main(String[] args) {
		
		// on exécute l'écran principal dans un thread spécifique
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				// on créé la fenêtre dans un nouveau thread
				EcranArticle frame = new EcranArticle();
				
				// on affiche la fenête
				frame.setVisible(true);
			}
		});
	}
}
