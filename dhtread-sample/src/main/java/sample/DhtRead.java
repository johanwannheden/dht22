package sample;

public class DhtRead {
	static {
		System.loadLibrary("dhtread");
	}

	public static native int getTemperature();

	public static native Reading getReading();
}
