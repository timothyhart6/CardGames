package Poker;

import java.util.Scanner;

public  class Poker {

    Player player;
    static String playerName;
    private static int playerChipCount;


    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        playerName = reader.next();
        System.out.println("Hello " + playerName + ". How many chips are you buying in for?");
        playerChipCount = reader.nextInt();
        System.out.println("You're buying in for " + playerChipCount + " chips.");
        Player player = new Player(playerName, playerChipCount);
        
        reader.close();
    }

}
