package Tests;

import CardGames.Card;
import CardGames.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

public class TestCard {
//    @Test
//    public void testCardHasNumericalValue () {
//        DeckOfCards deck = new DeckOfCards();
//        Card jackOfDiamonds = new Card("J", "D");
//        int value = deck.getCardNumericalValue(jackOfDiamonds);
//        Assert.assertEquals(11, value);
//    }

    @Test
    public void testCardRank() {
        DeckOfCards deck = new DeckOfCards();
        Card eightOfDiamonds = new Card("8", "D");
        Assert.assertEquals("8", eightOfDiamonds.getRank());
    }

    @Test
    public void testCardSuit() {
        DeckOfCards deck = new DeckOfCards();
        Card eightOfDiamonds = new Card("8", "D");
        Assert.assertEquals("D", eightOfDiamonds.getSuit());
    }
}
