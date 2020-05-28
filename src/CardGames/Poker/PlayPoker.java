package CardGames.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class PlayPoker {
    ArrayList <PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();
    String[] playerActions;

    public String[] getPlayerActions() {
        return playerActions;
    }



    public static void main(String[] args) {
/*
//        Scanner reader = new Scanner(System.in);

        //Get player (name, chip count), number of opponents, and create a new game of poker
        System.out.println("Enter your name: ");
        String playerName = reader.next();
        System.out.println("Hello " + playerName + ". How many chips are you buying in for?");

        int chipCount = reader.nextInt();

     System.out.println("You're buying in for " + chipCount + " chips.");
        System.out.println("How many players are at the table?");

        int playerCount = reader.nextInt();

        Player player = new Player(playerName, chipCount);
        CardGames.Poker poker = new CardGames.Poker(player, playerCount);

        //Play one round of poker (minus blinds and position)
        poker.deck.shuffle();
        poker.dealHoleCards();

        System.out.println("The Hole cards have been dealt.  This is your hand: \n" + poker.humanPlayer.getHandAsString());
        System.out.println("Check hand? (1)");

        int action = reader.nextInt();

        if (action == 1) {
            player.check();
            poker.setTableBet(player.playerBet);
            poker.incrementCheckCounter();
        }

        if (poker.getCheckCounter() == poker.numberOfPlayers) {
            poker.dealFlop();
            poker.setCheckCounter(0);
        }
        System.out.println("The flop has been dealt. This is your hand: " +
                            "\n" +
                            poker.humanPlayer.getHandAsString() +
                            "\n " +
                            "This is the Flop: " +
                            poker.getFlopAsString() + "\n" +
                            "Will you Check? (1)");

        action = reader.nextInt();

        if (action == 1) {
            player.check();
            poker.incrementCheckCounter();
        }

        if (poker.getCheckCounter() == poker.numberOfPlayers) {
            poker.dealTurn();
            poker.setCheckCounter(0);
        }

        System.out.println("The turn has been dealt. This is your hand: " +
                "\n" +
                poker.humanPlayer.getHandAsString() +
                "\n " +
                "This is the board: " +
                poker.getFlopAsString() + " " + poker.getTurnAsString() + "\n" +
                "Will you Check? (1)");

        action = reader.nextInt();

        if (action == 1) {
            player.check();
            poker.incrementCheckCounter();
        }

        if (poker.getCheckCounter() == poker.numberOfPlayers) {
            poker.dealRiver();
            poker.setCheckCounter(0);
        }

        System.out.println("The River has been dealt. This is your hand: " +
                "\n" +
                poker.humanPlayer.getHandAsString() +
                "\n " +
                "This is the board: " +
                poker.getFlopAsString() + " " + poker.getTurnAsString() + " " + poker.getRiverAsString() + "\n" +
                "You won!  The pot is " + poker.pot + " Chips.");

        reader.close();

 */
    }
    public void createPokerPlayers(int numberOfPokerPlayers) {
        for (int i = 0; i < numberOfPokerPlayers; i++) {
            PokerPlayer player = new PokerPlayer("Player " + (i +1), 200);
            pokerPlayers.add(player);
        }
    }

    public ArrayList<PokerPlayer> getPokerPlayers() {
        return pokerPlayers;
    }

    public void completeBettingRound(PokerGame pokerGame) {
        Scanner reader = new Scanner(System.in);
        playerActions = new String[pokerGame.getPokerPlayersInHand().size()];
        int p = 0;
        while (playerActions == null ||
        Arrays.stream(playerActions).distinct().count() != 1
        ) {
            System.out.println("Check(1): ");
            int action = reader.nextInt();
            switch (action) {
                case 1 :
                    pokerGame.pot += pokerGame.getPokerPlayersInHand().get(p).check();
                    playerActions[p] = "Check";
                    p++;
            }
        }
    }

    public void playOneRound(PokerGame pokerGame) {
        pokerGame.setPokerPlayersInHand(pokerGame.getPokerPlayersAtTable());
        pokerGame.dealHoleCards();
        completeBettingRound(pokerGame);
//        pokerGame.addPlayerBetsToPot();

        if (pokerGame.getPokerPlayersInHand().size() == 1) {
            pokerGame.getPokerPlayersInHand().get(0).setChipCount(pokerGame.getPokerPlayersInHand().get(0).getChipCount() + pokerGame.pot);
//          pokerGame.endRound();
        }

        pokerGame.dealFlop();

//        pokerGame.getActions();
//        pokerGame.addPlayerBetsToPot();

//        if (remainingPlayersInHand.size() == 1) {
//            remainingPlayersInHand.get(0).setChipCount(remainingPlayersInHand.get(0).getChipCount() + pokerGame.pot);
//          pokerGame.endRound();
//        }
//        pokerGame.dealTurn();

//        pokerGame.getActions();
//        pokerGame.addPlayerBetsToPot();

//        if (remainingPlayersInHand.size() == 1) {
//            remainingPlayersInHand.get(0).setChipCount(remainingPlayersInHand.get(0).getChipCount() + pokerGame.pot);
////          pokerGame.endRound();
//        }
//        pokerGame.dealRiver();

//        pokerGame.getActions();
//        pokerGame.addPlayerBetsToPot();

//        if (remainingPlayersInHand.size() == 1) {
//            remainingPlayersInHand.get(0).setChipCount(remainingPlayersInHand.get(0).getChipCount() + pokerGame.pot);
////          pokerGame.endRound();
//        }
//
//        pokerGame.determineWinner();


        /* 1. Get Player count
         * 2. deal cards
         * 3. player 1 action - player n action (all players action)
         *  a. until all players check or call (no more action)
         * 4. Add table bets to pot
         * 5. If (remaining players == 1)
         *  a. Give pot to remaining player && end round
         *  b. Else continue (Deal flop?)
         * 6. Deal flop
         * 7. Repeat 3, 4, and 5
         * 8. Deal Turn
         * 9. Repeat 3, 4, and 5
         * 10. Deal River
         * 11. Repeat 3, 4, and 5
         * 12. Showdown (Determine best hand)
         *  a. If (# of players with best hand > 1)
         *      1. Split pot between winners
         *  b. Else give pot to winner
         */
    }

}

