package babysitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BabysitterKataTest {
	
	BabysitterKata underTest;
	
	@Test
	public void whenWorking5PmTo6PmThenPay12() {
		underTest = new BabysitterKata(1700, 1800);
		assertEquals(12, underTest.getAmountDue());
	}
	

}
