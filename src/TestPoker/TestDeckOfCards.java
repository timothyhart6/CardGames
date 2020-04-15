package TestPoker;

import Poker.Card;
import Poker.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;


public class TestDeckOfCards {

    @Test
    public void testDeckHas52Cards() {
        DeckOfCards deck = new DeckOfCards();
        Assert.assertEquals(52, deck.count());
    }

    @Test
    public void testFindSpecificCard() {
        DeckOfCards deck = new DeckOfCards();
        Assert.assertNotEquals("3S", deck.findCard("2S"));
        Assert.assertEquals("AD", deck.findCard("AD"));
    }

    @Test
    public void testMultipleCardsCanHaveIdenticalNumericalValues () {
        DeckOfCards deck = new DeckOfCards();
        Card jackOfDiamonds = new Card("J", "D");
        Card jackOfHearts = new Card("J", "H");
        Assert.assertEquals(11, deck.getCardNumericalValue(jackOfDiamonds));
        Assert.assertEquals(11, deck.getCardNumericalValue(jackOfHearts));
        Assert.assertNotEquals(8, deck.getCardNumericalValue(jackOfHearts));
    }
}


