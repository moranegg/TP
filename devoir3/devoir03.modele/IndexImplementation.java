package devoir03.modele;


import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;





/**
 * contient un HashMap<UnDocument,List<String>> de tous les document
 * et chaque document avec sa liste de string
 * pour trouver facilement tous les mots dans les documents
 * @author Morane
 *
 */
public class IndexImplementation implements IndexInterface {
	HashMap<UnDocument,List<String>> indexes = new HashMap<UnDocument,List<String>>();
	
	/**
	 * prend un mot et renvoie tous les documents associe avec ce mot
	 * @param String
	 * @return List<UnDocument> 
	 */
	@Override
	public List<UnDocument> get(String mot) {
		 List<UnDocument> l = new ArrayList<UnDocument> ();
		 Set<Map.Entry<UnDocument,List<String>>> s = indexes.entrySet();
			Iterator<Map.Entry<UnDocument,List<String>>> it = s.iterator();
			while(it.hasNext()){
				Entry<UnDocument, List<String>> e =it.next();
				List<String> list = e.getValue();
				if(list.contains(mot)){
					l.add(e.getKey());
				}
			}
		 return l;
	}
	
	/**
	 * renvoie tous les mots dans tous les document
	 * en ordre alphabetique et sans doublons
	 * @ return List<String>
	 */
	@Override
	public List<String> getMotsIndexes() {
		 List<String> l = new ArrayList<String> ();
		  for(List<String> list : indexes.values()){
			 for(String s: list){
				 if(!(l.contains(s.trim()))){
					 l.add(s);
				 }
			 }
		 }
		 
		 Collections.sort( l,new OrdreAlphabetiqueMot());
		 return l;
	}
	
	/**
	 * prend un document et l'ajoute dans le hashSet indexes avec sa liste de 
	 * string 
	 * @param UnDocument
	 */
	@Override
	public void indexerDocument(UnDocument document) {
		String contenu = document.getContenu();
		List<String> l = new ArrayList<String> ();
		
		char [] tab =contenu.toCharArray();
		
		for(int i = 0; i<tab.length; ){
			String s = "";
				//boucle qui teste chaque car du contenu
				while((i<tab.length) && (Character.isLetter(tab[i]))){
						s += tab[i];
						i++;
				}
				if (!(s.isEmpty())){ //test si s contient des lettres
						l.add(s);
				}
			
			i++;
		}
		indexes.put(document,l);
		
		
	}
	
	/**
	 * efface toutes les entrees de indexes
	 */
	@Override
	public void effacer() {
		indexes.clear();
	}

	
}


/**
 * class OrdreAlphabetiqueMot pour comparer les mots pour les 
 * organiser avec un ordre alphabetique
 * 
 * @author Morane
 *
 */
class OrdreAlphabetiqueMot implements Comparator<String>{


public int compare(String s1, String s2) {
	
	return s1.compareTo(s2);
}

}
