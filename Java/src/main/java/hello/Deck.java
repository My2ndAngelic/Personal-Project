package hello;

public class Deck {

    private final Card[] deck;
    private int count;

    Deck(boolean shuffle) {
        this.deck = new Card[52];
        int count = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                this.deck[count] = new Card(i, j);
                count++;
            }
        }
        this.count = deck.length;
    }

    public Card[] getDeck() {
        return deck;
    }

    public Card deal() {
        Card returnCard = this.deck[this.count - 1];
        count--;
        return returnCard;
    }
}
