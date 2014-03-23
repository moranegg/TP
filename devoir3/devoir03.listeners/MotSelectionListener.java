package devoir03.listeners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import devoir03.NavigateurDocumentsApplication;

public class MotSelectionListener implements ListSelectionListener {

	private NavigateurDocumentsApplication lecteurDocumentApplication;

	public MotSelectionListener(
			NavigateurDocumentsApplication lecteurDocumentApplication) {
		this.lecteurDocumentApplication= lecteurDocumentApplication;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		 int index =lecteurDocumentApplication.getJLecteur(). getIndexJList().getSelectedIndex();
		 if(index!=-1){
			 lecteurDocumentApplication.selectionnerMot();
		 }
	}

}
