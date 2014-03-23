package devoir2;

import java.util.ArrayList;

public class Calculette implements CalculetteInterface {
	
	ArrayList <Double> pile = new ArrayList<Double>();
	double premier;
	double deuxieme;
	
	public Calculette(){
		pile = new ArrayList<Double>();
	}
	
	@Override
	public void plus() {
		int i = pile.size();
		if(i>1){
			premier = pile.get(1);
			deuxieme = pile.get(0);
			pile.remove(1);
			pile.remove(0);
			double resultat = (premier+deuxieme);
			pile.add(0,resultat);
			return;
		}
		
		if(i==1){
			premier = pile.get(0);
			pile.remove(0);
			double resultat = (premier+0);
			pile.add(0,resultat);
			return;		
		}
		if(i==0){
			pile.add(0.0);
		}
	}

	@Override
	public void mult() {
		int i = pile.size();

		if(i>1){
			premier = pile.get(1);
			deuxieme = pile.get(0);
			pile.remove(1);
			pile.remove(0);
			double resultat = (premier*deuxieme);
			pile.add(0,resultat);
			return;
		}
	
		
		if(i==1){
			premier = pile.get(0);
			pile.remove(0);
			double resultat = (premier*0);
			pile.add(0,resultat);
			return;	
				
		}
		if(i==0){
			pile.add(0.0);
		}
		
	}

	@Override
	public void moins() {
		int i = pile.size();

		if(i>1){
			premier = pile.get(1);
			deuxieme = pile.get(0);
			pile.remove(1);
			pile.remove(0);
			double resultat = (premier -deuxieme);
			pile.add(0,resultat);
			return;
		}
	
		
		if(i==1){
			premier = pile.get(0);
			pile.remove(0);
			double resultat = (premier-0);
			pile.add(0,resultat);
			return;	
				
		}
		if(i==0){
			pile.add(0.0);
		}
	
	}
	@Override
	public void div() {
		int i = pile.size();
		if(i>1){
			premier = pile.get(1);
			deuxieme = pile.get(0);
			pile.remove(1);
			pile.remove(0);
			double resultat = (premier/deuxieme);
			pile.add(0,resultat);
			return;
		}
	
		
		if(i==1){
			premier = pile.get(0);
			pile.remove(0);
			double resultat = (premier/0.0);
			pile.add(0,resultat);
			return;	
				
		}
		if(i==0){
			pile.add(0.0);
		}
	}

	@Override
	public void empile(double n) {
		pile.add(0,n);
		
	}
	@Override
	public double resultat() {
		if (!pile.isEmpty()){
			
			return( pile.get(0));
		}	
		return 0.0;
	}
	
	public String toString() {
		return (pile.toString());
		
	}
	
}

