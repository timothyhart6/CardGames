package TestPoker;

import Poker.Card;
import Poker.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


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
    public void testMultipleCardsCanHaveIdenticalNumericalValues() {
        DeckOfCards deck = new DeckOfCards();
        Card jackOfDiamonds = new Card("J", "D");
        Card jackOfHearts = new Card("J", "H");
        Assert.assertEquals(11, deck.getCardNumericalValue(jackOfDiamonds));
        Assert.assertEquals(11, deck.getCardNumericalValue(jackOfHearts));
        Assert.assertNotEquals(8, deck.getCardNumericalValue(jackOfHearts));
    }

    @Test
    public void testSuitsInTheDeck() {
        DeckOfCards deck = new DeckOfCards();
        List<String> suits = Arrays.asList( "C", "D", "H", "S");
        Assert.assertEquals(deck.getListOfDeckSuits(), suits);
        }

    @Test
    public void testFaceValuesInTheDeck() {
        DeckOfCards deck = new DeckOfCards();
        List<String> faceValues = Arrays.asList("10", "2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q");
        Assert.assertEquals(deck.getListOfDeckFaceValues(), faceValues);
    }

}


