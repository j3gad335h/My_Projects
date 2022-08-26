package polymorphism;

public class SalaryDetails extends EmployeeDetails {

	// Error Message If we extend Class that made with Constructor given below
	/*
	 * Implicit super constructor EmployeeDetails() is undefined for default
	 * constructor. Must define an explicit constructor
	 */
	// Need to Create Super constructor to access object from constructor class
	private double salary;

	public SalaryDetails(String name, String address, long phoneNumber,double salary) {
		super(name, address, phoneNumber);
		setSalary(salary);

	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void mailCheck() {
		System.out.println("Mail Check Method from Salary Class");
		System.out.println("Mailing Check to " + getName() + " and their salary is " + salary);
	}

}
