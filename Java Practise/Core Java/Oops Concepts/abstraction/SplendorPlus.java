package abstraction;

public class SplendorPlus extends Bike {
	/* Abstract method to just declare methods
	 * but their implementation provided in another class
	 */
	public static void main(String[] args) {
		SplendorPlus sp=new SplendorPlus();
		sp.run();
		sp.gear1();
		sp.gear2();
		sp.breakApplied();
		sp.gear3();
		sp.gear4();

	}

	@Override
	void run() {
		System.out.println("Engine Started");
		
	}

	@Override
	void gear1() {
		System.out.println("Put Gear 1");
		
	}

	@Override
	void gear2() {
		System.out.println("Put Gear 2");
		
	}

	@Override
	void gear3() {
		System.out.println("Put Gear 3");
		
	}

	@Override
	void gear4() {
		System.out.println("Put Gear 4");
		
	}

	@Override
	void breakApplied() {
		System.out.println("Applying Brakes");
		
	} 

}
