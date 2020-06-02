package Tests;

import CardGames.Card;
import CardGames.DeckOfCards;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestCard {
    DeckOfCards deck;
    Card eightOfDiamonds;

    @BeforeEach
    public void init() {
         deck = new DeckOfCards();
         eightOfDiamonds = new Card("8", "D");
    }

    @Test
    public void testCardRank() {
        assertEquals("8", eightOfDiamonds.getRank());
    }

    @Test
    public void testCardSuit() {
        assertEquals("D", eightOfDiamonds.getSuit());
    }
}
