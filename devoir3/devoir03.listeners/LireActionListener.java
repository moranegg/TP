package devoir03.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import devoir03.NavigateurDocumentsApplication;

public class LireActionListener implements ActionListener {

	private NavigateurDocumentsApplication lecteurDocumentApplication;

	public LireActionListener(
			NavigateurDocumentsApplication lecteurDocumentApplication) {
		this.lecteurDocumentApplication= lecteurDocumentApplication;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fileChooser= new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int res= fileChooser.showOpenDialog(lecteurDocumentApplication.getInterfaceUtilisateur().getFrame());
		if (res== JFileChooser.APPROVE_OPTION) {
			File repertoire= fileChooser.getSelectedFile();
			lecteurDocumentApplication.lire(repertoire);			
		}
	}

}
