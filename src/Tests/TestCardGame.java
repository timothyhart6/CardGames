package Tests;

import CardGames.Card;
import CardGames.CardGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestCardGame {

    CardGame cardGame;

    @BeforeEach
    public void init() {
        cardGame = new CardGame();
    }
    
    @Test
    public void testCardValues() {
        Card sixOfClubs =  cardGame.deck.returnCard("6C");
        Card aceOfHearts = cardGame.deck.returnCard("AH");
        Card jackOfSpades = cardGame.deck.returnCard("JS");
        Card jackOfHearts = cardGame.deck.returnCard("JH");

        assertEquals(6, sixOfClubs.getValue());
        assertEquals(1, aceOfHearts.getValue());
        assertEquals(11, jackOfSpades.getValue());
        assertEquals(11, jackOfHearts.getValue());
    }
}
