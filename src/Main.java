/**
 * Solves a four-sided card puzzle
 * @author Brian Hooper
 * @since 6/8/2018
 */

import java.util.LinkedList;

public class Main {

    /**
     * Creates a list of Card objects
     * @return LinkedList of Cards
     */
    public static LinkedList<Card> MakeCards() {
        LinkedList<Card> cards = new LinkedList<>();

        cards.add(new Card(
                new Side(Animal.RACCOON, Face.HEAD),
                new Side(Animal.FOX, Face.HEAD),
                new Side(Animal.SKUNK, Face.HEAD),
                new Side(Animal.PORCUPINE, Face.HEAD)));
        cards.add(new Card(
                new Side(Animal.PORCUPINE, Face.TAIL),
                new Side(Animal.FOX, Face.HEAD),
                new Side(Animal.RACCOON, Face.HEAD),
                new Side(Animal.SKUNK, Face.HEAD)));
        cards.add(new Card(
                new Side(Animal.SKUNK, Face.TAIL),
                new Side(Animal.PORCUPINE, Face.HEAD),
                new Side(Animal.FOX, Face.TAIL),
                new Side(Animal.RACCOON, Face.TAIL)));
        cards.add(new Card(
                new Side(Animal.RACCOON, Face.TAIL),
                new Side(Animal.PORCUPINE, Face.HEAD),
                new Side(Animal.FOX, Face.HEAD),
                new Side(Animal.SKUNK, Face.HEAD)));
        cards.add(new Card(
                new Side(Animal.RACCOON, Face.HEAD),
                new Side(Animal.FOX, Face.HEAD),
                new Side(Animal.PORCUPINE, Face.TAIL),
                new Side(Animal.SKUNK, Face.TAIL)));
        cards.add(new Card(
                new Side(Animal.PORCUPINE, Face.TAIL),
                new Side(Animal.RACCOON, Face.HEAD),
                new Side(Animal.FOX, Face.HEAD),
                new Side(Animal.SKUNK, Face.HEAD)));
        cards.add(new Card(
                new Side(Animal.SKUNK, Face.TAIL),
                new Side(Animal.RACCOON, Face.HEAD),
                new Side(Animal.FOX, Face.HEAD),
                new Side(Animal.PORCUPINE, Face.HEAD)));
        cards.add(new Card(
                new Side(Animal.FOX, Face.TAIL),
                new Side(Animal.SKUNK, Face.HEAD),
                new Side(Animal.PORCUPINE, Face.HEAD),
                new Side(Animal.RACCOON, Face.TAIL)));
        cards.add(new Card(
                new Side(Animal.FOX, Face.TAIL),
                new Side(Animal.RACCOON, Face.HEAD),
                new Side(Animal.SKUNK, Face.TAIL),
                new Side(Animal.PORCUPINE, Face.HEAD)));

        return cards;
    }

    public static void main(String[] args) {
        LinkedList<Card> cards = MakeCards();
        Card[][] complete = Grid.SolvePuzzle(cards);
        Grid.PrintLayout(complete);
    }
}
