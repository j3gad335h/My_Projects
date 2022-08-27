package encapsulation;

public class EncapTest {

	public static void main(String[] args) {
		WrapperClass obj = new WrapperClass();
		obj.setEmpName("Jegadeesh");
		obj.setAddress("Tamilnadu,India");
		obj.setAge(27);
		System.out.println("Hello I am "+obj.getEmpName()+" from "+obj.getAddress());

	}

}
