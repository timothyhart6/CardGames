package TestPoker;

import Poker.Poker;
import Poker.Player;
import Poker.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testPoker {

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
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        poker.dealHoleCards();
        Assert.assertTrue(hero.getHand().contains(new Card("A", "H")));
        Assert.assertTrue(hero.getHand().contains(new Card("K", "H")));
        Assert.assertEquals(50, poker.deck.count());
        Assert.assertEquals(2, hero.getHand().size());
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

        poker.dealFlop();
        Card[] expectedFlopCards = {new Card("A", "H"), new Card("K", "H"), new Card("Q", "H")};
        Assert.assertEquals(49, poker.deck.count());
        Assert.assertEquals(expectedFlopCards, poker.getFlop());
    }

    @Test
    public void testFlopAsString() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        poker.dealFlop();

        ArrayList expectedFlop = new ArrayList();
        expectedFlop.add("AH");
        expectedFlop.add("KH");
        expectedFlop.add("QH");

        Assert.assertEquals(expectedFlop, poker.getFlopAsString());
        Assert.assertEquals(49, poker.deck.count());
    }

    @Test
    public void testDealTurn() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        poker.dealTurn();

        Card expectedTurnCard = new Card("A", "H");

        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedTurnCard, poker.getTurn());
    }

    @Test
    public void testTurnAsString() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        poker.dealTurn();

        Assert.assertEquals("AH", poker.getTurnAsString());
        Assert.assertEquals(51, poker.deck.count());
    }

    @Test
    public void testDealRiver() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        poker.dealRiver();

        Card expectedRiverCard = new Card("A", "H");

        Assert.assertEquals(51, poker.deck.count());
        Assert.assertEquals(expectedRiverCard, poker.getRiver());
    }

    @Test
    public void testRiverAsString() {
        Player hero = new Player("Hero", 200);
        ArrayList<Player> pokerPlayers = new ArrayList<Player>();
        pokerPlayers.add(hero);
        Poker poker = new Poker(pokerPlayers);

        poker.dealRiver();

        Assert.assertEquals("AH", poker.getRiverAsString());
        Assert.assertEquals(51, poker.deck.count());
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