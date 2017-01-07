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
		amountDue = (endTime - startTime)/100*12;
		
		return amountDue;
	}

}
