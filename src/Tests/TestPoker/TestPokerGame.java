package Tests.TestPoker;

import CardGames.Card;
import CardGames.Poker.PokerGame;
import CardGames.Poker.PokerPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPokerGame {
    PokerPlayer hero;
    ArrayList<PokerPlayer> pokerPlayers;
    PokerGame poker;

    PokerPlayer checkingPlayer;
    PokerPlayer foldingPlayer;
    PokerPlayer callingPlayer;
    PokerPlayer bettingPlayer;
    PokerPlayer raisingPlayer;

    @BeforeEach
    public void init() {
        hero = new PokerPlayer("Hero", 200);
        pokerPlayers = new ArrayList<PokerPlayer>();
        pokerPlayers.add(hero);
         checkingPlayer = new PokerPlayer("Check", 200);
         foldingPlayer = new PokerPlayer("Fold", 200);
         callingPlayer = new PokerPlayer("calling", 200);
         bettingPlayer = new PokerPlayer("Bet", 200);
         raisingPlayer = new PokerPlayer("Raise", 200);

        pokerPlayers.add(checkingPlayer);
        pokerPlayers.add(foldingPlayer);
        pokerPlayers.add(callingPlayer);
        pokerPlayers.add(bettingPlayer);
        pokerPlayers.add(raisingPlayer);

        poker = new PokerGame(pokerPlayers);
//        poker.setPokerPlayersInHand(poker.getPokerPlayersAtTable());


    }

    @Test
    public void testPokerCardValues() {
        Card sixOfClubs =  poker.deck.returnCard("6C");
        Card aceOfHearts = poker.deck.returnCard("AH");
        Card jackOfSpades = poker.deck.returnCard("JS");
        Card jackOfHearts = poker.deck.returnCard("JH");

        assertEquals(6, sixOfClubs.getValue());
        assertEquals(14, aceOfHearts.getValue());
        assertEquals(11, jackOfSpades.getValue());
        assertEquals(11, jackOfHearts.getValue());
    }

    @Test
    public void testPlayerAction() {
//        PokerPlayer checkingPlayer = new PokerPlayer("Check", 200);
//        PokerPlayer foldingPlayer = new PokerPlayer("Fold", 200);
//        PokerPlayer callingPlayer = new PokerPlayer("calling", 200);
//        PokerPlayer bettingPlayer = new PokerPlayer("Bet", 200);
//        PokerPlayer raisingPlayer = new PokerPlayer("Raise", 200);
//
//        pokerPlayers.add(checkingPlayer);
//        pokerPlayers.add(foldingPlayer);
//        pokerPlayers.add(callingPlayer);
//        pokerPlayers.add(bettingPlayer);
//        pokerPlayers.add(raisingPlayer);

//        PokerGame poker = new PokerGame(pokerPlayers);
//        poker.setPokerPlayersInHand(poker.getPokerPlayersAtTable());
//        poker.dealHoleCards();

        poker.playerAction(checkingPlayer.check());

        assertEquals(0, checkingPlayer.getPlayerBet());
        assertEquals(0, poker.getTableBet());

        poker.playerAction(bettingPlayer.bet(5));
        assertEquals(5, bettingPlayer.getPlayerBet());
        assertEquals(5, poker.getTableBet());

        poker.playerAction(raisingPlayer.raise(poker.getTableBet(), 15));
        assertEquals(20, raisingPlayer.getPlayerBet());
        assertEquals(20, poker.getTableBet());

        poker.playerAction(foldingPlayer.fold());
        assertEquals(0, foldingPlayer.getPlayerBet());
        assertEquals(20, poker.getTableBet());

        poker.playerAction(callingPlayer.call(poker.getTableBet()));
        assertEquals(20, callingPlayer.getPlayerBet());
        assertEquals(20, poker.getTableBet());
    }
    @Test
    public void testDealHoleCards() {
        poker.setPokerPlayersInHand(poker.getPokerPlayersAtTable());
        poker.dealHoleCards();

        PokerPlayer player1 = poker.getPokerPlayersInHand().get(0);
        PokerPlayer player2 = poker.getPokerPlayersInHand().get(1);
        PokerPlayer player3 = poker.getPokerPlayersInHand().get(2);

        assertTrue(player1.getHand().contains(new Card("A", "H")));
        assertTrue(player2.getHand().contains(new Card("K", "H")));
        assertTrue(player3.getHand().contains(new Card("Q", "H")));
        assertTrue(player1.getHand().contains(new Card("8", "H")));
        assertTrue(player2.getHand().contains(new Card("7", "H")));
        assertTrue(player3.getHand().contains(new Card("6", "H")));

        assertEquals(40, poker.deck.count());
        assertEquals(2, player1.getHand().size());
        assertEquals(2, player2.getHand().size());
        assertEquals(2, player3.getHand().size());
    }

    @Test
    public void testBurnCard() {
        poker.burnCard();

        assertEquals(51, poker.deck.count());
    }

    @Test
    public void  testDealFlop() {
        ArrayList<Card>expectedFlop = new ArrayList<Card>();
        expectedFlop.add(new Card("A", "H"));
        expectedFlop.add(new Card("K", "H"));
        expectedFlop.add(new Card("Q", "H"));

        poker.dealFlop();

        assertEquals(49, poker.deck.count());
        assertEquals(expectedFlop, poker.getCommunityCards());
    }

    @Test
    public void testDealTurn() {
        ArrayList<Card>expectedTurn = new ArrayList<Card>();
        expectedTurn.add(new Card("A", "H"));

        poker.dealTurn();

        assertEquals(51, poker.deck.count());
        assertEquals(expectedTurn, poker.getCommunityCards());
    }

    @Test
    public void testDealRiver() {
        ArrayList<Card> expectedRiver = new ArrayList<Card>();
        expectedRiver.add(new Card("A", "H"));

        poker.dealRiver();

        assertEquals(51, poker.deck.count());
        assertEquals(expectedRiver, poker.getCommunityCards());
    }

    @Test
    public void testDisplayCommunityCards() {
        ArrayList<String>expectedCommunityCards = new ArrayList<String>();
        expectedCommunityCards.add("AH");
        expectedCommunityCards.add("KH");
        expectedCommunityCards.add("QH");
        expectedCommunityCards.add("JH");
        expectedCommunityCards.add("10H");

        poker.dealFlop();
        poker.dealTurn();
        poker.dealRiver();

        assertEquals(expectedCommunityCards, poker.displayCommunityCards());
        assertEquals(47, poker.deck.count());
    }

    @Test
    public void playerCheckCounter() {
        poker.incrementCheckCounter();

        assertEquals(1, poker.getCheckCounter());
    }
}