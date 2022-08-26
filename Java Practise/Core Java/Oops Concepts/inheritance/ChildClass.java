package inheritance;

public class ChildClass extends ParentClass{
	
	public void childMethod() {
		System.out.println("I am child Method from Child Class");
	}
	/* This is called single inheritance
	 * i.e., When a class inherits another class then it is single inheritance
	 * In selenium we use single and multi level inheritance
	 * E.g base util class for common methods which can be extended to Page Object Model Class
	 * as well as main class where both page object model and util class can be accessed
	 */
	public static void main(String[] args) {
		
		ChildClass obj = new ChildClass();
		obj.parentMethod();
		obj.childMethod();
	}
}
