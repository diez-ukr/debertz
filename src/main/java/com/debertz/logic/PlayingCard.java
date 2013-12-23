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
		Ace,
		UNKNOWN
	}

	public enum Suit
	{
		Spade,
		Club,
		Diamond,
		Heart,
		UNKNOWN
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayingCard other = (PlayingCard) obj;
		return suit == other.suit && rank == other.rank;
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

	public static String getResourceName(PlayingCard card)
	{
		String retval = "img/cards/";
		switch (card.suit)
		{
			case Spade: retval += "Spades "; break;
			case Club: retval += "Clubs "; break;
			case Diamond: retval += "Diamonds "; break;
			case Heart: retval += "Hearts "; break;
			case UNKNOWN:
				retval += "unknown.png";
				return retval;
		}
		switch (card.rank)
		{
			case Ace: retval += "1"; break;
			case Seven: retval += "7"; break;
			case Eight: retval += "8"; break;
			case Nine: retval += "9"; break;
			case Ten: retval += "10"; break;
			case Jack: retval += "11"; break;
			case Queen: retval += "12"; break;
			case King: retval += "13"; break;
			case UNKNOWN:
				retval += "unknown.png";
				return retval;
		}
		return retval + ".png";
	}
}
