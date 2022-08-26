package inheritance;

public class ChildClass2 extends ParentClass{
	/*
	 * So in this class,parent class extedn with ChildClass2
	 * also Parent class extended to ChildClass
	 * So if one class extended to multiple class then it is called as hierarchical inheritance
	 */
	public void child2() {
		System.out.println("I am the second child for my parent");
	}
	public static void main(String[] args) {
		ChildClass2 obj = new ChildClass2();
		obj.parentMethod();
		obj.child2();

	}

}
