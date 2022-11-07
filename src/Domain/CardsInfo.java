package Domain;

public class CardsInfo {
	private int id;
	private int cvv;
	private int carNumber;
	private int expirationMonth;
	private int expirationDay;
	
	public CardsInfo(int id, int cvv, int carNumber, int expirationMonth, int expirationDay) {
		this.id = id;
		this.cvv = cvv;
		this.carNumber = carNumber;
		this.expirationMonth = expirationMonth;
		this.expirationDay = expirationDay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public int getExpirationDay() {
		return expirationDay;
	}

	public void setExpirationDay(int expirationDay) {
		this.expirationDay = expirationDay;
	}
	

	

}
