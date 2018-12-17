import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	protected static Scanner input;
	protected static boolean Exit = true;
	protected static Integer Choice;
	protected static Integer Seat;
	protected static String Name;
	protected static String UserName;
	protected static Integer Age;
	protected static String Email;
	protected static Integer ContactNumber;
	protected static Integer Password;
	protected static ArrayList<Route> list = new ArrayList<Route>();
	protected static ArrayList<User> Userlist = new ArrayList<User>();
	protected static ArrayList<Bus> Buslist = new ArrayList<Bus>();
	protected static Integer BusNumber;
	protected static Integer Location;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("-------------------------------------");
		System.out.println("***** Welcome to Bilal Daewoo  *****");
		System.out.println("-------------------------------------\n");
		ExistingUser();
		BusData();
		System.out.println("Press 1 to SignIn");
		System.out.println("Press 2 to Register");
		System.out.println();

		while (Exit) {
			Choice = input.nextInt();

			if (Choice == 1) {
				boolean check = true;
				boolean exception = true;
				boolean exception2 = true;
				while (check) {

					exception = true;

					/*
					 * This while loop will check if user has entered a username or password in
					 * correct form. If not then it will tell the user and ask him to enter again.
					 */
					while (exception) {
						try {

							System.out.print("\nEnter UserName: ");
							UserName = input.next();

							System.out.print("Enter Password: ");
							Password = input.nextInt();

							exception = false;
						} catch (InputMismatchException exceptions) {

							System.out.println("\nPlease enter UserName as a string and Password as Integer.\n");

							/*
							 * new piece of code which parses the wrong input and clears the scanner for new
							 * input
							 */

							input.next();

							continue;
						}
					}
					/*
					 * for (int i = 0; i < Userlist.size(); i++) {
					 * System.out.println(Userlist.get(i).toString()); }
					 */

					// System.out.println("user list size " + Userlist.size());

					/*
					 * System.out.println("List password :" + Userlist.get(1).getPassword() +
					 * "  UserName " + Userlist.get(1).getUserName());
					 */

					for (int i = 0; i < Userlist.size(); i++) {

						/*
						 * System.out.println(i); System.out.println("Password enter : " + Password +
						 * "  UserName  " + UserName);
						 */

						/*
						 * System.out.println("List password :" + Userlist.get(i).getPassword() +
						 * "  UserName " + Userlist.get(i).getUserName());
						 */

						/* Authentication */

						if (Userlist.get(i).getPassword().equals(Password)
								&& Userlist.get(i).getUserName().equals(UserName)) {

							System.out.println("\nYou are Successfully Loggedin.\n");

							System.out.println("Bus Timings.\n");

							PossibleRoutes();

							/* Printing All possible routes */
							for (int j = 0; j < 15; j++) {
								System.out.println(list.get(j).toString());
							}

							/*
							 * Here I am doing exception handling to prevent user from entering string. If
							 * he enter a string then I asked him again to enter value without crashing
							 * program
							 */

							while (exception2) {

								try {

									System.out.println("\nPress from 1 to 15 to select the route ");
									System.out.println("Press 16 to Cancel Booking");

									Choice = input.nextInt();

									/*
									 * Assigning false to exception2 to go out of the while loop. If this statement
									 * runs it means user ha correctly entered value
									 */
									exception2 = false;

								} catch (InputMismatchException exceptions) {

									System.out.println("\nPlease enter Integer string is not allowed.\n");

									/*
									 * new piece of code which parses the wrong input and clears the scanner for new
									 * input
									 */

									input.next();

									continue;
								}
							}

							if (Choice >= 1 && Choice <= 15) {

								System.out.println(Buslist.get(Choice - 1).toString());
								System.out.println();

								boolean checkingSeat = true;
								while (checkingSeat) {
									try {

										System.out.println("Press 1 to book seat at the Front.");
										System.out.println("Press 2 to book seat at the Middle.");
										System.out.println("Press 3 to book seat at the Back.");

										Seat = input.nextInt();

										checkingSeat = false;
									} catch (InputMismatchException exceptions) {

										System.out.println("\nPlease enter Integer string is not allowed.\n");

										/*
										 * new piece of code which parses the wrong input and clears the scanner for new
										 * input
										 */

										input.next();

										continue;
									}
								}

								switch (Seat)// This Switch is used to decrement available seat from the location
												// entered by user.
								{

								case 1:
									/* Checking whether Avialable seats are greater than 0 or not. */

									if (Buslist.get(Choice - 1).getFrontSeat() > 0)

									{
										/*
										 * getting the number of seats at the location enter by user and then decrement
										 * that value by 1 and then again set the value at the location
										 */
										Buslist.get(Choice - 1)
												.setFrontSeat(Buslist.get(Choice - 1).getFrontSeat() - 1);

										System.out.println(Buslist.get(Choice - 1).toString());
										break;

									} else {
										System.out.println("All Front Seats Are Booked");
										break;
									}

								case 2:
									if (Buslist.get(Choice - 1).getMiddleSeat() > 0) {

										Buslist.get(Choice - 1)
												.setMiddelSeat(Buslist.get(Choice - 1).getMiddleSeat() - 1);
										System.out.println(Buslist.get(Choice - 1).toString());
										break;
									} else {
										System.out.println("All Middle Seats Are Booked");
										break;
									}

								case 3:
									if (Buslist.get(Choice - 1).getBackSeat() > 0) {

										Buslist.get(Choice - 1).setBackSeat(Buslist.get(Choice - 1).getBackSeat() - 1);
										System.out.println(Buslist.get(Choice - 1).toString());
										break;
									} else {

										System.out.println("All Back Seats Are Booked");
										break;
									}

								default:
									break;
								}

								check = false;
								boolean Book = true;
								while (Book) {
									try {

										System.out.println("\nPress 0 to Exit");
										System.out.println("Press 5 to Book more seats");
										Choice = input.nextInt();

										Book = false;
									} catch (InputMismatchException exceptions) {

										System.out.println("\nPlease enter Integer string is not allowed.\n");

										/*
										 * new piece of code which parses the wrong input and clears the scanner for new
										 * input
										 */

										input.next();

										continue;
									}
								}

								switch (Choice) // Exiting Management system or Booking new seat.
								{
								case 0:
									Exit = false;
									System.out.println("\nThanks For Your Visit");
									break;
								case 5:
									System.out.println("Press 1 to SignIn");
									System.out.println("Press 2 to Register");
									System.out.println();
									break;
								default:
									break;
								}
							}
							/*
							 * Below is the code of Cancel booking if person come 2 hour before departure
							 * time.
							 */
							else if (Choice == 16) {

								Calendar cal = Calendar.getInstance();
								SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

								/* Getting first two character of a string that is hour. */

								String Current = sdf.format(cal.getTime()).substring(0, 2);

								/*
								 * Converting String to Integer for Comparition. I used valueOf because it
								 * returns Integer Object.
								 */

								Integer CurrentTime = Integer.valueOf(Current);

								/*
								 * Taking bus number from the user so that I can access access the object of
								 * buses from Buslist and and update the seats.
								 */

								System.out.println("Please enter Bus number in which you booked ticket.");
								BusNumber = input.nextInt();

								String Departure = list.get(BusNumber - 1).getTime().substring(0, 2);

								/*
								 * Converting String to Integer for Comparition. I used valueOf because it
								 * returns Integer Object.
								 */

								Integer DepartureTime = Integer.valueOf(Departure);

								System.out.println("DepartureTime: " + DepartureTime + " Current Time: " + CurrentTime);

								/* If time condition is true only then user is allowed to cancel seat. */

								if ((DepartureTime - CurrentTime) >= 2) {

									/*
									 * Asking user to enter the location of seat so that I can correctly make
									 * changes to that location. Here Location means Front seat, Back Seat and
									 * Middle Seat
									 */

									System.out.println(
											"Please tell at which row you booked Ticket \n\n Press 1 for Front Seat \n Press 2 for Middle Seat \n Press 3 for Back Seat ");
									Location = input.nextInt();

									/*
									 * Here when user entered the location then I am making changing like if user
									 * pressed 1 then seat at the front is increment, if user pressed 2 then seat at
									 * the Middle is increment and if user pressed 3 then seat at the Back is
									 * increment
									 */

									switch (Location) {
									case 1:
										if (Buslist.get(BusNumber - 1).getFrontSeat() + 1 <= 7) {
											Buslist.get(BusNumber - 1)
													.setFrontSeat(Buslist.get(BusNumber - 1).getFrontSeat() + 1);
											System.out.println(Buslist.get(BusNumber - 1).toString());
											System.out.println("You ticket has been Cancelled Successfully\n");
											check = false;
											break;
										} else {
											System.out.println("\nYou entered a wrong Location");
											break;
										}

									case 2:
										if (Buslist.get(BusNumber - 1).getMiddleSeat() + 1 <= 7) {
											Buslist.get(BusNumber - 1)
													.setMiddelSeat(Buslist.get(BusNumber - 1).getMiddleSeat() + 1);
											System.out.println(Buslist.get(BusNumber - 1).toString());
											System.out.println("\nYou ticket has been Cancelled Successfully\n");
											check = false;
											break;
										} else {
											System.out.println("You entered a wrong Location\n");
											break;
										}

									case 3:
										if (Buslist.get(BusNumber - 1).getBackSeat() + 1 <= 7) {
											Buslist.get(BusNumber - 1)
													.setBackSeat(Buslist.get(BusNumber - 1).getBackSeat() + 1);
											System.out.println(Buslist.get(BusNumber - 1).toString());
											System.out.println("\nYou ticket has been Cancelled Successfully");
											check = false;
											break;
										} else {
											System.out.println("You entered a wrong Location");
											break;
										}
									default:
										System.out.println("\nThe Location you entered doesn't exist.");
										break;
									}
								} else {
									System.out.println("Now it is immpossible to cancel your seat.\n");
								}
							} // Cancel seat block

							else {
								System.out.println("you entered wrong value.");
								System.out.println("\nPress 1 to SignIn again");
								check = false;
							}

						} // Checking Password and UserName.
							// break;
					}
					// System.out.println("Either you entered a wrong Password or UserName");
				}

			} else if (Choice == 2) {
				/* Here I am asking user to fill the below form in order to register. */

				boolean registerException = true;
				while (registerException) {
					try {

						System.out.println("Kindly fill the below mension form :");

						System.out.print("Name: ");
						Name = input.next();

						System.out.print("UserName: ");
						UserName = input.next();

						System.out.print("Password: ");
						Password = input.nextInt();

						System.out.print("Age: ");
						Age = input.nextInt();

						System.out.print("Email: ");
						Email = input.next();

						System.out.print("Contact Number: ");
						ContactNumber = input.nextInt();
						/*
						 * Below I am calling Register function which is described below to add the data
						 * of registered person as a object of User in Arraylist
						 */
						Register();

						System.out.println("Press 1 to SignIn");
						registerException = false;
					} catch (InputMismatchException exceptions) {

						System.out.println(
								"\nPlease enter Name,UserName and Email as a String\n  \nAge, Password and ContactNumber as a Integer.\n");

						/*
						 * new piece of code which parses the wrong input and clears the scanner for new
						 * input
						 */

						input.next();

						continue;
					}

				}
				// Choice = input.nextInt();

			} else
			/*
			 * If user press other than 1 and 2 then I am telling him that he entered a
			 * wrong password and again asked him to enter correct value.
			 */
			{
				System.out.println("You entered a wrong Value.\n");
				System.out.println("\nPress 1 to SignIn");
				System.out.println("Press 2 to Register");
			}
		}

		// System.out.println(Userlist.get(1).toString());
	}

	private static ArrayList<Bus> BusData() {

		for (int i = 0; i < 15; i++) {
			Buslist.add(new Bus(i + 1, 7, 7, 7));
		}

		return Buslist;
	}

	private static ArrayList<Route> PossibleRoutes() {
		list.add(new Route(1, "Islamabad", "Lahore", "02:00:00"));
		list.add(new Route(2, "Islamabad", "Quetta", "04:00:00"));
		list.add(new Route(3, "Islamabad", "Multan", "06:00:00"));
		list.add(new Route(4, "Islamabad", "Karachi", "08:00:00"));
		list.add(new Route(5, "Lahore", "Quetta", "10:00:00"));
		list.add(new Route(6, "Lahore", "Multan", "17:00:00"));
		list.add(new Route(7, "Lahore", "Jhelum", "13:00:00"));
		list.add(new Route(8, "Lahore", "Faislabad", "14:00:00"));
		list.add(new Route(9, "Karachi", "Lahore", "15:30:00"));
		list.add(new Route(10, "Karachi", "Islamabad", "16:00:00"));
		list.add(new Route(11, "Karachi", "Multan", "05:00:00"));
		list.add(new Route(12, "Karachi", "Hyderabad", "02:00:00"));
		list.add(new Route(13, "Kohat", "Lahore", "04:00:00"));
		list.add(new Route(14, "Kohat", "Islamabad", "00:00:00"));
		list.add(new Route(15, "Kohat", "Karachi", "22:00:00"));
		return list;
	}

	private static ArrayList<User> Register() {// ArrayList<User>
		// System.out.println(Name);

		Userlist.add(new User(Name, ContactNumber, Age, Email, UserName, Password));
		// System.out.println(Userlist.size());
		return Userlist;
	}

	private static ArrayList<User> ExistingUser() {

		Userlist.add(new User("Abbas", 0301, 20, "shahabbasgmail", "sahn", 213));
		return Userlist;
	}
}
