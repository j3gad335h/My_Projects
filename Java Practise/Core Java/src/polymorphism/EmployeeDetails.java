package polymorphism;

public class EmployeeDetails {
	private String name;
	private String address;
	private long phoneNumber;
	
	
	// Constructor -->Special Method
	// Used to set initial values of object attributes
	public EmployeeDetails(String name,String address,long phoneNumber) {
		System.out.println("Constructing Employee Details");
		this.name=name;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	
	public void mailCheck() {
		System.out.println("Mailing a Check to "+name+" "+address);
		System.out.println("Contact Number "+phoneNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

}
