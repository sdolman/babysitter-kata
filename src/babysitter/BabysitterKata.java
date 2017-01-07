package babysitter;

public class BabysitterKata {
	
	private int amountDue;
	private int startTime;
	private int endTime;

	public BabysitterKata(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getAmountDue() {
		amountDue = (endTime - startTime)/100*12;
		return amountDue;
	}

}
