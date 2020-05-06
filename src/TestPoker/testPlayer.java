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

        ArrayList expectedHand = new ArrayList<Card>();
        expectedHand.add(new Card("A", "H"));
        expectedHand.add(new Card("K", "H"));

        tommy.check();
        Assert.assertEquals(200, tommy.getChipCount());
        Assert.assertEquals(expectedHand, tommy.getHand());
    }

    @Test
    public void testPlaceBet() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        poker.dealHoleCards();

        ArrayList expectedHand = new ArrayList<Card>();
        expectedHand.add(new Card("A", "H"));
        expectedHand.add(new Card("K", "H"));

        tommy.bet(10);
        Assert.assertEquals(190, tommy.getChipCount());
        Assert.assertEquals(expectedHand, tommy.getHand());
    }

    @Test
    public void testRaise() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);

        ArrayList expectedHand = new ArrayList<Card>();
        expectedHand.add(new Card("A", "H"));
        expectedHand.add(new Card("K", "H"));

        poker.dealHoleCards();
        tommy.bet(10);
        tommy.raise(100);
        Assert.assertEquals(90, tommy.getChipCount());
        Assert.assertEquals(expectedHand, tommy.getHand());
    }

    @Test
    public void testFold() {
        Player tommy = new Player("Tommy", 200);
        Poker poker = new Poker(tommy, 1);
        ArrayList emptyHand = new ArrayList<Card>();
        poker.dealHoleCards();
        tommy.bet(10);
        tommy.fold();
        Assert.assertEquals(190, tommy.getChipCount());
        Assert.assertEquals(emptyHand, tommy.getHand());
    }

    @Test
    public void testGetHandAsString() {
        Assert.assertEquals(1, 0);
    }


}
