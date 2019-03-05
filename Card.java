
/**
 * Write a description of class Deck here.
 * 
 * @author Devin McCain 
 * @version (a version number or a date)
 */
public class Card {
    private final Suit suit;
    private final Pip value;
 
    public Card(Suit s, Pip v) {
        suit = s;
        value = v;
    }
 
    public String toString() {
        return value + " of " + suit;
    }
}