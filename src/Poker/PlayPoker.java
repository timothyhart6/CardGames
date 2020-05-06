package Poker;

import java.util.Scanner;


public class PlayPoker {

    public static void main(String[] args) {


        Scanner reader = new Scanner(System.in);

        //Get player (name, chip count), number of opponents, and create a new game of poker
        System.out.println("Enter your name: ");
        String playerName = reader.next();
        System.out.println("Hello " + playerName + ". How many chips are you buying in for?");
     int chipCount = reader.nextInt();
        System.out.println("You're buying in for " + chipCount + " chips.");
        System.out.println("How many players are at the table?");
        int playerCount = reader.nextInt();
        Player player = new Player(playerName, chipCount);
        Poker poker = new Poker(player, playerCount);

        //Play one round of poker (minus blinds and position)
        poker.deck.shuffle();
        poker.dealHoleCards();
        System.out.println("The Hole cards have been dealt.  This is your hand: \n" + poker.humanPlayer.getHandAsString());
        System.out.println("Choose an option: \n 1. Fold \n 2. Call " + poker.currentBet + " chips");
        int action = reader.nextInt();
        poker.humanPlayer.playerAction(action);
    System.out.println(poker.humanPlayer.getHandAsString());
        System.out.println(poker.humanPlayer.getChipCount());
        reader.close();
    }
}
