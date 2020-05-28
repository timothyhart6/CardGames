package Tests.TestPoker;

import CardGames.Card;
import CardGames.Poker.PokerGame;
import CardGames.Poker.PokerPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestPokerGame {

    @Test
    public void testPokerCardValues() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        PokerGame poker = new PokerGame(pokerPlayers);

        Card sixOfClubs =  poker.deck.returnCard("6C");
        Card aceOfHearts = poker.deck.returnCard("AH");
        Card jackOfSpades = poker.deck.returnCard("JS");
        Card jackOfHearts = poker.deck.returnCard("JH");

        Assert.assertEquals(6, sixOfClubs.getValue());
        Assert.assertEquals(14, aceOfHearts.getValue());
        Assert.assertEquals(11, jackOfSpades.getValue());
        Assert.assertEquals(11, jackOfHearts.getValue());
    }

    @Test
    public void testPlayerAction() {
        PokerPlayer checkingPlayer = new PokerPlayer("Check", 200);
        PokerPlayer foldingPlayer = new PokerPlayer("Fold", 200);
        PokerPlayer callingPlayer = new PokerPlayer("calling", 200);
        PokerPlayer bettingPlayer = new PokerPlayer("Bet", 200);
        PokerPlayer raisingPlayer = new PokerPlayer("Raise", 200);

        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(checkingPlayer);
        pokerPlayers.add(foldingPlayer);
        pokerPlayers.add(callingPlayer);
        pokerPlayers.add(bettingPlayer);
        pokerPlayers.add(raisingPlayer);

        PokerGame poker = new PokerGame(pokerPlayers);
        poker.setPokerPlayersInHand(poker.getPokerPlayersAtTable());
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
        PokerPlayer player1 = new PokerPlayer("Player 1", 200);
        PokerPlayer player2 = new PokerPlayer("Player 2", 200);
        PokerPlayer player3 = new PokerPlayer("Player 3", 200);

        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(player1);
        pokerPlayers.add(player2);
        pokerPlayers.add(player3);
        PokerGame poker = new PokerGame(pokerPlayers);
        poker.setPokerPlayersInHand(poker.getPokerPlayersAtTable());
        poker.dealHoleCards();

        player1 = poker.getPokerPlayersInHand().get(0);
        player2 = poker.getPokerPlayersInHand().get(1);
        player3 = poker.getPokerPlayersInHand().get(2);

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
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        PokerGame poker = new PokerGame(pokerPlayers);

        poker.burnCard();

        Assert.assertEquals(51, poker.deck.count());
    }

    @Test
    public void  testDealFlop() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        PokerGame poker = new PokerGame(pokerPlayers);

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
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        PokerGame poker = new PokerGame(pokerPlayers);

        ArrayList<Card>expectedTurn = new ArrayList<Card>();
        expectedTurn.add(new Card("A", "H"));

        poker.dealTurn();

        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedTurn, poker.getCommunityCards());
    }

    @Test
    public void testDealRiver() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        PokerGame poker = new PokerGame(pokerPlayers);

        ArrayList<Card> expectedRiver = new ArrayList<Card>();
        expectedRiver.add(new Card("A", "H"));

        poker.dealRiver();

        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedRiver, poker.getCommunityCards());
    }

    @Test
    public void testDisplayCommunityCards() {
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        PokerGame poker = new PokerGame(pokerPlayers);

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
        PokerPlayer hero = new PokerPlayer("Hero", 200);
        ArrayList<PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
        PokerGame poker = new PokerGame(pokerPlayers);
        poker.incrementCheckCounter();

        Assert.assertEquals(1, poker.getCheckCounter());
    }
}