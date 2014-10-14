package sample;

public class DhtRead {
	static {
		System.loadLibrary("dht");
	}

	public static native int getTemperature();
}
