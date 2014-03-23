package devoir2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CalcInterp implements CalcInterpInterface {
	
	CalculetteInterface calc;
	ArrayList<Character> chiffre = new ArrayList<Character>();

	@Override
	public double calcule(Reader f) throws IOException {
		chiffre.clear();
		
		calc = new Calculette();
		System.out.println("-----");
		
		int d = f.read();
		while(d != -1) {
			 System.out.println("le num ascii:" +d);
			 
			 if(d>=48 && d<=57 ){
				 chiffre.add((char)d);
			 
			 } else  {
			 
				 String s = "";
				
				 for (char c : chiffre){
					 s += c;
				 }// fin for
				 
				 chiffre.clear();
				 
				 if(!s.isEmpty()){
					 double numAempiler = Double.parseDouble(s);
					 calc.empile(numAempiler);
				 }
				 
				 switch (d){
					 case 43://+
						 calc.plus();
						 
						 break;
					 case 42://*
						 calc.mult();
						 
						 break;
					 case 45://-
						 calc.moins();
						 
						 break;
					 case 47:// div
						 calc.div();
						 
						 break;
					 
				 
				 }//fin switch
			 
				
			}//fin else if
			
			 d = f.read();
		
		}// fin while
		
		if(!chiffre.isEmpty()){
			String s = "";
			
			 for (char c : chiffre){
				 s += c;
			 }// fin for
			 
			 chiffre.clear();
			 
			 if(!s.isEmpty()){
				 double numAempiler = Double.parseDouble(s);
				 calc.empile(numAempiler);
			 }//fin if
		}//fin if
		f.close();
		
		return calc.resultat();
	}
}
