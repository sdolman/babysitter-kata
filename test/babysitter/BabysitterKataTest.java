package babysitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BabysitterKataTest {
	
	BabysitterKata underTest;
	
	@Test
	public void whenWorking5PmTo6PmThenPay12() {
		underTest = new BabysitterKata(1700, 1800, 2000);
		assertEquals(12, underTest.calculateAmountDue());
	}
	
	@Test
	public void whenWorking2HoursBeforeBedtimeThenPay24 () {
		underTest = new BabysitterKata(1700, 1900, 2000);
		assertEquals(24, underTest.calculateAmountDue());
	}
	
	@Test
	public void whenWorking2AndFractionHoursPostEndThenPay36 () {
		underTest = new BabysitterKata(1700, 1915, 2000);
		assertEquals(36, underTest.calculateAmountDue());
	}
	
	@Test
	public void whenWorking1AndFractionHoursPostStartAndPostEndThenPay36 () {
		underTest = new BabysitterKata(1720, 1915, 2000);
		assertEquals(36, underTest.calculateAmountDue());
	}
	
	@Test
	public void whenWorking1HourAfterBedtimeThenPay8() {
		underTest = new BabysitterKata(2000, 2100, 2000);
		assertEquals(8, underTest.calculateAmountDue());
	}
	
	@Test
	public void whenWorking1HourBeforeBedtimeAnd2HoursAfterThenPay28() {
		underTest = new BabysitterKata(1900, 2200, 2000);
		assertEquals(28, underTest.calculateAmountDue());
	}
	
	@Test
	public void shouldPayFullHourOfRegularRateIfBedtimeIsNotOnTheHour() {
		underTest = new BabysitterKata(1900, 2200, 2030);
		assertEquals(32, underTest.calculateAmountDue());
	}

}
