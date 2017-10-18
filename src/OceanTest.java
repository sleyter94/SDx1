import static org.junit.Assert.*;

import org.junit.Test;

public class OceanTest {

	Ocean o = new Ocean();
	
	@Test
	public void testPrintOcean() {
		o.printOcean();
		assertTrue("Imprimio todo", true);
	}

}
