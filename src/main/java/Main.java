import com.debertz.dao.Tables;
import com.debertz.dao.Users;
import com.debertz.logic.PlayingCard;
import com.debertz.logic.*;
import com.debertz.logic.TableParams;

import java.util.Collections;
import java.util.LinkedList;

public class Main
{

	public static void main(String[] args)
	{
//		LinkedList<PlayingCard> cards = new LinkedList<PlayingCard>();
//		for(PlayingCard.Rank rank : PlayingCard.Rank.values())
//			for(PlayingCard.Suit suit : PlayingCard.Suit.values())
//				cards.add(new PlayingCard(rank, suit));
//		Collections.sort(cards, new PlayingCard.PlayingCardComparator());
//		for(PlayingCard c : cards)
//			System.out.println(c);
        Tables.add(new Table(new TableParams(4, 501), new User("shlololo"),100 ));
        //System.out.println(Tables.get(2));
	}
}
