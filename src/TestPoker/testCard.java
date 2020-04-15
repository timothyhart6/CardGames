package TestPoker;
import Poker.DeckOfCards;
import Poker.Card;
import org.junit.Assert;
import org.junit.Test;

public class testCard {
    @Test
    public void testCardHasNumericalValue () {
        DeckOfCards deck = new DeckOfCards();
        Card jackOfDiamonds = new Card("J", "D");
        int value = deck.getCardNumericalValue(jackOfDiamonds);
        Assert.assertEquals(11, value);
    }

}
