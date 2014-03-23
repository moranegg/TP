package devoir03.modele;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndexImplementationTest {

	@Test
	 public void monTest() {
		IndexImplementation id= new IndexImplementation();
		UnDocument d= new UnDocument("d", "");
		id.indexerDocument(d);
		int i = id.getMotsIndexes().size();
		assertEquals(0, i);
	  }
	@Test
	 public void monTest1() {
		IndexImplementation id= new IndexImplementation();
		UnDocument d= new UnDocument("d", "un");
		id.indexerDocument(d);
		int i = id.getMotsIndexes().size();
		assertEquals(1, i);
	  }

	@Test
	 public void monTest2() {
		IndexImplementation id= new IndexImplementation();
		UnDocument d= new UnDocument("d", "un DEUX");
		id.indexerDocument(d);
		
		int i = id.getMotsIndexes().size();
		assertEquals(2, i);
	  }


}
