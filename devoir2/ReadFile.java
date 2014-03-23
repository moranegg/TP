package devoir2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class ReadFile {
	

		File f;
		Reader r;
		ArrayList<String> aCalculer = new ArrayList<String>();

		public ReadFile(File fichier){
			try {
				f = fichier;
				InputStream ips = new FileInputStream(f);
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);
				String ligne;
				while ((ligne = br.readLine()) != null) {
	
					aCalculer.add(ligne);
	
				}
				br.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		public void afficherStream(){
	
			for (String s : aCalculer) {
				System.out.println(s);
			}
		}

	
}
