package babysitter;

public class BabysitterKata {

	private static final int MORNING_LIMIT = 400;
	private static final int MIDNIGHT = 2400;
	private static final int EVENING_RATE = 12;
	private static final int BEDTIME_RATE = 8;
	private static final int MIDNIGHT_RATE = 16;
	private int amountDue;
	private int startTime;
	private int endTime;
	private int bedtime;

	public BabysitterKata(int startTime, int endTime, int bedtime) {
		startTime = normalizePostMidnight(startTime);
		endTime = normalizePostMidnight(endTime);
		bedtime = normalizePostMidnight(bedtime);
		bedtime = bedtimeMustBeAtOrBeforeMidnight(bedtime);
		this.startTime = topOfTheHour(startTime);
		this.endTime = extendTimeToNextWholeHour(endTime);
		this.bedtime = extendTimeToNextWholeHour(bedtime);
	}

	private int bedtimeMustBeAtOrBeforeMidnight(int bedtime) {
		if (bedtime > MIDNIGHT) {
			bedtime = MIDNIGHT;
		}
		return bedtime;
	}

	private int normalizePostMidnight(int time) {
		if (time <= MORNING_LIMIT) {
			time += MIDNIGHT;
		}
		return time;
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
		addAmountDueAfterMidnight();
		convertFromHundredHoursToHour();
		return amountDue;
	}

	private void addAmountDuePriorToBedtime() {
		if (startTime < bedtime) {
			amountDue += (Math.min(endTime, bedtime) - startTime) * EVENING_RATE;
		}
	}

	private void addAmountDueAfterBedtime() {
		if (endTime >= bedtime) {
			amountDue += (Math.min(endTime, MIDNIGHT) - Math.max(startTime, bedtime)) * BEDTIME_RATE;
		}
	}

	private void addAmountDueAfterMidnight() {
		if (endTime >= MIDNIGHT) {
			amountDue += (endTime - Math.max(startTime, MIDNIGHT)) * MIDNIGHT_RATE;
		}
	}

	private void convertFromHundredHoursToHour() {
		amountDue /= 100;
	}

}
