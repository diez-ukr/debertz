package com.debertz.logic;

import java.util.Collections;
import java.util.LinkedList;

public class DebertzGamePlayer
{

	public DebertzGamePlayer(String playerName)
	{
		this.playerName = playerName;
		hand = new LinkedList<PlayingCard>();
		tricks = new LinkedList<PlayingCard[]>();
		combinations = null;
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

}
