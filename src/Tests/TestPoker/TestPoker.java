package Tests.TestPoker;

import CardGames.Card;
import CardGames.Poker.Player;
import CardGames.Poker.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestPoker {

    @Test
    public void testPlayerAction() {
        Player checkingPlayer = new Player("Check", 200);
        Player foldingPlayer = new Player("Fold", 200);
        Player callingPlayer = new Player("calling", 200);
        Player bettingPlayer = new Player("Bet", 200);
        Player raisingPlayer = new Player("Raise", 200);

        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(checkingPlayer);
        pokerPlayers.add(foldingPlayer);
        pokerPlayers.add(callingPlayer);
        pokerPlayers.add(bettingPlayer);
        pokerPlayers.add(raisingPlayer);

        Poker poker = new Poker(pokerPlayers);
        poker.dealHoleCards();

        poker.playerAction(checkingPlayer.check());
        Assert.assertEquals(0, checkingPlayer.getPlayerBet());
        Assert.assertEquals(0, poker.getTableBet());

        poker.playerAction(bettingPlayer.bet(5));
        Assert.assertEquals(5, bettingPlayer.getPlayerBet());
        Assert.assertEquals(5, poker.getTableBet());

        poker.playerAction(raisingPlayer.raise(poker.getTableBet(), 15));
        Assert.assertEquals(20, raisingPlayer.getPlayerBet());
        Assert.assertEquals(20, poker.getTableBet());

        poker.playerAction(foldingPlayer.fold());
        Assert.assertEquals(0, foldingPlayer.getPlayerBet());
        Assert.assertEquals(20, poker.getTableBet());

        poker.playerAction(callingPlayer.call(poker.getTableBet()));
        Assert.assertEquals(20, callingPlayer.getPlayerBet());
        Assert.assertEquals(20, poker.getTableBet());
    }
    @Test
    public void testDealHoleCards() {
        Player player1 = new Player("Player 1", 200);
        Player player2 = new Player("Player 2", 200);
        Player player3 = new Player("Player 3", 200);

        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(player1);
        pokerPlayers.add(player2);
        pokerPlayers.add(player3);
        Poker poker = new Poker(pokerPlayers);

        poker.dealHoleCards();

        Assert.assertTrue(player1.getHand().contains(new Card("A", "H")));
        Assert.assertTrue(player2.getHand().contains(new Card("K", "H")));
        Assert.assertTrue(player3.getHand().contains(new Card("Q", "H")));
        Assert.assertTrue(player1.getHand().contains(new Card("J", "H")));
        Assert.assertTrue(player2.getHand().contains(new Card("10", "H")));
        Assert.assertTrue(player3.getHand().contains(new Card("9", "H")));
        Assert.assertEquals(46, poker.deck.count());
        Assert.assertEquals(2, player1.getHand().size());
        Assert.assertEquals(2, player2.getHand().size());
        Assert.assertEquals(2, player3.getHand().size());
    }

    @Test
    public void testBurnCard() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        poker.burnCard();

        Assert.assertEquals(51, poker.deck.count());
    }

    @Test
    public void  testDealFlop() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        ArrayList<Card>expectedFlop = new ArrayList<Card>();
        expectedFlop.add(new Card("A", "H"));
        expectedFlop.add(new Card("K", "H"));
        expectedFlop.add(new Card("Q", "H"));

        poker.dealFlop();

        Assert.assertEquals(49, poker.deck.count());
        Assert.assertEquals(expectedFlop, poker.getCommunityCards());
    }

    @Test
    public void testDealTurn() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        ArrayList<Card>expectedTurn = new ArrayList<Card>();
        expectedTurn.add(new Card("A", "H"));

        poker.dealTurn();

        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedTurn, poker.getCommunityCards());
    }

    @Test
    public void testDealRiver() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        ArrayList<Card> expectedRiver = new ArrayList<Card>();
        expectedRiver.add(new Card("A", "H"));

        poker.dealRiver();

        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedRiver, poker.getCommunityCards());
    }

    @Test
    public void testDisplayCommunityCards() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        ArrayList<String>expectedCommunityCards = new ArrayList<String>();
        expectedCommunityCards.add("AH");
        expectedCommunityCards.add("KH");
        expectedCommunityCards.add("QH");
        expectedCommunityCards.add("JH");
        expectedCommunityCards.add("10H");

        poker.dealFlop();
        poker.dealTurn();
        poker.dealRiver();

        Assert.assertEquals(expectedCommunityCards, poker.displayCommunityCards());
        Assert.assertEquals(47, poker.deck.count());
    }

    @Test
    public void playerCheckCounter() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);
        poker.incrementCheckCounter();

        Assert.assertEquals(1, poker.getCheckCounter());
    }
}