
public class Burner {

	
	private enum Temperature {BLAZING,HOT,WARM,COLD};
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	public final static int TIME_DURATION =2;
	
	public Burner() {
		super();
		this.myTemperature = Temperature.COLD;
		this.mySetting = Setting.OFF;
	}

	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	
	public void plusButton() {
		switch(mySetting) {
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				break;
		}
		
	}
	
	public void minusButton() {
		switch(mySetting) {
		case OFF:
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		}
		
	}
	
	public void updateTemperature() {
		
	}
	
	public void display() {
		
	}
	
	
}
