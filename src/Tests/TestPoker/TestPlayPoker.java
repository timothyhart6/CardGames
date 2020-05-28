package Tests.TestPoker;

import CardGames.Poker.PlayPoker;
import CardGames.Poker.PokerGame;
import CardGames.Poker.PokerPlayer;
import org.junit.Assert;
import org.junit.Test;

public class TestPlayPoker {

    @Test
    public void testCreateArrayOfPokerPlayers() {
        int numberOfPokerPlayers = 2;
        PlayPoker playPoker = new PlayPoker();

        playPoker.createPokerPlayers(numberOfPokerPlayers);

        PokerPlayer expectedPlayerOne = new PokerPlayer("Player 1", 200);
        PokerPlayer expectedPlayerTwo= new PokerPlayer("Player 2", 200);

        Assert.assertEquals(2, playPoker.getPokerPlayers().size());
        Assert.assertEquals(expectedPlayerOne.getName(), playPoker.getPokerPlayers().get(0).getName());
        Assert.assertEquals(expectedPlayerTwo.getName(), playPoker.getPokerPlayers().get(1).getName());
        Assert.assertEquals(expectedPlayerOne.getChipCount(), playPoker.getPokerPlayers().get(0).getChipCount());
        Assert.assertEquals(expectedPlayerTwo.getChipCount(), playPoker.getPokerPlayers().get(1).getChipCount());
    }

    @Test
    public void testCompleteBettingRound() {
        PlayPoker playPoker = new PlayPoker();
        playPoker.createPokerPlayers(3);
        PokerGame pokerGame = new PokerGame(playPoker.getPokerPlayers());
        pokerGame.setPokerPlayersInHand(pokerGame.getPokerPlayersAtTable());

        playPoker.completeBettingRound(pokerGame);

        Assert.assertEquals(3, playPoker.getPlayerActions().length);


    }
}
