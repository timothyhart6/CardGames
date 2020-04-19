package TestPoker;

import Poker.Card;
import Poker.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

public class testCard {
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
