package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	
	public NotEnoughBatteryException(double batteryLevel) {
		super();
		this.batteryLevel = batteryLevel;
	}

	@Override
	public String toString() {
		return "Not enough battery [batteryLevel=" + batteryLevel + "]";
	}
	
	public String getMessage() {
		return this.toString();
	}
}
