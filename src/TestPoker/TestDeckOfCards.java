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
    public void testDeckHasAllUniqueCards() {
        DeckOfCards deck = new DeckOfCards();
        Assert.assertTrue(deck.isDistinct());
    }

    @Test
    public void testDeckHas4Suits(){
        DeckOfCards deck = new DeckOfCards();


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

