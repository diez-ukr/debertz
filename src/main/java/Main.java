import com.debertz.logic.PlayingCard;
import com.debertz.logic.TablePool;

public class Main
{

	public static void main(String[] args)
	{
//		System.out.print(
//			PlayingCard.getResourceName(new PlayingCard(PlayingCard.Rank.King, PlayingCard.Suit.Club))
//		);

        System.out.println(TablePool.getAll().length);
	}
}
