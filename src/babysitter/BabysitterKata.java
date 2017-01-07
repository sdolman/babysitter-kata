package babysitter;

public class BabysitterKata {
	
	private int amountDue;
	private int startTime;
	private int endTime;
	private int bedtime;

	public BabysitterKata(int startTime, int endTime, int bedtime) {
		if(startTime % 100 != 0) {
			startTime = startTime - (startTime % 100);
		}
		this.startTime = startTime;
		if(endTime % 100 != 0) {
			endTime = endTime + 100 - (endTime % 100);
		}
		this.endTime = endTime;
		this.bedtime = bedtime;
	}

	public int getAmountDue() {
		if (endTime <= bedtime) {
		amountDue += (endTime - startTime)/100*12;
		}
		if (endTime > bedtime && startTime >= bedtime) {
			amountDue = (endTime - startTime)/100*8;
		}
		if (endTime > bedtime && startTime < bedtime) {
			amountDue += (bedtime - startTime)/100*12;
			amountDue += (endTime - bedtime)/100*8;
		}
		
		return amountDue;
	}

}
