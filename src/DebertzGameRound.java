import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class DebertzGameRound
{
	public DebertzGamePlayer[] debertzGamePlayers;

	private int playersCount;
	private LinkedList<PlayingCard> deck;
	private PlayingCard trumpCard;
	private PlayingCard.Suit trumpSuit;
	private PlayingCard[] currentTrick;
	private PlayingCard[] lastTrick;

	public int getTurn()
	{
		return turn;
	}

	private int turn;

	public boolean Init(DebertzGamePlayer[] players)
	{
		debertzGamePlayers = players;
		playersCount = players.length;
		currentTrick = new PlayingCard[playersCount];
		for(int i = 0; i < playersCount; i++)
			currentTrick[i] = null;
		return !(playersCount < 2 || playersCount > 4);
	}

	public PlayingCard getTrumpCard()
	{
		return trumpCard;
	}

	public boolean giveCards()
	{
		deck = new LinkedList<PlayingCard>();
		for(PlayingCard.Rank rank : PlayingCard.Rank.values())
			for(PlayingCard.Suit suit : PlayingCard.Suit.values())
				deck.push(new PlayingCard(rank, suit));
		/* shaking deck */
		for(int i = 0; i < 1000; i++)
		{
			Random random = new Random(System.currentTimeMillis());
			int card1 = random.nextInt() % deck.size();
			int card2 = random.nextInt() % deck.size();
			Collections.swap(deck, card1, card2);
		}
		for(int i = 0; i < 6; i++)
			for(DebertzGamePlayer player : debertzGamePlayers)
				player.addCard(deck.removeFirst());
		sortPlayersHands();

		trumpCard = deck.getLast();
		return true;
	}

	public boolean giveTalon(PlayingCard.Suit trumpSuit)
	{
		this.trumpSuit = trumpSuit;
		int cardCount = 6 - playersCount;
		for(int i = 0; i < cardCount; i++)
			for(DebertzGamePlayer player : debertzGamePlayers)
				player.addCard(deck.removeFirst());
		sortPlayersHands();
		return true;
	}

	public boolean giveTalon(int turn)
	{
		if (turn < 0 || turn >= playersCount) return false;
		this.turn = turn;
		return giveTalon(trumpCard.suit);
	}

	public LinkedList<PlayingCard> getPlayersHand(String name)
	{
		for(DebertzGamePlayer p : debertzGamePlayers)
			if (p.playerName.equals(name))
				return p.hand;
		return null;
	}

	public PlayingCard getTopCard()
	{
		if (deck.isEmpty()) return null;
		return deck.getFirst();
	}

	public boolean putCard(String name, PlayingCard card)
	{
		int playerID = -1;
		for(int i = 0; i < playersCount; i++)
			if (debertzGamePlayers[i].playerName.equals(name))
			{
				playerID = i;
				break;
			}
		if (playerID == -1)
			return false;
		DebertzGamePlayer player = debertzGamePlayers[playerID];
		boolean validCard = false;
		for(int i = 0; i < player.hand.size(); i++)
		{
			if (player.hand.get(i) == card)
			{
				validCard = true;
				break;
			}
		}
		if (!validCard)
			return false;

		if(currentTrick[0] == null)
		{
			player.getCard(card);
			currentTrick[0] = card;
			return true;
		}

		if(currentTrick[0].suit != card.suit)
		{
			if (player.hasSuit(currentTrick[0].suit))
				return false;
			if (card.suit != trumpSuit && player.hasSuit(trumpSuit))
				return false;
		}
		for(int i = 1; i < playersCount; i++)
			if (currentTrick[i] == null)
			{
				player.getCard(card);
				currentTrick[i] = card;
				return true;
			}
		return false;
	}

	public int finishTurn()
	{
		if (currentTrick[playersCount - 1] == null)
			return -1;
		turn = getHighestCard(currentTrick);
		if (turn < 0)
			return turn;
		debertzGamePlayers[turn].tricks.add(currentTrick);
		lastTrick = currentTrick;
		currentTrick = new PlayingCard[playersCount];
		for (int i = 0; i < playersCount; i++)
			currentTrick[i] = null;
		return turn;
	}

	private int getHighestCard(PlayingCard[] cards)
	{
		if (cards.length < 2 || cards.length > 4) return -1;
		int maxCardIndex = 0;
		for (int i = 1; i < cards.length; i++)
		{
			if (cards[i].suit == trumpSuit && cards[maxCardIndex].suit != trumpSuit)
			{
				maxCardIndex = i;
				continue;
			}
			if (cards[i].suit != trumpSuit && cards[maxCardIndex].suit == trumpSuit)
				continue;
			if (cards[i].suit != cards[0].suit)
				continue;
			if (cardRankToInt(cards[i]) > cardRankToInt(cards[maxCardIndex]))
				maxCardIndex = i;
		}
		return maxCardIndex;
	}

	private void sortPlayersHands()
	{
		for(DebertzGamePlayer p: debertzGamePlayers)
			p.sortHand();
	}

	private int cardRankToInt(PlayingCard card)
	{
		if (card.suit == trumpSuit)
		{
			if(card.rank == PlayingCard.Rank.Jack) return 7;
			if(card.rank == PlayingCard.Rank.Nine) return 6;
			if(card.rank == PlayingCard.Rank.Ace) return 5;
			if(card.rank == PlayingCard.Rank.Ten) return 4;
			if(card.rank == PlayingCard.Rank.King) return 3;
			if(card.rank == PlayingCard.Rank.Queen) return 2;
			if(card.rank == PlayingCard.Rank.Eight) return 1;
			if(card.rank == PlayingCard.Rank.Seven) return 1;
		}
		else
		{
			if(card.rank == PlayingCard.Rank.Ace) return 7;
			if(card.rank == PlayingCard.Rank.Ten) return 6;
			if(card.rank == PlayingCard.Rank.King) return 5;
			if(card.rank == PlayingCard.Rank.Queen) return 4;
			if(card.rank == PlayingCard.Rank.Jack) return 3;
			if(card.rank == PlayingCard.Rank.Nine) return 2;
			if(card.rank == PlayingCard.Rank.Eight) return 1;
			if(card.rank == PlayingCard.Rank.Seven) return 0;
		}
		return -1;
	}



}
