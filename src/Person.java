
public class Person {
	private String Name;
	private Integer Age;
	private String Email;
	private Integer ContactNumber;

	Person(String Name, Integer ContactNumber, Integer Age, String Email) {
		this.Name = Name;
		this.ContactNumber = ContactNumber;
		this.Age = Age;
		this.Email = Email;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getEmail() {
		return Email;
	}

	public void setAge(Integer Age) {
		this.Age = Age;
	}

	public Integer getAge() {
		return Age;
	}

	public void setContactNumber(Integer ContactNumber) {
		this.ContactNumber = ContactNumber;
	}

	public Integer getContactNumber() {
		return ContactNumber;
	}

	@Override
	public String toString() {
		return ("Name: " + this.Name + " Age: " + this.Age + " Email; " + this.Email + " Phone:" + this.ContactNumber
				+ " ");
	}
}
