package co.bohc.diet.domain.service.accessory;

import java.util.List;

import co.bohc.diet.domain.model.Accessory;

public class SaleHistoryOutput {
	private List<Accessory> accessories;
	private List<Accessory> inAccessories;
	private String[] days = new String[7];
	private int[] num = new int[7];
	private int[] inNum = new int[7];

	public List<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}

	public String[] getDays() {
		return days;
	}

	public void setDays(String[] days) {
		this.days = days;
	}

	public int[] getNum() {
		return num;
	}

	public void setNum(int[] num) {
		this.num = num;
	}

	public List<Accessory> getInAccessories() {
		return inAccessories;
	}

	public void setInAccessories(List<Accessory> inAccessories) {
		this.inAccessories = inAccessories;
	}

	public int[] getInNum() {
		return inNum;
	}

	public void setInNum(int[] inNum) {
		this.inNum = inNum;
	}
	
}
