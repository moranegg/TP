package devoir2;

import java.io.*;

public class Experiences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try { // On rattrape les exceptions (voir le catch en bas)
			// FileOutputStream est une classe de flux (stream) d'octets (byte)
			FileOutputStream f = new FileOutputStream("premierfichier.txt",true);
			for(int i=0;i<10;i=i+1) {
				// i+40 est un entier, il est "castÃ©" en byte automatiquement
				f.write((byte)i+40);
			}
			f.close();

			// FileWriter et FileReader permette d'Ã©crire et lire de caractÃ¨re (char) dans un fichier.
			FileWriter fw = new FileWriter("deuxiemefichier.txt",true);
			fw.write("Coucou. Hello World.\nCeci est un essai.");
			fw.close();

			FileReader fr = new FileReader("deuxiemefichier.txt");
			int d=0;
			d = fr.read();
			// Le type utilisÃ© dans FileReader resp Writer) est int au lieu de char
			// (et les mÃ©thodes retournent -1 quand la fin du
			// fichier est atteinte. Il faut donc caster le int en char au besoin.
			while(d != -1) {
				System.out.print((char)d); // (char)d signifie "valeur de d vue comme un char"
				d = fr.read();
			}
			fr.close();

			// tokenizer: la mÃ©thode nextToken retourne le prochain "token". Un token est un
			// groupe de caratÃ¨res formant un "mot" ou un "nombre" La notion de "mot" Ã©tant
			// dÃ©terminÃ© par les caractÃ¨res dÃ©signÃ© comme sÃ©parateurs de mot (par dÃ©faut,
			// l'espace le retour Ã  la ligne sont des sÃ©parateurs de mots.
			FileReader fr2 = new FileReader("deuxiemefichier.txt");
			StreamTokenizer tok = new StreamTokenizer(fr2);
			System.out.println(tok.TT_WORD);
			tok.whitespaceChars('u', 'u');
			tok.eolIsSignificant(true);
			while(StreamTokenizer.TT_EOF != tok.ttype)
				switch(tok.nextToken()) {
				case StreamTokenizer.TT_WORD: System.out.println("Mot: " + tok.sval); break;
				case StreamTokenizer.TT_NUMBER: System.out.println("Nombre: " + tok.nval); break;
				case StreamTokenizer.TT_EOL: System.out.println("Fin de ligne"); break;
				case StreamTokenizer.TT_EOF: System.out.println("Fin de fichier"); break;
				}

			System.out.println(tok.nextToken() + " " + tok.sval);


		} catch (IOException e) {}
	}

}
