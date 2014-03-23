package devoir03;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 * Pour Ã©viter d'avoir toutes les mÃ©thodes de frame, et se concentrer sur celles qui nous intÃ©ressent,
 * nous n'hÃ©ritons pas de JFrame, mais nous avons une variable d'instance de type JFrame.
 * @author rosmord
 *
 */
public class InterfaceGraphiqueNavigateur  {
	private JFrame frame= new JFrame("Lecteur");
	private JList indexJList= new JList();
	private JList documentPourIndexJList= new JList();
	private JTextArea contenuTextArea= new JTextArea(40, 80);
	
	public InterfaceGraphiqueNavigateur() {
		indexJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		documentPourIndexJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mettreEnPage();
		contenuTextArea.setEditable(false);
	}

	private void mettreEnPage() {
		JScrollPane liste0panel, liste1panel, docpanel;
		liste0panel= new JScrollPane(indexJList);
		liste1panel= new JScrollPane(documentPourIndexJList);
		docpanel= new JScrollPane(contenuTextArea);
		JSplitPane splitPaneGauche= new JSplitPane(JSplitPane.VERTICAL_SPLIT, liste0panel, liste1panel);
		JSplitPane mainSplitPane= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPaneGauche, docpanel);
		frame.add(mainSplitPane);
		frame.pack();
	}

	/**
	 * Retourne l'Ã©lÃ©ment qui affiche la liste des mots indexÃ©s.
	 * @return
	 */
	public JList getIndexJList() {
		return indexJList;
	}

	/**
	 * Retourne l'Ã©lÃ©ment qui affiche la liste des documents contenant le mot
	 * d'index sÃ©lectionnÃ©.
	 * @return
	 */
	public JList getDocumentPourIndexJList() {
		return documentPourIndexJList;
	}

	/**
	 * L'Ã©lÃ©ment qui affichera le document sÃ©lectionnÃ© Ã  partir de l'index.
	 * @return
	 */
	public JTextArea getContenuTextArea() {
		return contenuTextArea;
	}
	
	/**
	 * Retourne la frame.
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Ne pas utiliser... simplement pour vÃ©rifier l'aspect de l'interface graphique.
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				InterfaceGraphiqueNavigateur l = new InterfaceGraphiqueNavigateur();
				l.getFrame().setVisible(true);
				l.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
	
}
