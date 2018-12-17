
public class Route {
	private String Source;
	private String Destination;
	private String Time;
	private Integer Number;// Route and Bus number are same so that we can easily find out which bus is
							// going on which route.

	Route(Integer Number, String Source, String Destination, String Time) {
		this.Source = Source;
		this.Destination = Destination;
		this.Time = Time;
		this.Number = Number;
	}

	public void setSource(String Source) {

		this.Source = Source;
	}

	public String getSource() {
		return Source;
	}

	public void setDestination(String Destination) {
		this.Destination = Destination;
	}

	public String getDestination() {
		return Destination;
	}

	public void setTime(String Time) {

		this.Time = Time;
	}

	public String getTime() {
		return Time;
	}

	public void setNumber(Integer Number) {
		this.Number = Number;
	}

	public Integer getNumber() {
		return Number;
	}

	public String toString() {
		return (this.Number + "\tSource:" + this.Source + "\tDestination:" + this.Destination + "\tTime:" + this.Time
				+ " ");
	}

}
