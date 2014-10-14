package sample;

import java.text.MessageFormat;

public class Reading {

	private float temperature;
	private float humidity;

    public Reading(final float temperature, final float humidity) {
	this.temperature = temperature;
	this.humidity = humidity;
    }

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public String toString() {
		return MessageFormat.format("Temperature: {0}, Humidity: {1}",
				temperature, humidity);
	}
}
