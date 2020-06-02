package Tests.TestPoker;

import CardGames.Card;
import CardGames.DeckOfCards;
import CardGames.Poker.PokerGame;
import CardGames.Poker.PokerPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer {
    PokerPlayer hero;
    ArrayList<PokerPlayer> pokerPlayers;
    PokerGame poker;

    @BeforeEach
    public void init() {
        hero = new PokerPlayer("Hero", 200);
        pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        poker = new PokerGame(pokerPlayers);
        poker.setPokerPlayersInHand(poker.getPokerPlayersAtTable());
        poker.dealHoleCards();
    }

    @Test
    public void testPlayerName() {
        assertEquals("Hero", hero.getName());
    }

    @Test
    public void testPlayerHasChips() {
        assertEquals(200, hero.getChipCount());
    }

    @Test
    public void testPlayerHand() {
        DeckOfCards expectedDeck = new DeckOfCards();
        ArrayList expectedHand = new ArrayList<Card>();

        expectedHand.add(expectedDeck.dealTopCard());
        expectedHand.add(expectedDeck.dealTopCard());

        assertEquals(expectedHand, hero.getHand());
    }

    @Test
    public void testCheck() {
        hero.check();

        assertEquals(0, hero.getPlayerBet());
        assertEquals(200, hero.getChipCount());
        assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testFold() {
        poker.playerAction(hero.bet(10));
        hero.fold();

        assertEquals(0, hero.getPlayerBet());
        assertEquals(190, hero.getChipCount());
        assertEquals(0, hero.getHand().size());
    }

    @Test
    public void testCall() {
        poker.setTableBet(2);
        hero.call(poker.getTableBet());

        assertEquals(2, hero.getPlayerBet());
        assertEquals(198, hero.getChipCount());
        assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testBet() {
        hero.bet(10);

        assertEquals(10, hero.getPlayerBet());
        assertEquals(190, hero.getChipCount());
        assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testRaise() {
        poker.setTableBet(10);
        hero.raise(poker.getTableBet(), 40);

        assertEquals(50, hero.getPlayerBet());
        assertEquals(150, hero.getChipCount());
        assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testReraise() {
        poker.playerAction(hero.bet(10));
        poker.setTableBet(50);

        hero.raise(poker.getTableBet(), 100);

        assertEquals(150, hero.getPlayerBet());
        assertEquals(50, hero.getChipCount());
        assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testGetHandAsString() {
        assertTrue(hero.getHandAsString().contains("AH"));
        assertTrue(hero.getHandAsString().contains("KH"));
        assertEquals(2, hero.getHandAsString().size());
    }
}