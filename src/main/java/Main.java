import com.debertz.logic.PlayingCard;

public class Main
{

	public static void main(String[] args)
	{
		System.out.print(
			PlayingCard.getResourceName(new PlayingCard(PlayingCard.Rank.King, PlayingCard.Suit.Club))
		);
	}
}
