
import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	public static List<Card> handCards = new ArrayList<Card>();
	
	public Hand() 
	{}

	public static List<Card> getHandCards() 
	{
		return handCards;
	}

	public void setHandCards(List<Card> handCards) 
	{
		Hand.handCards = handCards;
	}
	
	public String AnalyzeHand(){
		straightFlushAnalyze();
		straightAnalyze();
		flushAnalyze();
		pairAnalyze();
		
		if(straightFlushAnalyze() == true) 
		{
			return "STRAIGHT FLUSH!";
		}
		
		else if (straightAnalyze() == true) 
		{
			return "STRAIGHT!";
		}
		
		else if (flushAnalyze() == true)
		{
			return "FLUSH!";
		}
		
		else if (pairAnalyze() == 2)
		{
			return "TWO PAIRS!";
		}
		else 
		{ 
			return "";
		}
	}														//AnalyzeHand ends
	
	public boolean straightFlushAnalyze()
	{
		 if (straightAnalyze() == true && flushAnalyze() == true){return true;}
		 
		 else {return false; }
	}														//StraightFlushAnalyze ends
	
	public boolean straightAnalyze() 
	{ 
		int MAX = 0;
		int MIN = 13;
		int SUM = 0;
			
		for(Card card : handCards)	// MAX, MIN and SUM lookUP for straight
		{
			if (card.getRank() > MAX) 
			{
				MAX = card.getRank();
			}
			
			if (card.getRank() < MIN) 
			{
				MIN = card.getRank();
			}
			
			SUM += card.getRank();
		}
		
		
		if (MAX - MIN == 4 & pairAnalyze() == 0) {return true;}	// small straight
		// big straight
		if (MAX - MIN == 12 && SUM == 47 && pairAnalyze() == 0) 
		{
			return true;
		}	//big straight
		
		else {return false;}
	} 											// straightAnalyze ends
	
	
	public boolean flushAnalyze()
	{
		int calculator = 0;
		
		for(int i = 0; i < 5; i++)
		{
			if(handCards.get(0).getSuit().equals(handCards.get(i).getSuit())) {
				calculator++;
			}
		}
		if(calculator == 5){return true;}
		
		else{return false;}
	} 											// flushAnalyze ends
	
	public int pairAnalyze() 
	{
		int calculator=0;
	
		for(Card card : handCards) 
		{
			for (Card card2 : handCards) 			
			{
				if (card == card2) continue;
				
				if(card.getRank() == (card2.getRank())) 
				{
					calculator++;
				}
			}	// second for loop ends
		}	// first for loop ends
		
		calculator /= 2; 

		if (calculator == 2) {return 2;} // for two pairs
		
		else if (calculator == 0) {return 0;} // for straight analyze
		
		else {return -1;}
				
	} 											// pairAnalyze ends 
	
	@Override
	public String toString() 
	{
		String temp = "";
		
		for(Card c : handCards) 
		{
			temp +=  c.toString() + " | ";
		}
		
		return temp;
	}
}
