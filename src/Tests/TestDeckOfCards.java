package Tests;

import CardGames.DeckOfCards;
import CardGames.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TestDeckOfCards {

    @Test
    public void testNewDeckHas52Cards() {
        DeckOfCards deck = new DeckOfCards();
        Assert.assertEquals(52, deck.count());
    }

    @Test
    public void testFindSpecificCard() {
        DeckOfCards deck = new DeckOfCards();
        Assert.assertNotEquals("3S", deck.findCard("2S"));
        Assert.assertEquals("AD", deck.findCard("AD"));
    }
// ### MOVE TO GAME TEST SUITE ###
//    @Test
//    public void testMultipleCardsCanHaveIdenticalNumericalValues() {
//        DeckOfCards deck = new DeckOfCards();
//        Card jackOfDiamonds = new Card("J", "D");
//        Card jackOfHearts = new Card("J", "H");
//        Assert.assertEquals(11, deck.getCardNumericalValue(jackOfDiamonds));
//        Assert.assertEquals(11, deck.getCardNumericalValue(jackOfHearts));
//        Assert.assertNotEquals(8, deck.getCardNumericalValue(jackOfHearts));
//    }

    @Test
    public void testSuitsInTheDeck() {
        DeckOfCards deck = new DeckOfCards();
        List<String> suits = Arrays.asList( "C", "D", "H", "S");
        Assert.assertEquals(suits, deck.getListOfDeckSuits());
        }

    @Test
    public void testRanksInTheDeck() {
        DeckOfCards deck = new DeckOfCards();
        List<String> ranks = Arrays.asList("10", "2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q");
        Assert.assertEquals(ranks, deck.getListOfDeckRanks());
    }

    @Test
    public void testListOfCardsInDeck(){
        DeckOfCards deck = new DeckOfCards();
        String[] cards = {"2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AS", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH"};
        Assert.assertEquals(Arrays.toString(cards), deck.getListOfAllCardsInDeck());
    }

    @Test
    public void testShuffle() {
        DeckOfCards deck = new DeckOfCards();
        DeckOfCards shuffledDeck = new DeckOfCards();
        shuffledDeck.shuffle();
        Assert.assertNotEquals(shuffledDeck.getListOfAllCardsInDeck(), deck.getListOfAllCardsInDeck());
    }

    @Test
    public void testDealOneCard() {
        DeckOfCards deck = new DeckOfCards();
           Card dealtCard = deck.dealTopCard();
            Assert.assertEquals(51, deck.count());
            Assert.assertEquals(new Card("A", "H"), dealtCard);
        }


    @Test
    public void testDiscardASpecificCardFromTheDeck() {
        DeckOfCards deck = new DeckOfCards();
        deck.discardASpecificCard("8S");
        Assert.assertEquals(51, deck.count());
        Assert.assertEquals("8S is not in the deck.", deck.findCard("8S"));
        Assert.assertEquals("9S", deck.findCard("9S"));
    }

    @Test
    public void testDiscardTopCard() {
        DeckOfCards deck = new DeckOfCards();
        deck.discardTopCard();
        Assert.assertEquals(51, deck.count());
        Assert.assertEquals("AH is not in the deck.", deck.findCard("AH"));
    }

}


