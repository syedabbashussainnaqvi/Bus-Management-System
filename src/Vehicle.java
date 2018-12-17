
public class Vehicle {

	private Integer Number;
	// private String Company;

	Vehicle(Integer Number) {
		this.Number = Number;
		// this.Company = Company;
	}

	public void setNumber(Integer Number) {
		this.Number = Number;
	}

	public Integer getNumber() {
		return Number;
	}

	/*
	 * public void setCompany(String Company) { this.Company = Company; }
	 * 
	 * public String getCompany() { return Company; }
	 */

	public String toString() {
		return ("BusId:" + this.Number + " ");
	}

}
