package Tests;

import CardGames.Card;
import CardGames.CardGame;
import org.junit.Assert;
import org.junit.Test;

public class TestCardGame {

    @Test
    public void testCardValues() {

        CardGame cardGame = new CardGame();

        Card sixOfClubs =  cardGame.deck.returnCard("6C");
        Card aceOfHearts = cardGame.deck.returnCard("AH");
        Card jackOfSpades = cardGame.deck.returnCard("JS");
        Card jackOfHearts = cardGame.deck.returnCard("JH");

        Assert.assertEquals(6, sixOfClubs.getValue());
        Assert.assertEquals(1, aceOfHearts.getValue());
        Assert.assertEquals(11, jackOfSpades.getValue());
        Assert.assertEquals(11, jackOfHearts.getValue());
    }
}
