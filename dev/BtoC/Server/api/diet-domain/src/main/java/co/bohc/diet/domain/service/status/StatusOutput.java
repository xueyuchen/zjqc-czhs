package co.bohc.diet.domain.service.status;

public class StatusOutput {

	private String[] days = new String[7];
	private int[] toIn = new int[7];
	private int[] toFix = new int[7];
	private int[] toFinish = new int[7];

	public String[] getDays() {
		return days;
	}

	public void setDays(String[] days) {
		this.days = days;
	}

	public int[] getToIn() {
		return toIn;
	}

	public void setToIn(int[] toIn) {
		this.toIn = toIn;
	}

	public int[] getToFix() {
		return toFix;
	}

	public void setToFix(int[] toFix) {
		this.toFix = toFix;
	}

	public int[] getToFinish() {
		return toFinish;
	}

	public void setToFinish(int[] toFinish) {
		this.toFinish = toFinish;
	}

}
