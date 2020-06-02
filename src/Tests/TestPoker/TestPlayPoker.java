package Tests.TestPoker;

import CardGames.Poker.PlayPoker;
import CardGames.Poker.PokerGame;
import CardGames.Poker.PokerPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestPlayPoker {

    PlayPoker playPoker;
    PokerGame pokerGame;
    
    @BeforeEach
    public void init() {
        playPoker = new PlayPoker();
        playPoker.createPokerPlayers(2);
        pokerGame = new PokerGame(playPoker.getPokerPlayers());
        pokerGame.setPokerPlayersInHand(pokerGame.getPokerPlayersAtTable());
    }

    @Test
    public void testCreateArrayOfPokerPlayers() {
        PokerPlayer expectedPlayerOne = new PokerPlayer("Player 1", 200);
        PokerPlayer expectedPlayerTwo= new PokerPlayer("Player 2", 200);

        assertEquals(2, playPoker.getPokerPlayers().size());
        assertEquals(expectedPlayerOne.getName(), playPoker.getPokerPlayers().get(0).getName());
        assertEquals(expectedPlayerTwo.getName(), playPoker.getPokerPlayers().get(1).getName());
        assertEquals(expectedPlayerOne.getChipCount(), playPoker.getPokerPlayers().get(0).getChipCount());
        assertEquals(expectedPlayerTwo.getChipCount(), playPoker.getPokerPlayers().get(1).getChipCount());
    }

    @Test
    public void testCompleteBettingRound() {
        playPoker.completeBettingRound(pokerGame);

        assertEquals(2, playPoker.getPlayerActions().length);
    }
}
