package hello;

import java.util.Arrays;

public class DeckMain {
    public static void main(String[] urmom) {
        Deck d = new Deck(true);
        Card c = new Card(12, 4);
        for (int i = 0; i < 52; i++) {
            System.out.println(d.deal().toString());
        }

        System.out.println(Arrays.toString(d.getDeck()));
    }
}
