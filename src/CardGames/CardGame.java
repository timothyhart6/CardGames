package CardGames;
public class CardGame {
    public final DeckOfCards deck;

    public CardGame() {
        this.deck = new DeckOfCards();
        setCardValues();
    }

    public void setCardValues() {
        for (int c = 0; c < deck.count(); c++) {
            Card card = (Card) deck.getDeck().get(c);
            String rank = card.getRank();
            int value = 0;
            switch(rank) {
                case "2" :
                    value = 2;
                    break;
                case "3" :
                    value = 3;
                    break;
                case "4" :
                    value = 4;
                    break;
                case "5" :
                    value = 5;
                    break;
                case "6" :
                    value = 6;
                    break;
                case "7" :
                    value = 7;
                    break;
                case "8" :
                    value = 8;
                    break;
                case "9" :
                    value = 9;
                    break;
                case "10" :
                    value = 10;
                    break;
                case "J" :
                    value = 11;
                    break;
                case "Q" :
                    value = 12;
                    break;
                case "K" :
                    value = 13;
                    break;
                case "A" :
                    value = 14;
                    break;
            }
            card.setValue(value);
        }
    }
}
