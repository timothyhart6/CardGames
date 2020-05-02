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
        Poker poker = new Poker(humanPlayer, 1);
        poker.dealHoleCards();
        Card[] expectedHand = {new Card("A", "H"), new Card("K", "H")};
        Assert.assertEquals(expectedHand, humanPlayer.getHand());
        Assert.assertEquals(50, poker.deck.count());
    }

    @Test
    public void testBurnCard() {
        Poker poker = new Poker(new Player("Timothy", 200), 1);
        poker.burnCard();
        Assert.assertEquals(51, poker.deck.count());
    }

    @Test
    public void  testDealFlop() {
        Poker poker = new Poker(new Player("Timothy", 200), 1);
        poker.dealFlop();
        Card[] expectedFlopCards = {new Card("A", "H"), new Card("K", "H"), new Card("Q", "H")};
        Assert.assertEquals(49, poker.deck.count());
        Assert.assertEquals(expectedFlopCards, poker.getFlop());
    }

    @Test
    public void testDealTurn() {
        Poker poker = new Poker(new Player("Timothy", 200), 1);
        poker.dealTurn();
        Card expectedTurnCard = new Card("A", "H");
        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedTurnCard, poker.getTurn());
    }

    @Test
    public void testDealRiver() {
        Poker poker = new Poker(new Player("Timothy", 200), 1);
        poker.dealRiver();
        Card expectedRiverCard = new Card("A", "H");
        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedRiverCard, poker.getRiver());
    }
}
