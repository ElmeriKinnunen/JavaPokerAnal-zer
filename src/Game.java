
public class Game {
	
	private static Deck deck;
	private static Hand hand1 = new Hand();
	private static Hand hand2 = new Hand();
	private static Hand hand3 = new Hand();
	
	public static void main(String[] args) 
	{
		Game game = new Game();
		game.RunGame();
	}
	
	public void RunGame() 
	{
		CreateDeck();
		shuffle();
		Deal();
	}
	
	public void CreateDeck() 
	{
		deck = new Deck();
	}
	
	public void shuffle() 
	{
		deck.shuffleDeck();
	}
	public void lineAfterHand()
	{
		for (int i = 0; i < 80; i++) 
		{
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	public void Deal() 
	{
		String result = "";
		
		hand1.setHandCards(deck.DealHand());
		result = hand1.AnalyzeHand();
		System.out.println("\nFirst hand: " + result + "\n" + hand1);
		lineAfterHand();
		
		hand2.setHandCards(deck.DealHand());
		result = hand2.AnalyzeHand();
		System.out.println("\nSecond hand: " + result + "\n" + hand2);
		lineAfterHand(); 
		
		hand3.setHandCards(deck.DealHand());
		result = hand3.AnalyzeHand();
		System.out.println("\nThird hand: " + result + "\n" + hand3);
		lineAfterHand(); 
	}
}
