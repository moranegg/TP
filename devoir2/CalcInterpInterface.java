package devoir2;

import java.io.IOException;
import java.io.Reader;

/**
 * Interface de lecture d'un fichier contenant des opÃ©rations de la calculatrice
 * en notation polonaise inverse. Cette classe contient une unique mÃ©thode
 * permettant de lire les opÃ©rations Ã  exÃ©cuter dans un fichier.
 * 
 * Vous devez Ã©crire une classe CalcInterp implantant cette interface. Pour cela
 * vous devez bien entendu utiliser la classe {@code Calculette} implantant
 * l'interface {@link CalcInterpInterface} que vous aurez Ã©crit au prÃ©alable.
 * 
 * @author Pierre courtieu
 * 
 */
public interface CalcInterpInterface {

	/**
	 * {@code calcule(f)} exÃ©cute les commandes contenues dans le {@link Reader}
	 * {@code f} et retourne le rÃ©sultat final.
	 * <p>
	 * Le rÃ©sultat final est le contenu du sommet de la pile aprÃ¨s avoir
	 * effectuÃ© toutes les opÃ©rations contenues dans {@code f}.
	 * <p>
	 * Les commandes (nombres et opÃ©rateurs) sont sÃ©parÃ©es par un ou plusieurs
	 * espaces et/ou des sauts de ligne.
	 * <p>
	 * Les parties incorrectes du fichier sont ignorÃ©es.
	 * <p>
	 * Exemple de contenu de {@code f}:
	 * <p>
	 * <pre>
	 * "
	 * 234    45
	 * 
	 * +   11   31  + /
	 * "
	 * </pre>
	 * <p>
	 * 
	 * RÃ©sultat rendu par la mÃ©thode: 235,07143 (c'est-Ã -dire: (234 + 45) / (11
	 * + 31)
	 * 
	 * 
	 * 
	 * 
	 * @param f
	 *            Le reader Ã  lire (par exemple un FileReader).
	 * @return le sommet de la pile de la calculette aprÃ¨s interprÃ©tation de
	 *         tout le fichier
	 * @throws IOException
	 *             Si une erreur d'entrÃ©e sortie a lieu.
	 */
	public abstract double calcule(Reader f) throws IOException;

}
