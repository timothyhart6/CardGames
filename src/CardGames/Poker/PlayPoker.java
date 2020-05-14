package CardGames.Poker;

import java.util.ArrayList;


public class PlayPoker {
    ArrayList <PokerPlayer> pokerPlayers = new ArrayList<PokerPlayer>();

//    public static void main(String[] args) {
//
//        Scanner reader = new Scanner(System.in);
//
//        //Get player (name, chip count), number of opponents, and create a new game of poker
//        System.out.println("Enter your name: ");
//        String playerName = reader.next();
//        System.out.println("Hello " + playerName + ". How many chips are you buying in for?");
//
//        int chipCount = reader.nextInt();
//
//     System.out.println("You're buying in for " + chipCount + " chips.");
//        System.out.println("How many players are at the table?");
//
//        int playerCount = reader.nextInt();
//
//        Player player = new Player(playerName, chipCount);
//        CardGames.Poker poker = new CardGames.Poker(player, playerCount);
//
//        //Play one round of poker (minus blinds and position)
//        poker.deck.shuffle();
//        poker.dealHoleCards();
//
//        System.out.println("The Hole cards have been dealt.  This is your hand: \n" + poker.humanPlayer.getHandAsString());
//        System.out.println("Check hand? (1)");
//
//        int action = reader.nextInt();
//
//        if (action == 1) {
//            player.check();
//            poker.setTableBet(player.playerBet);
//            poker.incrementCheckCounter();
//        }
//
//        if (poker.getCheckCounter() == poker.numberOfPlayers) {
//            poker.dealFlop();
//            poker.setCheckCounter(0);
//        }
//        System.out.println("The flop has been dealt. This is your hand: " +
//                            "\n" +
//                            poker.humanPlayer.getHandAsString() +
//                            "\n " +
//                            "This is the Flop: " +
//                            poker.getFlopAsString() + "\n" +
//                            "Will you Check? (1)");
//
//        action = reader.nextInt();
//
//        if (action == 1) {
//            player.check();
//            poker.incrementCheckCounter();
//        }
//
//        if (poker.getCheckCounter() == poker.numberOfPlayers) {
//            poker.dealTurn();
//            poker.setCheckCounter(0);
//        }
//
//        System.out.println("The turn has been dealt. This is your hand: " +
//                "\n" +
//                poker.humanPlayer.getHandAsString() +
//                "\n " +
//                "This is the board: " +
//                poker.getFlopAsString() + " " + poker.getTurnAsString() + "\n" +
//                "Will you Check? (1)");
//
//        action = reader.nextInt();
//
//        if (action == 1) {
//            player.check();
//            poker.incrementCheckCounter();
//        }
//
//        if (poker.getCheckCounter() == poker.numberOfPlayers) {
//            poker.dealRiver();
//            poker.setCheckCounter(0);
//        }
//
//        System.out.println("The River has been dealt. This is your hand: " +
//                "\n" +
//                poker.humanPlayer.getHandAsString() +
//                "\n " +
//                "This is the board: " +
//                poker.getFlopAsString() + " " + poker.getTurnAsString() + " " + poker.getRiverAsString() + "\n" +
//                "You won!  The pot is " + poker.pot + " Chips.");
//
//        reader.close();
//        }
//
    public void createPokerPlayers(int numberOfPokerPlayers) {
        for (int i = 0; i < numberOfPokerPlayers; i++) {
            PokerPlayer player = new PokerPlayer("Player " + (i +1), 200);
            pokerPlayers.add(player);
        }
    }

    public ArrayList<PokerPlayer> getPokerPlayers() {
        return pokerPlayers;
    }
}
