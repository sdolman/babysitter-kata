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
	
	@Test
	public void whenWorking2HoursBeforeBedtimeThenPay24 () {
		underTest = new BabysitterKata(1700, 1900);
		assertEquals(24, underTest.getAmountDue());
	}
	
	@Test
	public void whenWorking2AndFractionHoursPostEndThenPay36 () {
		underTest = new BabysitterKata(1700, 1915);
		assertEquals(36, underTest.getAmountDue());
	}
	
	@Test
	public void whenWorking2AndFractionHoursPostStartThenPay36 () {
		underTest = new BabysitterKata(1720, 1915);
		assertEquals(36, underTest.getAmountDue());
	}
	

}
