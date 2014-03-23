package devoir03.modele;

import java.io.*;

/**
 * Classe d'entrÃ©es/sortie : lit les documents textes (.txt) dans le dossier
 * passÃ© en argument au constructeur. Les fichiers sont supposÃ©s Ãªtre dans le
 * codage du systÃ¨me (vous trouverez avec le projet un ensemble de fichiers
 * codÃ©s en ASCII, qui passent partout).
 * <p>
 * ATTENTION: pour ce devoir, on demande explicitement de stocker les documents
 * en mÃ©moire.
 * <p>
 * Le lecteur de document ne doit Ãªtre utilisÃ© qu'une seule fois.
 * 
 * <p>
 * Boucle de lecture :
 * 
 * <pre>
 * LecteurDeDocuments l = new LecteurDeDocuments(&quot;monDossier&quot;);
 * while (l.aDocument()) {
 * 	String nom = l.getNomFichier();
 * 	String contenu = l.getContenuFichier();
 * ... votre code...
 * 	l.suivant();
 * }
 * </pre>
 * 
 * @author rosmord
 */
public class LecteursDeDocuments {

	File[] documents;
	String contenuDocumentCourant;
	/**
	 * Position du document courant dans la liste. -1 : pas encore sur un
	 * document.
	 */
	int position;

	/**
	 * Construit un lecteur de documents qui va rÃ©cupÃ©rer les documents textes
	 * dans le dossier <code>dossier</dossier>
	 * 
	 * @param dossier
	 *            le dossier oÃ¹ se trouvent les documents.
	 */
	public LecteursDeDocuments(File dossier) {
		documents = dossier.listFiles(new FiltreTxt());
		position = 0;
		lirePremierDocumentDisponible();
	}

	/**
	 * Renvoie vrai s'il y a un document Ã  consulter.
	 * 
	 * @return un boolÃ©en.
	 */
	public boolean aDocument() {
		return 0 <= position && position < documents.length;
	}

	/**
	 * Avance au prochain document.
	 * <p>
	 * Si on Ã©tait sur le dernier document, cette mÃ©thode n'Ã©choue pas, mais,
	 * par la suite, {@link #aDocument()} renverra false.
	 * <p>
	 * Postcondition : on est sur un nouveau document, ou {@link #aDocument()}
	 * vaut false.
	 */

	public void suivant() {
		position++;
		lirePremierDocumentDisponible();
	}

	/**
	 * Se place, si possible, sur le premier document lisible Ã  partir de la
	 * position courante.
	 */
	private void lirePremierDocumentDisponible() {
		boolean aFaire = true;
		// On va avancer jusqu'Ã  trouver un document qui soit lisible, ou Ã  Ãªtre
		// sorti
		// de la liste des documents.
		while (aFaire && position < documents.length) {
			// Si on est sur un document, on essaie de le lire:
			try {
				// Le lecteur (on lit ligne par ligne, 
				// en ajoutant le changement de lignes "unix").
				BufferedReader reader = new BufferedReader(new FileReader(
						documents[position]));
				// Pour concatÃ©ner efficacement des strings on utilise
				// des StringBuilder.
				// Je voulais faire du code simple et lisible,
				// mais avec de la concatÃ©nation de Strings normale,
				// la lecture du fichier d'exemple prend 5 secondes.
				//
				StringBuilder contenu = new StringBuilder();
				String ligne= reader.readLine();
				while (ligne != null) {
					contenu.append(ligne + "\n");
					ligne= reader.readLine();
				}
				// close se fait normalement de maniÃ¨re plus parano,
				// mais je reste simple.
				reader.close();
				contenuDocumentCourant = contenu.toString();
				// Si on arrive ici, on a le contenu,
				// on a lu un document, et on s'arrÃªte.
				aFaire = false;
			} catch (IOException e) {
				// On a Ã©chouÃ© (par exemple ce document n'est pas lisible - ce
				// qui ne devrait pas arriver dans notre application).
				// On essaie le suivant:
				position++;
			}
		}
	}

	/**
	 * Retourne le nom du document courant.
	 * <p>
	 * PrÃ©condition : {@link #aDocument()} == true.
	 * 
	 * @return le document courant
	 * @throws IllegalStateException
	 *             si la prÃ©condition n'est pas respectÃ©e.
	 */
	public String getNomFichier() {
		if (!aDocument())
			throw new IllegalStateException("plus de documents");
		return documents[position].getName();
	}

	public String getContenuFichier() {
		if (!aDocument())
			throw new IllegalStateException("plus de documents");
		return contenuDocumentCourant;
	}

	/**
	 * Filtre utilisÃ© pour ne lire que les documents textes.
	 * 
	 * @author rosmord
	 * 
	 */
	private static class FiltreTxt implements FilenameFilter {
		@Override
		public boolean accept(File file, String name) {
			File subFile = new File(file, name);
			return name.endsWith(".txt") && subFile.canRead()
					&& subFile.isFile();
		}
	}

}
