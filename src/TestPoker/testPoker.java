package TestPoker;

import Poker.Poker;
import Poker.Player;
import Poker.Card;
import org.junit.Assert;
import org.junit.Test;

public class testPoker {

//    @Test
//    public void testNumberOfPlayers() {
//        Poker poker = new Poker();
//        poker.setNumberOfPlayers(1);
//        Assert.assertEquals(1, poker.getNumberOfPlayers());
//    }

    @Test
    public void testDealHoleCards() {
        Player humanPlayer = new Player("Timothy", 200);
        int numberOfPlayers = 1;
        Poker poker = new Poker(humanPlayer, numberOfPlayers);
        poker.dealHoleCards();
        Card[] expectedHand = {new Card("A", "H"), new Card("K", "H")};
        Assert.assertEquals(expectedHand, humanPlayer.getHand());
        Assert.assertEquals(50, poker.deck.count());

    }
}
