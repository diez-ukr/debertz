package com.debertz.logic;

import java.util.Collections;
import java.util.LinkedList;

public class DebertzGamePlayer
{

	public DebertzGamePlayer(User user)
	{
		this.playerName = user.getName();
		hand = new LinkedList<PlayingCard>();
		tricks = new LinkedList<PlayingCard[]>();
		combinations = null;
		gotlastTrick = false;
	}

    public String getPlayerName() {
        return playerName;
    }

    public boolean addCard(PlayingCard card)
	{
		hand.add(card);
		return true;
	}

	public boolean getCard(PlayingCard card)
	{
		synchronized (hand)
		{
			for(int i = 0; i < hand.size(); i++)
				if (hand.get(i).suit == card.suit && hand.get(i).rank == card.rank)
				{
					hand.remove(i);
					return true;
				}
			return false;
		}
	}

    public boolean overloaded() {
        if (getScore() > 21) {
            return true;
        }
        return false;
    }

    public int getScore()
    {
        int retval = 0;
        for(PlayingCard card : hand)
        {
            switch (card.rank)
            {
                case Ace:
                    break;
                case King:
                    retval += 10;
                    break;
                case Queen:
                    retval += 10;
                    break;
                case Jack:
                    retval += 10;
                    break;
                default:
                    retval += 1 + card.rank.ordinal();
                    break;
            }
        }
        for(PlayingCard card : hand)
        {
            if (card.rank == PlayingCard.Rank.Ace) {
                retval += 11;
                if (retval > 21) {
                    retval -= 10;
                }
            }
        }
        return retval;
    }

	public void sortHand()
	{
		Collections.sort(hand, new PlayingCard.PlayingCardComparator());
	}

	public boolean hasSuit(PlayingCard.Suit suit)
	{
		for(PlayingCard card : hand)
			if (card.suit == suit)
				return true;
		return false;
	}

    public LinkedList<PlayingCard[]> tricks;
	public int points;

	public String playerName;
	public volatile LinkedList<PlayingCard> hand;
	public LinkedList<DebertzCombination> combinations;
	public boolean gotlastTrick;
}
