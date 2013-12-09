package com.debertz.logic;

import java.util.Comparator;

public class PlayingCard
{
	public enum Rank
	{
		Seven,
		Eight,
		Nine,
		Ten,
		Jack,
		Queen,
		King,
		Ace
	}

	public enum Suit
	{
		Spade,
		Club,
		Diamond,
		Heart
	}

	public final Rank rank;
	public final Suit suit;

	public PlayingCard(Rank rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString()
	{
		return rank + " " + suit;
	}

	public static class PlayingCardComparator implements Comparator<PlayingCard>
	{

		@Override
		public int compare(PlayingCard o1, PlayingCard o2)
		{
			if (o1.suit.compareTo(o2.suit) != 0)
				return o1.suit.compareTo(o2.suit);
			return o1.rank.compareTo(o2.rank);
		}
	}
}
