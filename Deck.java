import java.util.*;
public class Deck {
	
	private LinkedList<Card> Cards = new LinkedList<Card>();
	
	private String[] symbols = {"Clubs","Diamonds","Heards","Spaids"};
	private String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	public Deck() {}
	
	public Deck(boolean FullDeck) {
		if(FullDeck) {
			this.fill();
		}
	}	
	
	public void empty() {
		Cards.clear();
	}
	
	public void fill() {
		int type;
		for(int i = 0;i<symbols.length;i++) {
			for(int j = 0;j<values.length;j++) {
				type = i*13 + j + 1;
				Card newCard = new Card(symbols[i],values[j], type);
				Cards.add(newCard);
			}
		}
	}
	
	public Deck[] spilt(int parts) {
		Deck[] output = new Deck[parts];
		for(int i = 0; i < parts; i++) {
			output[i] = new Deck();
		}
		int index = 0;
		for(int i = 0; i < Cards.size(); i++) {
			output[index].addCard(this.getCard(i));
			index+=1;
			if(index + 1 > parts) {
				index = 0;
			}
		}
		return output;
	}
	
	public void shuffle() {
		Collections.shuffle(Cards);
	}
	
	public void printAllCards() {
		for(int i = 0; i<Cards.size();i++) {
			System.out.println(Cards.get(i).GetName());
		}
	}
	
	public int size() {
		return Cards.size();
	}
	
	public void removeCard(int index) {
		Cards.remove(index);
	}
	
	public Card getCard(int index) {
		return Cards.get(index);
	}
	
	public void addCard(Card card) {
		Cards.add(card);
	}
	
	public void addCards(Deck cards) {
		for(int i = 0; i < cards.size(); i++) {
			this.addCard(cards.getCard(i));
		}
	}
	
	public void addDeck(Deck deck) {
		for(int i = 0; i < deck.size(); i++) {
			Cards.add(deck.getCard(i));
		}
	}
}