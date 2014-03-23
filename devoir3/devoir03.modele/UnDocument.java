package devoir03.modele;

/**
 * Une interface dÃ©crivant un document avec un titre (le nom du fichier) et un contenu.
 * @author rosmord
 */
public class UnDocument {

	private String titre;
	private String contenu;

	public UnDocument(String titre, String contenu) {
		this.titre = titre;
		this.contenu = contenu;
	}

	public String getTitre() {
		return titre;
	}

	
	public String getContenu() {
		return contenu;
	}

	
	public String toString() {
		return titre;
	}
}
