package TestPoker;

import Poker.Poker;
import Poker.Player;
import Poker.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
        Assert.assertTrue(humanPlayer.getHand().contains(new Card("A", "H")));
        Assert.assertTrue(humanPlayer.getHand().contains(new Card("K", "H")));
        Assert.assertEquals(50, poker.deck.count());
        Assert.assertEquals(2, humanPlayer.getHand().size());
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
    public void testFlopAsString() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealFlop();
        ArrayList expectedFlop = new ArrayList();
        expectedFlop.add("AH");
        expectedFlop.add("KH");
        expectedFlop.add("QH");
        Assert.assertEquals(expectedFlop, poker.getFlopAsString());
        Assert.assertEquals(49, poker.deck.count());
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
    public void testTurnAsString() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealTurn();
        Assert.assertEquals("AH", poker.getTurnAsString());
        Assert.assertEquals(51, poker.deck.count());
    }

    @Test
    public void testDealRiver() {
        Poker poker = new Poker(new Player("Timothy", 200), 1);
        poker.dealRiver();
        Card expectedRiverCard = new Card("A", "H");
        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedRiverCard, poker.getRiver());
    }

    @Test
    public void testRiverAsString() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealRiver();
        Assert.assertEquals("AH", poker.getRiverAsString());
        Assert.assertEquals(51, poker.deck.count());
    }

    @Test
    public void playerCheckCounter() {
        Poker poker = new Poker(new Player("Timothy", 200), 1);
        poker.incrementCheckCounter();
        Assert.assertEquals(1, poker.getCheckCounter());
    }


}
