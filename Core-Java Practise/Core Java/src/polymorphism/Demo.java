package polymorphism;

public class Demo {

	public static void main(String[] args) {
		
		EmployeeDetails emp = new EmployeeDetails("Jegadeesh", "Tamilandu,India", 9486874234L);
		emp.mailCheck();
		
		EmployeeDetails emp2= new SalaryDetails("Jegadeesh", "Kerala,In", 9486874234L,1000.50);
		emp2.mailCheck();

	}

}
