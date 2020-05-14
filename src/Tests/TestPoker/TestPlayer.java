package Tests.TestPoker;

import CardGames.Card;
import CardGames.DeckOfCards;
import CardGames.Poker.PokerPlayer;
import CardGames.Poker.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestPlayer {

    @Test
    public void testPlayerName() {
        PokerPlayer bob = new PokerPlayer("Bob", 200);
        Assert.assertEquals("Bob", bob.getName());
    }

    @Test
    public void testPlayerHasChips() {
        PokerPlayer jake = new PokerPlayer("Jake", 200);
        Assert.assertEquals(200, jake.getChipCount());
    }

    @Test
    public void testPlayerHand() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        DeckOfCards deck = new DeckOfCards();

        DeckOfCards expectedDeck = new DeckOfCards();
        ArrayList expectedHand = new ArrayList<Card>();
        expectedHand.add(expectedDeck.dealTopCard());
        expectedHand.add(expectedDeck.dealTopCard());

        hero.setHand(deck.dealTopCard());
        hero.setHand(deck.dealTopCard());

        Assert.assertEquals(expectedHand, hero.getHand());
    }

    @Test
    public void testCheck() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);
        poker.dealHoleCards();

        hero.check();

        Assert.assertEquals(0, hero.getPlayerBet());
        Assert.assertEquals(200, hero.getChipCount());
        Assert.assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testFold() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);
        poker.dealHoleCards();

        poker.playerAction(hero.bet(10));

        hero.fold();

        Assert.assertEquals(0, hero.getPlayerBet());
        Assert.assertEquals(190, hero.getChipCount());
        Assert.assertEquals(0, hero.getHand().size());
    }

    @Test
    public void testCall() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        PokerPlayer bettor = new PokerPlayer("Betting Player", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        pokerPlayers.add(bettor);
        Poker poker = new Poker(pokerPlayers);

        poker.dealHoleCards();

        poker.setTableBet(2);

        hero.call(poker.getTableBet());

        Assert.assertEquals(2, hero.getPlayerBet());
        Assert.assertEquals(198, hero.getChipCount());
        Assert.assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testBet() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);
        poker.dealHoleCards();

        hero.bet(10);

        Assert.assertEquals(10, hero.getPlayerBet());
        Assert.assertEquals(190, hero.getChipCount());
        Assert.assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testRaise() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        PokerPlayer bettingPlayer = new PokerPlayer("Bettor", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        pokerPlayers.add(bettingPlayer);
        Poker poker = new Poker(pokerPlayers);
        poker.dealHoleCards();

        poker.playerAction(bettingPlayer.bet(10));

        hero.raise(poker.getTableBet(), 40);

        Assert.assertEquals(50, hero.getPlayerBet());
        Assert.assertEquals(150, hero.getChipCount());
        Assert.assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testReraise() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        PokerPlayer raisingPlayer = new PokerPlayer("Raiser", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        pokerPlayers.add(raisingPlayer);
        Poker poker = new Poker(pokerPlayers);
        poker.dealHoleCards();

        poker.playerAction(hero.bet(10));
        poker.playerAction(raisingPlayer.raise(poker.getTableBet(), 40));

        hero.raise(poker.getTableBet(), 100);

        Assert.assertEquals(150, hero.getPlayerBet());
        Assert.assertEquals(50, hero.getChipCount());
        Assert.assertEquals(2, hero.getHand().size());
    }

    @Test
    public void testGetHandAsString() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);
        poker.dealHoleCards();

        Assert.assertTrue(hero.getHandAsString().contains("AH"));
        Assert.assertTrue(hero.getHandAsString().contains("KH"));
        Assert.assertEquals(2, hero.getHandAsString().size());
    }
}