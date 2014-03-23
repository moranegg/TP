package devoir03.listeners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import devoir03.NavigateurDocumentsApplication;

public class DocumentSelectionListener implements ListSelectionListener {

	private NavigateurDocumentsApplication lecteurDocumentApplication;

	public DocumentSelectionListener(
			NavigateurDocumentsApplication lecteurDocumentApplication) {
		this.lecteurDocumentApplication= lecteurDocumentApplication;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		lecteurDocumentApplication.selectionneDocument();
	    	 // lecteurDocumentApplication.getJLecteur(). getDocumentPourIndexJList().getSelectedIndex();
	    	 // lecteurDocumentApplication.selectionneDocument();
	     
	}

}
