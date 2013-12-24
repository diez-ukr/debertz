package com.debertz.logic;

import java.util.Collections;
import java.util.LinkedList;

public class DebertzGamePlayer
{

	public DebertzGamePlayer(User user, Team team)
	{
        this.team = team;
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

    public int getScore(PlayingCard.Suit trumpSuit)
    {
        int retval = 0;
        for(DebertzCombination debertzCombination : this.combinations)
            retval += debertzCombination.getPoints();
        if(this.gotlastTrick)
            retval += 10;
        for(PlayingCard[] trick : this.tricks)
        {
            for(PlayingCard card : trick)
            {
                switch (card.rank)
                {
                    case Ace:
                        retval += 11;
                        break;
                    case Ten:
                        retval += 10;
                        break;
                    case King:
                        retval += 4;
                        break;
                    case Queen:
                        retval += 3;
                        break;
                    case Jack:
                        if (card.suit == trumpSuit)
                            retval += 20;
                        else
                            retval += 2;
                        break;
                    case Nine:
                        if (card.suit == trumpSuit)
                            retval += 14;
                        break;
                    default:
                        break;
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

    public Team getTeam() {
        return team;
    }

    public LinkedList<PlayingCard[]> tricks;
	public int points;

	public String playerName;
	public volatile LinkedList<PlayingCard> hand;
	public LinkedList<DebertzCombination> combinations;
	public boolean gotlastTrick;
    private Team team;
}
