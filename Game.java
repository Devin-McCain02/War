import java.util.*;
public class Game {
	
	private static String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	public static void main(String args[]) {
		Scanner inp = new Scanner(System.in);
		Deck startDeck = new Deck(true);
		startDeck.shuffle();
		Deck[] playerdecks = startDeck.spilt(2);
		startDeck.empty();
		
		Deck playerOne = playerdecks[0];
		Deck playerTwo = playerdecks[1];
		
		boolean running = true;
		int winner = 0;
		
		Card C1;
		Card C2;
		Card H1;
		Card H2;
		int war;
		int warResult;
		boolean in_war = false;
		
		Deck WAR = new Deck();
		
		while(running) {
			//inp.nextLine();
			System.out.println("\n");
			C1 = playerOne.getCard(0);
			C2 = playerTwo.getCard(0);
			
			playerOne.removeCard(0);
			playerTwo.removeCard(0);
			
			war = compare(C1, C2);
			
			WAR.empty();
			WAR.addCard(C1);
			WAR.addCard(C2);
			WAR.shuffle();
			
			System.out.println("Player 1 Card: "+C1.GetName());
			System.out.println("Player 2 Card: "+C2.GetName());
			
			
			if(war==1) {
				playerOne.addCards(WAR);
				System.out.println("Player 1 Wins");
			}else if(war==2) {
				playerTwo.addCards(WAR);
				System.out.println("Player 2 Wins");
			}else if(war==0) {
				System.out.println("WAR");
				System.out.println("\tStarting Size\n");
				System.out.print("\tPlayer 1 Total: ");
				System.out.println(playerOne.size());
				System.out.print("\tPlayer 2 Total: ");
				System.out.println(playerTwo.size());
				in_war = true;
				while(in_war) {
					if(playerOne.size()<2) {
						in_war=false;
						playerTwo.addCards(WAR);
						playerTwo.addCards(playerOne);
						playerOne.empty();
					}else if(playerTwo.size()<2) {
						in_war=false;
						playerOne.addCards(WAR);
						playerOne.addCards(playerTwo);
						playerTwo.empty();
					}
					if(in_war) {
						H1 = playerOne.getCard(0);
						playerOne.removeCard(0);
						C1 = playerOne.getCard(0);
						playerOne.removeCard(0);
						
						H2 = playerTwo.getCard(0);
						playerTwo.removeCard(0);
						C2 = playerTwo.getCard(0);
						playerTwo.removeCard(0);
						
						WAR.addCard(H1);
						WAR.addCard(C1);
						WAR.addCard(H2);
						WAR.addCard(C2);
						WAR.shuffle();
						
						
						
						System.out.println("\t__");
						warResult = compare(C1, C2);
						System.out.println("\tPlayer 1 Card: "+C1.GetName());
						System.out.println("\tPlayer 2 Card: "+C2.GetName());
						
						if(warResult==1) {
							playerOne.addCards(WAR);
							System.out.println("\tPlayer One Wins");
							in_war=false;
						}else if(warResult==2) {
							playerTwo.addCards(WAR);
							System.out.println("\tPlayer Two Wins");
							in_war=false;
						}else {
							System.out.println("\tTie");
						}
						System.out.print("\tPlayer 1 Total: ");
						System.out.println(playerOne.size());
						System.out.print("\tPlayer 2 Total: ");
						System.out.println(playerTwo.size());
					}else {
						System.out.println("\tPlayer Ran Out of Cards and Lost");
					}
				}
				System.out.println("WAR OVER");
			}
			
			System.out.print("Player 1 Total: ");
			System.out.println(playerOne.size());
			System.out.print("Player 2 Total: ");
			System.out.println(playerTwo.size());
			System.out.print("Total Cards: ");
			System.out.println(playerOne.size()+playerTwo.size());
			if(playerOne.size()+playerTwo.size()!=52) {
				running = false;
			}
			

			if(playerOne.size()==0) {
				winner = 2;
				running = false;
			}
			else if(playerTwo.size()==0) {
				winner = 1;
				running = false;
			}
		}
		if(winner==1) {
			System.out.println("Player 1 Wins");
		}else if(winner==2){
			System.out.println("Player 2 Wins");
		}
		
	}
	
	public static int compare(Card PlayerOneType, Card PlayerTwoType) {
		int P1 = get_value(PlayerOneType.getValue());
		int P2 = get_value(PlayerTwoType.getValue());
		if(P1>P2) {
			return 1;
		}
		else if(P1<P2) {
			return 2;
		}
		return 0;
	}
	
	public static int get_value(String valuesInp) {
		int value;
		for(int i = 0; i < values.length; i++) {
			if(valuesInp.equals(values[i])) {
				value = i;
				return value;
			}
		}
		return -1;
	}
}
