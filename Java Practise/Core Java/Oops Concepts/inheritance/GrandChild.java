package inheritance;

public class GrandChild extends ChildClass{
	
	public void grandChildMethod() {
		System.out.println("I am grand Child from grand Child Class");
	}
	/*
	 * When there is chain of inheritance then it can be called as multi level inheritance
	 * In this examole parent class extended to child class
	 * and then child class is extended to grand children
	 * so yeah it is a fine example for multi level inheritance
	 */
	public static void main(String[] args) {
		GrandChild obj = new GrandChild();
		obj.parentMethod();
		obj.childMethod();
		obj.grandChildMethod();
		

	}

}
