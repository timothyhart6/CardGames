package TestPoker;

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
    public void cardHasNumericalValue() {
        DeckOfCards deck = new DeckOfCards();
        Assert.assertEquals(11, deck.cardNumericalValue("J", "D"));
        Assert.assertEquals(4, deck.cardNumericalValue("4", "H"));

    }

    @Test
    public void testMultipleCardsCanHaveNumericalValues () {
        DeckOfCards deck = new DeckOfCards();
        Assert.assertEquals(11, deck.cardNumericalValue("J", "H"));
        Assert.assertEquals(11, deck.cardNumericalValue("J", "C"));
        Assert.assertNotEquals(8, deck.cardNumericalValue("9", "H"));
    }
}

//    @Test
//    public void testCardHasASuit() {
//        Card card = new Card("A","H");
//        Assert.assertEquals("H", card.getSuit());
//    }
//
//    @Test
//    public void testCardHasAFaceValue() {
//        Card card = new Card("A","H");
//        Assert.assertEquals("A", card.getFaceValue());
//    }

