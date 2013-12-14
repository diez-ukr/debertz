package com.debertz.logic;
/*
 * Author: R.Bietin
 * Date: 10.12.13
 * Time: 1:48
 */
import java.util.LinkedList;

public class DebertzCombination
{
	public DebertzCombination(LinkedList<PlayingCard> cards)
	{
		this.cards = cards;
		leadCard = cards.getLast();
		switch (cards.size())
		{
			case 2:
			case 3:
				points = 20;
				break;
			case 4:
				points = 20;
		}
		if (cards.size() == 2) points = 20;
		isPlaying = false;
	}

	public int getPoints()
	{
		if (!isPlaying) return 0;
		return points;
	}

	public void markAsPlaying()
	{
		isPlaying = true;
	}

	public PlayingCard leadCard;
	public LinkedList<PlayingCard> cards;

	private int points;
	private boolean isPlaying;

}
