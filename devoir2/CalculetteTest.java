package devoir2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculetteTest {

	@Test
	public void testEmiple() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		assertTrue(cal.resultat() == 24 );
	}
	
	@Test
	public void testEmiple2() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.empile(39);
		assertTrue(cal.resultat() == 39 );
	}
	
	@Test
	public void testEmiple3() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.empile(39);
		cal.empile(65.8);
		assertTrue(cal.resultat() ==65.8 );
	}
	
	@Test
	public void testEmipleVide() {
		Calculette cal = new Calculette(); 
		
		assertTrue(cal.resultat() == 0 );
	}
	
	@Test
	public void testMult() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.empile(39);
		cal.mult();
		assertTrue(cal.resultat() == 936 );
	}
	@Test
	public void testMult2() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.empile(39);
		cal.empile(1);
		cal.mult();
		assertTrue(cal.resultat() == 39 );
	}
	@Test
	public void testMult3() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.mult();
		assertTrue(cal.resultat() == 0 );
	}
	@Test
	public void testMultVide() {
		Calculette cal = new Calculette(); 
		cal.mult();
		assertTrue(cal.resultat() == 0 );
	}
	@Test
	public void testPlustVide() {
		Calculette cal = new Calculette(); 
		cal.plus();
		assertTrue(cal.resultat() == 0 );
	}
	@Test
	public void testPlus() {
		Calculette cal = new Calculette();
		cal.empile(24);
		cal.empile(39);
		cal.plus();
		assertTrue(cal.resultat() == 63 );
	}
	@Test
	public void testPlus1() {
		Calculette cal = new Calculette();
		cal.empile(24);
		cal.empile(39);
		cal.empile(1);
		cal.plus();
		assertTrue(cal.resultat() == 40 );
	}
	public void testPlus2() {
		Calculette cal = new Calculette();
		cal.empile(24);
		cal.empile(39);
		cal.empile(0);
		cal.plus();
		assertTrue(cal.resultat() == 39 );
	}
	@Test
	public void testPlus3() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.plus();
		assertTrue(cal.resultat() == 24 );
	}
	
	@Test
	public void testMoins() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.moins();
		assertTrue(cal.resultat() == 24 );
	}
	@Test
	public void testMoins1() {
		Calculette cal = new Calculette(); 
		cal.empile(24);
		cal.empile(2);
		cal.moins();
		assertTrue(cal.resultat() == 22 );
	}
	@Test
	public void testMoinsVide() {
		Calculette cal = new Calculette(); 
		
		cal.moins();
		assertTrue(cal.resultat() == 0 );
	}
	@Test
	public void testMoins3() {
		Calculette cal = new Calculette();
		cal.empile(24);
		cal.empile(39);
		cal.empile(100);
		cal.moins();
		assertTrue(cal.resultat() == -61 );
	}
	@Test
	public void testDivVide() {
		Calculette cal = new Calculette();
		
		cal.div();
		assertTrue(cal.resultat() == 0 );
	}
	@Test
	public void testDiv() {
		Calculette cal = new Calculette();
		cal.empile(24);
		
		cal.div();							//dision par 0 impossible
		assertTrue(cal.resultat() == Double.POSITIVE_INFINITY ); //on n'effectue pas la division
	}
	public void testDiv1() {
		Calculette cal = new Calculette();
		cal.empile(16);
		cal.empile(4);
		
		cal.div();
		assertTrue(cal.resultat() == 4 );
	}
	@Test
	public void testDiv2() {
		Calculette cal = new Calculette();
		cal.empile(24);
		cal.empile(200);
		cal.empile(100);
		cal.div();
		assertTrue(cal.resultat() == 2 );
	}
}
