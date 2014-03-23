package devoir2;

import java.util.ArrayList;

/**
 * Cette interface reprÃ©sente une calculatrice en <i>notation polonaise
 * inverse</i>. Elle contient une pile de {@link Double} initialement vide et
 * les opÃ©rations (+,*,*,/) s'effectuent sur les deux valeurs du sommet de la
 * pile.
 * <p>
 * la commande {@link #empile(double)} permet d'ajouter un entier sur la pile et
 * les commandes {@link #plus()}, {@link #moins()}, {@link #mult()} et
 * {@link #div()} permettent d'effectuer des opÃ©rations sur les deux Ã©lÃ©ments au
 * sommet de la pile. La mÃ©thode {@link #toString()} permet d'afficher la pile
 * et la mÃ©thode {@link #resultat()} permet de retourner le rÃ©sultat.
 * <p>
 * Toutes les mÃ©thodes considÃ¨rent qu'un nombre manquant dans la pile est
 * remplacÃ© par zÃ©ro.
 * <p>
 * Exemple de fonctionnement pour une variable {@code calc} de type
 * {@code Calculette extends CalculetteInterface}:
 * 
 * <TABLE BORDER="1" STYLE="display:inline-block;">
 * <CAPTION> Exemple de fonctionnement </CAPTION>
 * <TR>
 * <TH align="center">Instruction</TH>
 * <TH>contenu de la pile de l'objet <code>calc</code> aprÃ¨s l'instruction</TH>
 * </TR>
 * <TR>
 * <TD>CalculetteInterface calc = new Calculette();</TD>
 * <TD>[ ]  // On suppose que la classe Calculette implÃ©mente correctement l'interface CalculetteInterface.</TD>
 * </TR>
 * <TR>
 * <TD>calc.empile(324);</TD>
 * <TD>[ 324 ]</TD>
 * </TR>
 * <TR>
 * <TD>calc.empile(-23);</TD>
 * <TD>[ -23, 324 ]</TD>
 * </TR>
 * <TR>
 * <TD>calc.empile(41);</TD>
 * <TD>[ 41, -23, 324 ]</TD>
 * </TR>
 * <TR>
 * <TD>calc.plus();</TD>
 * <TD>[ 18, 324 ]</TD>
 * </TR>
 * <TR>
 * <TD>calc.resultat() retourne 18</TD>
 * <TD>[ 18, 324 ]</TD>
 * </TR>
 * <TR>
 * <TD>calc.moins();</TD>
 * <TD>[ 306 ] // 324-18 attention au sens de la soustraction ici (idem pour la
 * division)</TD>
 * </TR>
 * <TR>
 * <TD>calc.resultat; retourne 306</TD>
 * <TD>[ 306 ]</TD>
 * </TR>
 * <TR>
 * <TD>calc.mult();</TD>
 * <TD></TD>
 * </TR>
 * <TR>
 * <TD></TD>
 * <TD>[ 0 ] // 0 * 306 nombre manquant = 0</TD>
 * </TR>
 * </TABLE>
 * <p>
 * <b>Vous devez implanter une classe Calculette qui <i>implÃ©mente</i> cette
 * interface.</b>
 * 
 * @author Pierre Courtieu
 * 
 */
public interface CalculetteInterface {

	/**
	 * Effectue l'opÃ©ration d'addition sur les deux nombres au sommet de la
	 * pile. Les deux nombres sont enlevÃ©s de la pile et le rÃ©sultat est empilÃ©
	 * Ã  la place.
	 * <p>
	 * Un nombres manquant sur la pile est automatiquement replacÃ© par zÃ©ro.
	 */
	public abstract void plus();

	/**
	 * Effectue l'opÃ©ration de multiplication sur les deux nombres au sommet de
	 * la pile. Les deux nombres sont enlevÃ©s de la pile et le rÃ©sultat est
	 * empilÃ© Ã  la place.
	 * <p>
	 * Un nombres manquant sur la pile est automatiquement replacÃ© par zÃ©ro.
	 */
	public abstract void mult();

	/**
	 * Effectue l'opÃ©ration de soustraction sur les deux nombres au sommet de la
	 * pile. Les deux nombres sont enlevÃ©s de la pile et le rÃ©sultat est empilÃ©
	 * Ã  la place.
	 * <p>
	 * Un nombres manquant sur la pile est automatiquement replacÃ© par zÃ©ro.
	 */
	public abstract void moins();

	/**
	 * Effectue l'opÃ©ration de division sur les deux nombres au sommet de la
	 * pile. Les deux nombres sont enlevÃ©s de la pile et le rÃ©sultat est empilÃ©
	 * Ã  la place.
	 * <p>
	 * Un nombres manquant sur la pile est automatiquement replacÃ© par zÃ©ro.
	 */
	public abstract void div();

	/**
	 * Effectue l'opÃ©ration d'empilement d'un nombre sur la pile.
	 * <p>
	 * La division par zÃ©ro est autorisÃ©e mais son rÃ©sultat n'est pas prÃ©cisÃ©
	 * (par exemple vous pouvez laisser la division de Java retourner ce qu'elle
	 * veut).
	 */
	public abstract void empile(double n);

	/**
	 * Retourne le sommet de la pile.
	 * 
	 * @return le nombre au sommet de la pile ou zÃ©ro si la pile est vide.
	 * 
	 */
	public abstract double resultat();

	/**
	 * Retourne une chaÃ®ne de caractÃ¨res dÃ©crivant les nombres prÃ©sents dans la
	 * pile. Il est permis d'utiliser la mÃ©thode toString de la classe
	 * {@link ArrayList}. Par exemple si la pile contient les nombre 3 54 et -67
	 * cette mÃ©thode retourne la chaÃ®ne de caractÃ¨res "[3.0, 54.0, -67.0]".
	 * 
	 * @return La chaÃ®ne de carctÃ¨res.
	 */
	public abstract String toString();

}
