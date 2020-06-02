package Tests;

import CardGames.Card;
import CardGames.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestDeckOfCards {

    DeckOfCards deck;

    @BeforeEach
    public void init() {
        deck = new DeckOfCards();
    }

    @Test
    public void testNewDeckHas52Cards() {
        assertEquals(52, deck.count());
    }

    @Test
    public void testFindSpecificCard() {
        assertNotEquals("3S", deck.findCard("2S"));
        assertEquals("AD", deck.findCard("AD"));
    }

    @Test
    public void testSuitsInTheDeck() {
        List<String> suits = Arrays.asList( "C", "D", "H", "S");
        assertEquals(suits, deck.getListOfDeckSuits());
    }

    @Test
    public void testRanksInTheDeck() {
        List<String> ranks = Arrays.asList("10", "2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q");
        assertEquals(ranks, deck.getListOfDeckRanks());
    }

    @Test
    public void testListOfCardsInDeck(){
        String[] cards = {"2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AS", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH"};
        assertEquals(Arrays.toString(cards), deck.getListOfAllCardsInDeck());
    }

    @Test
    public void testShuffle() {
        DeckOfCards shuffledDeck = new DeckOfCards();
        shuffledDeck.shuffle();
        assertNotEquals(shuffledDeck.getListOfAllCardsInDeck(), deck.getListOfAllCardsInDeck());
    }

    @Test
    public void testDealOneCard() {
           Card dealtCard = deck.dealTopCard();
            assertEquals(51, deck.count());
            assertEquals(new Card("A", "H"), dealtCard);
        }

    @Test
    public void testDiscardASpecificCardFromTheDeck() {
        deck.discardASpecificCard("8S");
        assertEquals(51, deck.count());
        assertEquals("8S is not in the deck.", deck.findCard("8S"));
        assertEquals("9S", deck.findCard("9S"));
    }

    @Test
    public void testDiscardTopCard() {
        deck.discardTopCard();
        assertEquals(51, deck.count());
        assertEquals("AH is not in the deck.", deck.findCard("AH"));
    }

    @Test
    public void testReturnCard() {
        Card expectedSixOfSpades = new Card("6", "S");
        Card expectedAceOfHearts = new Card("A", "H");

        Card actualSixOfSpades = deck.returnCard("6S");
        Card actualAceOfHearts = deck.returnCard("AH");

        assertEquals(expectedSixOfSpades, actualSixOfSpades);
        assertEquals(expectedAceOfHearts, actualAceOfHearts);
    }
}