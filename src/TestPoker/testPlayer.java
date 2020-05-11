package TestPoker;

import Poker.Card;
import Poker.DeckOfCards;
import Poker.Player;
import Poker.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testPlayer {

    @Test
    public void testPlayerName() {
        Player bob = new Player("Bob", 200);
        Assert.assertEquals("Bob", bob.getName());
    }

    @Test
    public void testPlayerHasChips() {
        Player jake = new Player("Jake", 200);
        Assert.assertEquals(200, jake.getChipCount());
    }

    @Test
    public void testPlayerHand() {
        Player tommy = new Player("Tommy", 200);
        DeckOfCards deck = new DeckOfCards();
        DeckOfCards identicalDeckToBeDealt = new DeckOfCards();

        ArrayList dealtHand= new ArrayList<Card>();
        dealtHand.add(deck.dealTopCard());
        dealtHand.add(deck.dealTopCard());

        ArrayList hand = new ArrayList<Card>();
        hand.add(identicalDeckToBeDealt.dealTopCard());
        hand.add(identicalDeckToBeDealt.dealTopCard());

        tommy.setHand(hand);
        Assert.assertEquals(dealtHand, tommy.getHand());
    }

    @Test
    public void testCheck() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealHoleCards();

        tommy.check();

        Assert.assertEquals(0, tommy.getPlayerBet());
        Assert.assertEquals(200, tommy.getChipCount());
        Assert.assertEquals(2, tommy.getHand().size());
    }

    @Test
    public void testFold() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealHoleCards();
        poker.playerAction(tommy.bet(10));

        tommy.fold();

        Assert.assertEquals(0, tommy.getPlayerBet());
        Assert.assertEquals(190, tommy.getChipCount());
        Assert.assertEquals(0, tommy.getHand().size());

    }

    @Test
    public void testCall() {
        Player tommy = new Player("Tommy", 200);
        Player bettor = new Player("Betting Player", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealHoleCards();
        poker.setTableBet(2);

        tommy.call(poker.getTableBet());

        Assert.assertEquals(2, tommy.getPlayerBet());
        Assert.assertEquals(198, tommy.getChipCount());
        Assert.assertEquals(2, tommy.getHand().size());
    }

    @Test
    public void testBet() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealHoleCards();

        tommy.bet(10);

        Assert.assertEquals(10, tommy.getPlayerBet());
        Assert.assertEquals(190, tommy.getChipCount());
        Assert.assertEquals(2, tommy.getHand().size());
    }

    @Test
    public void testRaise() {
        Player tommy = new Player("Tommy", 200);
        Player bettingPlayer = new Player("Bettor", 200);

        Poker poker = new Poker(tommy, 1);
        poker.dealHoleCards();
        poker.playerAction(tommy.bet(10));

        tommy.raise(poker.getTableBet(), 100);

        Assert.assertEquals(110, tommy.getPlayerBet());
//        Test chip count for raise and reraise (before raise, player bet is 0, player bet is > 0)
        Assert.assertEquals(0, tommy.getChipCount());
        Assert.assertEquals(2, tommy.getHand().size());
    }

    @Test
    public void testGetHandAsString() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealHoleCards();
        Assert.assertTrue(tommy.getHandAsString().contains("AH"));
        Assert.assertTrue(tommy.getHandAsString().contains("KH"));
        Assert.assertEquals(2, tommy.getHandAsString().size());
    }
}