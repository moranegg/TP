package devoir2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String [] args) throws IOException{
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.empile(56);
		cal.empile(12);
		System.out.println(cal.toString());
		System.out.println("en haut de la pile"+cal.resultat());
		System.out.println("*********");
		
		
		cal.empile(24);
		cal.empile(39);
		cal.empile(100);
		cal.moins();
		System.out.println("en haut de la pile"+cal.resultat());
		System.out.println(cal.toString());
		
		
		Calculette cal1 = new Calculette(); 
		//cal1.empile(24);
		System.out.println("en haut de la pile"+cal1.resultat());
		System.out.println("*********");
		cal1.div();
		System.out.println(cal1.toString());
		System.out.println("en haut de la pile"+cal1.resultat());
		
		String fich = "demo.txt";
		
		File fichier = new File(fich);
		FileReader read = new FileReader(fichier);
		
		CalcInterpInterface CII = new CalcInterp();
		double d = CII.calcule(read);
		System.out.println("resultat: "+ d);
		System.out.println("************");
		 CalculetteInterface calc = new Calculette();
         calc.empile(324);
         // / [ 324 ]
         System.out.println(calc.toString());
        calc.empile(-23);
         // [ -23, 324 ]
        System.out.println(calc.toString());
        calc.empile(41);
         // [ 41, -23, 324 ]
        System.out.println(calc.toString());
        calc.plus();
         // [ 18, 324 ]
        System.out.println(calc.toString());
        calc.resultat();
         // retourne 18
         // [ 18, 324 ]
        System.out.println(calc.toString());
        calc.moins();
         // [ 306 ] // 324-18
        System.out.println(calc.toString());
        calc.resultat();
         // retourne 306</TD>
         // [ 306 ]</TD>
        System.out.println(calc.toString());
        calc.empile(300);
         // [ 300, 306 ]
        System.out.println(calc.toString());
        calc.moins();
         // [ 6 ]
        System.out.println(calc.toString());
        calc.empile(2);
         // [ 2, 6 ]
        System.out.println(calc.toString());
        calc.div();
         // [ 3 ]
        System.out.println(calc.toString());
        calc.resultat();
         // retourne 3</TD>
        System.out.println(calc.toString());
        calc.mult();
         calc.resultat();
         // [ 0 ] // 0 * 306 nombre manquant = 0</TD>
         System.out.println(calc.toString());	
         System.out.println("************");
         CalculetteInterface calcZr = new Calculette();
	
         calcZr.div();
         System.out.println(calcZr.toString());
         calcZr.plus();
        
         System.out.println(calcZr.toString());
         calcZr.moins();
         System.out.println(calcZr.toString());
         calcZr.mult();
         System.out.println(calcZr.toString());
	
	
	
	}
}
