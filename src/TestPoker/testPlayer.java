package TestPoker;

import Poker.Card;
import Poker.DeckOfCards;
import Poker.Player;
import org.junit.Assert;
import org.junit.Test;

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
        Card[] dealtHand= {deck.dealTopCard(), deck.dealTopCard()};
        Card[] hand = {identicalDeckToBeDealt.dealTopCard(), identicalDeckToBeDealt.dealTopCard()};
        tommy.setHand(hand);
        Assert.assertEquals(dealtHand, tommy.getHand());
    }
}
