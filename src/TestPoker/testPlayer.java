package TestPoker;

import Poker.Card;
import Poker.DeckOfCards;
import Poker.Player;
import org.junit.Assert;
import org.junit.Test;

public class testPlayer {

    @Test
    public void testPLayerName() {
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
        DeckOfCards deck = new DeckOfCards();
        DeckOfCards newDeck = new DeckOfCards();
        Player tommy = new Player("Tommy", 200);
        Card[] dealtHand= {deck.dealOneCard(), deck.dealOneCard()};
        Card cardOne = newDeck.dealOneCard();
        Card cardTwo = newDeck.dealOneCard();
        tommy.setHand(Card[] = {cardOne, cardTwo});
        Assert.assertEquals(dealtHand, tommy.getHand());
    }
}
