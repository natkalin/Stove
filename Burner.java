
public class Burner {

	private enum Temperature {BLAZING,HOT,WARM,COLD};
	private static enum Direction {PLUS,MINUS};
	private Temperature myTemperature;
	private Setting mySetting;
	private static Direction myDirection;
	private int timer = 0;
	public final static int TIME_DURATION = 2;
	
	public Burner() {
		super();
		this.myTemperature = Temperature.COLD;
		this.mySetting = Setting.OFF;
	}

	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	public void plusButton() {
		
		myDirection = myDirection.PLUS;
		
		switch(mySetting) {
			case OFF:
				mySetting = Setting.LOW;
				timer = timer + TIME_DURATION;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				timer = timer + TIME_DURATION;
				break;
			case MEDIUM:
				timer = timer + TIME_DURATION;
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				timer = timer + TIME_DURATION;
				break;
		}
			
	}
	
	public void minusButton() {
		
		myDirection = myDirection.MINUS;
		
		switch(mySetting) {
		case OFF:
			timer = timer + TIME_DURATION;
			break;
		case LOW:
			timer = timer + TIME_DURATION;
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			timer = timer + TIME_DURATION;
			mySetting = Setting.LOW;
			break;
		case HIGH:
			timer = timer + TIME_DURATION;
			mySetting = Setting.MEDIUM;
			break;
		}
		
	}
	
	public void updateTemperature() {	
		
		
		
		if(timer%2 != 0) {
			switch(myDirection) {
				case PLUS:
			
			}
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
		
		
		if(timer != 0)
		{
			timer = timer - 1;
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
