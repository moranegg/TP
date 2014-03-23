package devoir03.modele;

import java.util.List;

/**
 * Cette interface reprÃ©sente l'index (vu en lecture). Vous devrez l'implanter,
 * mais Ã©videmment aussi ajouter les mÃ©thodes nÃ©cessaires pour pouvoir remplir
 * l'index.
 * 
 * @author rosmord
 * 
 */
public interface IndexInterface {
	/**
	 * Renvoie la liste des documents qui contiennent un mot donnÃ©.
	 * <p>
	 * Si le mot n'est pas trouvÃ©, la mÃ©thode doit renvoyer la liste vide.
	 * 
	 * @param mot
	 * @return une liste de documents.
	 */
	List<UnDocument> get(String mot);

	/**
	 * Renvoie la liste des mots qui apparaissent dans l'index.
	 * 
	 * @return
	 */
	List<String> getMotsIndexes();

	/**
	 * Indexe un document.
	 * <p>
	 * Pour l'index : on indexe tous les <em>mots</em> du texte (pas du titre).
	 * <p>
	 * Un mot est dÃ©fini comme une <em>suite de lettres</em> au sens de
	 * {@link Character#isLetter(char)}.
	 * <p>
	 * Par exemple, dans la chaÃ®ne suivante "abc33deux et hop!", on a les mots
	 * "abc", "deux", "et" et "hop".
	 * <p>
	 * Post-condition(s) :
	 * <ol>
	 * <li>les mots dÃ©jÃ  indexÃ©s restent indexÃ©s (on ne doit pas effacer les
	 * valeurs dÃ©jÃ  prÃ©sentes !!!)
	 * <li>aprÃ¨s indexation, tout mot du contenu du document est dans la liste
	 * des mots indexÃ©s renvoyÃ©e par {@link #getMotsIndexes()}.
	 * <li>si un mot apparaÃ®t dans le document d : aprÃ¨s indexation de d,
	 * l'appel Ã  la mÃ©thode {@link #get(String)} doit renvoyer une liste qui
	 * contient le document d.
	 * </ol>
	 * 
	 * <p>
	 * Remarque : il est assez probable que nos tests vÃ©rifient que les
	 * post-conditions sont respectÃ©es.
	 * 
	 * @param document
	 */
	void indexerDocument(UnDocument document);

	/**
	 * Efface le contenu de l'index.
	 * <p>
	 * Post condition : l'index est vide, {@link #getMotsIndexes()} renvoie la
	 * liste vide, et {@link #get(String)} renvoie la liste vide pour tout mot.
	 * 
	 */

	void effacer();

}
