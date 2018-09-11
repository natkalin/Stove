/*
 * Authors : Natalie Kalin & Cale Waress
 */
public class Burner {

	private enum Temperature {BLAZING,HOT,WARM,COLD};
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer = 0;
	public static final int TIME_DURATION = 2;
	
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
				timer = TIME_DURATION;
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
			timer =  TIME_DURATION;
			break;
		}
		
	}
	
	public void updateTemperature() {		
		
		if(timer != 0)
		{
			timer--;
		}
		
		if(timer == 0)
		{
			switch(mySetting) {
			case OFF:
				if(myTemperature != Temperature.COLD) {
					previous();
					timer = TIME_DURATION;
				}
				break;
			case LOW:
				if(myTemperature != Temperature.WARM) {
					if(myTemperature == Temperature.HOT  || myTemperature == Temperature.BLAZING) {
						previous();
					} else {
						next();
					}
					timer = TIME_DURATION;
				}
				break;
			case MEDIUM:
				if(myTemperature != Temperature.HOT) {
					if(myTemperature == Temperature.BLAZING) {
						previous();
					} else {
						next();
					}
					timer = TIME_DURATION;
				}
				break;
			case HIGH:
				if(myTemperature != Temperature.BLAZING) {
					next();
					timer = TIME_DURATION;
				}
				break;
			}
		}	
		
	}
	
	public void next() {
		switch(myTemperature) {
		case COLD:
			myTemperature = Temperature.WARM;
			break;
		case WARM:
			myTemperature = Temperature.HOT;
			break;
		case HOT:
			myTemperature = Temperature.BLAZING;
			break;
		case BLAZING:
			break;
		}
	}
	
	public void previous() {
		switch(myTemperature) {
		case BLAZING:
			myTemperature = Temperature.HOT;
			break;
		case HOT:
			myTemperature = Temperature.WARM;
			break;
		case WARM:
			myTemperature = Temperature.COLD;
			break;
		case COLD:
			break;
		}
	}
	
	
	public boolean display() {
		
		System.out.print(mySetting);
		
		switch(myTemperature) {
		case COLD:
			System.out.println(".....coooool");
			break;
		case WARM:
			System.out.println(".....warm");
			break;
		case HOT:
			System.out.println(".....CAREFUL");
			break;
		case BLAZING:
			System.out.println(".....VERY HOT! DON'T TOUCH!");
			return true;
		}
		
		return false;
		
	}
	
	
}
