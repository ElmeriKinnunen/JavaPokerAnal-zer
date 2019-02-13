
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {
	
	private static List<Card> deck;
	private String suits[] = {"Clubs", "Diamonds", "Hearts", "Spades" };
	private int ranks[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	
	public Deck() 
	{
		deck = new ArrayList<Card>();
		CreateDeck();
	}
	
	
	private void CreateDeck() 	// insert all 52 cards to the deck
	{
		for(int i = 0; i < 52; i++) 
		{
			deck.add(new Card(suits[i/13], ranks[i%13]));
		}
	}
	
	public void shuffleDeck() // random shuffle to deck
	{
		Collections.shuffle(deck);		
	}
	
	public List<Card> DealHand()	// deal 5 cards to hand
	{
		List<Card> CardsToHand = new ArrayList<Card>();
		
			for (int i = 0; i < 5;i++) 
			{
				CardsToHand.add(deck.get(0));
				deck.remove(0);
			}
			CardsToHand.sort(Comparator.comparing(Card::getRank));
		
		return CardsToHand;
	}
}
