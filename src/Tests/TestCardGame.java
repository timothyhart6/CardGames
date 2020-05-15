package Tests;

import CardGames.Card;
import CardGames.CardGame;
import org.junit.Assert;
import org.junit.Test;

public class TestCardGame {

    @Test
    public void testPokerValueOfCard() {

        CardGame cardGame = new CardGame();
//        Card jackOfHearts = new Card("J", "H");

        cardGame.setCardValues();
       Card jackOfHearts = (Card) cardGame.deck.getDeck().get(3);

        Assert.assertEquals(11, jackOfHearts.getValue());
    }
}
