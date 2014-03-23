package devoir03;

import javax.swing.SwingUtilities;

/**
 * Classe main. Ne pas toucher. Lance simplement le {@link NavigateurDocumentsApplication}.
 * @author rosmord
 *
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new NavigateurDocumentsApplication();
			}
		});
	}
}
