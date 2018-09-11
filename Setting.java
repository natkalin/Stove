/*
 * Authors : Natalie Kalin & Cale Waress
 */
public enum Setting {	
	OFF("[---]"), LOW("[--+]"), MEDIUM("[-++]"), HIGH("[+++]");
	
	private String value;
	
	Setting (String aValue){
		value = aValue;
	}
	
	public String toString() {
		return value;
	}
	
}
