import com.debertz.logic.PlayingCard;

import java.util.Collections;
import java.util.LinkedList;

public class Main
{

	public static void main(String[] args)
	{
		LinkedList<PlayingCard> cards = new LinkedList<PlayingCard>();
		for(PlayingCard.Rank rank : PlayingCard.Rank.values())
			for(PlayingCard.Suit suit : PlayingCard.Suit.values())
				cards.add(new PlayingCard(rank, suit));
		Collections.sort(cards, new PlayingCard.PlayingCardComparator());
		for(PlayingCard c : cards)
			System.out.println(c);
	}
}
