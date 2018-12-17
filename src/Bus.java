
public class Bus extends Vehicle {

	private Integer FrontSeat = 7;
	private Integer MiddleSeat = 7;
	private Integer BackSeat = 7;

	Bus(Integer Number, Integer FrontSeat, Integer MiddleSeat, Integer BackSeat) {
		super(Number);
		this.FrontSeat = FrontSeat;
		this.MiddleSeat = MiddleSeat;
		this.BackSeat = BackSeat;
	}

	public void setFrontSeat(Integer FrontSeat) {
		this.FrontSeat = FrontSeat;
	}

	public Integer getFrontSeat() {
		return this.FrontSeat;
	}

	public void setMiddelSeat(Integer MiddleSeat) {
		this.MiddleSeat = MiddleSeat;
	}

	public Integer getMiddleSeat() {
		return MiddleSeat;
	}

	public void setBackSeat(Integer BackSeat) {
		this.BackSeat = BackSeat;
	}

	public Integer getBackSeat() {
		return this.BackSeat;
	}

	public String toString() {
		return (super.toString() + "\nSeats Available at the Front: " + this.FrontSeat
				+ "\nSeats Available at the Middle: " + this.MiddleSeat + "\nSeats Available at the Back: "
				+ this.BackSeat + " ");
	}

}
