package babysitter;

public class BabysitterKata {

	private static final int EVENING_RATE = 12;
	private static final int BEDTIME_RATE = 8;
	private int amountDue;
	private int startTime;
	private int endTime;
	private int bedtime;

	public BabysitterKata(int startTime, int endTime, int bedtime) {
		this.startTime = topOfTheHour(startTime);
		this.endTime = extendTimeToNextWholeHour(endTime);
		this.bedtime = extendTimeToNextWholeHour(bedtime);
	}

	private int topOfTheHour(int startTime) {
		return startTime - (startTime % 100);
	}

	private int extendTimeToNextWholeHour(int endTime) {
		if (endTime % 100 != 0) {
			endTime = endTime + 100 - (endTime % 100);
		}
		return endTime;
	}

	public int calculateAmountDue() {
		addAmountDuePriorToBedtime();
		addAmountDueAfterBedtime();
		convertFromHundredHoursToHour();
		return amountDue;
	}

	private void convertFromHundredHoursToHour() {
		amountDue /= 100;
	}

	private void addAmountDuePriorToBedtime() {
		if (startTime < bedtime) {
			amountDue += (Math.min(endTime, bedtime) - startTime) * EVENING_RATE;
		}
	}

	private void addAmountDueAfterBedtime() {
		if (endTime > bedtime) {
			amountDue += (endTime - Math.max(startTime, bedtime)) * BEDTIME_RATE;
		}
	}

}
