public class Card {
	
	private String symbol; 
	private String value;
	private int type;
	
	public Card() {}
	
	public Card(String symbol_, String value_, int type_) {
		symbol = symbol_;
		value = value_;
		type = type_;
	}
	
	public String GetName() {
		return Integer.toString(type)+ ": "+ value+" of "+symbol;
	}
	
	public String getValue() {
		return value;
	}
}
