import sample.DhtRead;

public class Test {

	public static void main(String[] args) {
		System.out.println("Result: " + DhtRead.getTemperature());
		System.out.println("Reading: " + DhtRead.getReading());
	}
	
}
