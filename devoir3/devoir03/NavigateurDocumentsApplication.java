package devoir03;

import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.ListUI;

import devoir03.listeners.DocumentSelectionListener;
import devoir03.listeners.LireActionListener;
import devoir03.listeners.MotSelectionListener;
import devoir03.listeners.QuitterActionListener;
import devoir03.modele.IndexImplementation;
import devoir03.modele.IndexInterface;
import devoir03.modele.LecteursDeDocuments;
import devoir03.modele.UnDocument;

/**
 * Application. Vous devrez complÃ©ter cette classe.
 * 
 * @author rosmord
 * 
 */
public class NavigateurDocumentsApplication {
	/**
	 * Interface graphique.
	 */
	private InterfaceGraphiqueNavigateur jLecteur = new InterfaceGraphiqueNavigateur();
	/**
	 * index des document choisies
	 */
	private IndexInterface index= new IndexImplementation();
	
	/**
	 * constructeur qui alume l'application
	 */
	public NavigateurDocumentsApplication() {
		creerMenu();
		activer();
		jLecteur.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jLecteur.getFrame().setVisible(true);
	}
	
	/**
	 * active les JLIst et leur MotSelectionListener
	 */
	private void activer() {
		//choix de la list des mot (activation event)
		MotSelectionListener mot =   new MotSelectionListener(this);
		jLecteur.getIndexJList().addListSelectionListener(mot);
		//choix de la list des documents (activation event)
		DocumentSelectionListener doc = new DocumentSelectionListener(this);
		jLecteur.getDocumentPourIndexJList().addListSelectionListener(doc);
		
	}

	/**
	 * CrÃ©e et active les menus.
	 */
	private void creerMenu() {
		JMenu menu = new JMenu("Fichiers");
		JMenuItem lireItem = new JMenuItem("Ouvrir");
		lireItem.addActionListener(new LireActionListener(this));
		JMenuItem quitterItem = new JMenuItem("Quitter");
		quitterItem.addActionListener(new QuitterActionListener(this));
		menu.add(lireItem);
		menu.add(quitterItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		jLecteur.getFrame().setJMenuBar(menuBar);
	}

	/**
	 * Lit le contenu d'un dossier et recopie les donnÃ©es au bons endroits (dans
	 * les listes).
	 * 
	 * @param repertoire
	 */
	public void lire(File repertoire) {
		
		//Ã©tudiez attentivement le code de cette fonction (il fonctionne; il suffit juste de supprimer cette ligne.)
		
		index.effacer();		
		LecteursDeDocuments lecteur = new LecteursDeDocuments(repertoire);
		while (lecteur.aDocument()) {
			UnDocument doc = new UnDocument(
					lecteur.getNomFichier(), lecteur.getContenuFichier());
			index.indexerDocument(doc);
			lecteur.suivant();
		}		
		DefaultListModel model= new DefaultListModel();
		for (String mot: index.getMotsIndexes()) {
			model.addElement(mot);
		}
		// On vide la liste des documents affichÃ©s
		jLecteur.getDocumentPourIndexJList().setModel(new DefaultListModel());
		jLecteur.getIndexJList().setModel(model);
	}
	
	/**
	 * getter de l'interface grafique
	 * @return InterfaceGraphiqueNavigateur
	 */
	public InterfaceGraphiqueNavigateur getInterfaceUtilisateur() {
		return jLecteur;
	}
	
	/**
	 * apres l'activation de  MotSelectionListener, choix d'un document
	 * et renvoie le contenu du document dans le champ texte
	 */
	public void selectionneDocument() {
		try {
			UnDocument d  =(UnDocument) jLecteur.getDocumentPourIndexJList().getSelectedValue();
			jLecteur.getContenuTextArea().setText(d.getContenu());
		} catch (NullPointerException e){
			
		}
		
	}
	
	/**
	 * apres activation de  MotSelectionListener choisi un mot
	 * et renvoie tous les document qui ont ce dans leur texte
	 */
	public void selectionnerMot() {
		String s =(String) jLecteur.getIndexJList().getSelectedValue();
		List<UnDocument> l =index.get(s);
		
		DefaultListModel model= new DefaultListModel();
		for(UnDocument doc: l){
			model.addElement(doc);
		}
		jLecteur.getDocumentPourIndexJList().setModel(model);
		
		
	}
	
	public InterfaceGraphiqueNavigateur getJLecteur(){
		return jLecteur;
	}
}
