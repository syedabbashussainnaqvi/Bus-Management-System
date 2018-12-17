
public class User extends Person {

	private String UserName;
	private Integer Password;

	User(String Name, Integer ContactNumber, Integer Age, String Email, String UserName, Integer Password) {
		super(Name, ContactNumber, Age, Email);
		this.UserName = UserName;
		this.Password = Password;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setPassword(Integer Password) {
		this.Password = Password;
	}

	public Integer getPassword() {
		return Password;
	}

	public String toString() {
		return (super.toString() + " UserName:" + this.UserName + " Password:" + this.Password + " ");
	}

}
