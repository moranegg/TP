package devoir03.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import devoir03.NavigateurDocumentsApplication;

public class QuitterActionListener implements ActionListener {

	/**
	 * Ne sert Ã  rien, mais on le garde pour l'uniformitÃ© des actions.
	 */
	private NavigateurDocumentsApplication lecteurDocumentApplication;

	public QuitterActionListener(
			NavigateurDocumentsApplication lecteurDocumentApplication) {
		this.lecteurDocumentApplication= lecteurDocumentApplication;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Quitte l'application (sans rien demander Ã  personne).
		System.exit(0);
	}

}
