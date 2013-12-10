package com.debertz.logic;
/*
 * Author: R.Bietin
 * Date: 10.12.13
 * Time: 1:52
 */

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class DebertzGamePlayerTest {

	private DebertzGamePlayer player;

	@Before
	public void setUp() throws Exception
	{
		player = new DebertzGamePlayer("Foo Bar");
		player.hand = new LinkedList<PlayingCard>(
				Arrays.asList(
						new PlayingCard(PlayingCard.Rank.Jack, PlayingCard.Suit.Spade),
						new PlayingCard(PlayingCard.Rank.Ace, PlayingCard.Suit.Spade),
						new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club),
						new PlayingCard(PlayingCard.Rank.Eight, PlayingCard.Suit.Diamond),
						new PlayingCard(PlayingCard.Rank.Nine, PlayingCard.Suit.Diamond),
						new PlayingCard(PlayingCard.Rank.King, PlayingCard.Suit.Diamond),
						new PlayingCard(PlayingCard.Rank.Seven, PlayingCard.Suit.Heart),
						new PlayingCard(PlayingCard.Rank.Ace, PlayingCard.Suit.Heart)
				)
		);
		for (int i = 0; i < 1000; i++)
		{
			Random random = new Random(System.currentTimeMillis());
			int card1 = Math.abs(random.nextInt()) % player.hand.size();
			int card2 = Math.abs(random.nextInt()) % player.hand.size();
			Collections.swap(player.hand, card1, card2);
		}
	}

	@Test
	public void testAddCard() throws Exception
	{
		boolean status;
		status = player.getCard(new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club));
		Assert.assertEquals(true, status);
		status = player.getCard(new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club));
		Assert.assertEquals(false, status);
		status = player.addCard(new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club));
		Assert.assertEquals(true, status);
	}

	@Test
	public void testGetCard() throws Exception
	{
		boolean status;
		status = player.getCard(new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club));
		Assert.assertEquals(true, status);
		status = player.getCard(new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club));
		Assert.assertEquals(false, status);
	}

	@Test
	public void testSortHand() throws Exception
	{
		LinkedList<PlayingCard> sortedHand = new LinkedList<PlayingCard>(
				Arrays.asList(
						new PlayingCard(PlayingCard.Rank.Jack, PlayingCard.Suit.Spade),
						new PlayingCard(PlayingCard.Rank.Ace, PlayingCard.Suit.Spade),
						new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club),
						new PlayingCard(PlayingCard.Rank.Eight, PlayingCard.Suit.Diamond),
						new PlayingCard(PlayingCard.Rank.Nine, PlayingCard.Suit.Diamond),
						new PlayingCard(PlayingCard.Rank.King, PlayingCard.Suit.Diamond),
						new PlayingCard(PlayingCard.Rank.Seven, PlayingCard.Suit.Heart),
						new PlayingCard(PlayingCard.Rank.Ace, PlayingCard.Suit.Heart)
				)
		);

		player.sortHand();
		Assert.assertEquals(sortedHand.size(), player.hand.size());
		for (int i = 0; i < sortedHand.size(); i++)
		{
			Assert.assertEquals(true, sortedHand.get(i).equals(player.hand.get(i)));
		}
	}

	@Test
	public void testHasSuit() throws Exception
	{
		boolean status;
		status = player.hasSuit(PlayingCard.Suit.Club);
		Assert.assertEquals(true, status);
		status = player.getCard(new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Club));
		Assert.assertEquals(true, status);
		status = player.hasSuit(PlayingCard.Suit.Club);
		Assert.assertEquals(false, status);
	}
}
