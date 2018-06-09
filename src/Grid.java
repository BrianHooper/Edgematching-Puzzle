import java.util.LinkedList;

import static java.lang.System.exit;

/**
 * Solves a puzzle using an n * n set of cards
 */
public class Grid {
    /**
     * Given a set of n * n four-sided cards, attempts to arrange them
     * in an n * n grid such that each adjacent side is matching
     * @param cards the cards in any order
     * @return 2D Card array of a valid arrangement, or null if none found
     */
    public static Card[][] SolvePuzzle(LinkedList<Card> cards) {
        // Check that the number of cards is a power of two
        int size = (int) Math.sqrt(cards.size());
        if(cards.size() != (size * size)) {
            System.out.println("Error: Number of cards must be a power of 2, " + cards.size() + " given.");
            return null;
        }

        // Find a valid arrangement
        Card[][] layout = new Card[size][size];
        return findValid(cards, layout);
    }

    /**
     * Outputs an arrangement of cards to the console
     * @param layout 2D Card array
     */
    public static void PrintLayout(Card[][] layout) {
        int size = layout.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                sb.append('[');
                sb.append(i);
                sb.append(',');
                sb.append(j);
                sb.append("]: ");
                sb.append(layout[i][j]);
                sb.append('\n');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    /**
     * Checks that a partial or complete arrangement of cards is valid
     * @param layout 2D Card array
     * @return true if the arrangement is valid
     */
    private static boolean isValid(Card[][] layout) {
        int size = layout.length;

        // Check that each left-right pair is valid
        for(Card[] aLayout : layout) {
            for(int j = 0; j < size - 1; j++) {
                if(aLayout[j] != null && aLayout[j + 1] != null) {
                    if(aLayout[j].getEast().InvalidMatch(aLayout[j + 1].getWest())) {
                        return false;
                    }
                }
            }
        }

        // Check that each top-bottom pair is valid
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size - 1; j++) {
                if(layout[j][i] != null && layout[j + 1][i] != null) {
                    if(layout[j][i].getSouth().InvalidMatch(layout[j + 1][i].getNorth())) {
                        return false;
                    }
                }
            }
        }

        // the arrangement is valid
        return true;
    }

    /**
     * Checks that a complete arrangement is valid
     * @param layout 2D card array
     * @return true of the arrangement is valid
     */
    private static boolean isComplete(Card[][] layout) {
        int size = layout.length;

        // Check that the arrangement is complete
        for(Card[] aLayout : layout) {
            for(int j = 0; j < size; j++) {
                if(aLayout[j] == null) {
                    return false;
                }
            }
        }

        // Check that the arrangement is valid
        return isValid(layout);
    }

    /**
     * Places a card in the first open spot on the grid
     * @param card card to place
     * @param layout arrangement of cards
     */
    private static void place(Card card, Card[][] layout) {
        int size = layout.length;
        if(card == null)
            return;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(layout[i][j] == null) {
                    layout[i][j] = card;
                    return;
                }
            }
        }
    }

    /**
     * Recursively attempts to find a valid arrangement of cards
     * @param cards LinkedList of Cards
     * @param layout 2D Card array
     * @return a valid arrangement, or null if none exists
     */
    private static Card[][] findValid(LinkedList<Card> cards, Card[][] layout) {
        // Base case
        if(cards.size() == 0) {
            // Check that the arrangement is complete and valid
            if(isComplete(layout)) {
                return layout;
            } else {
                return null;
            }
        }

        // Attempt to place each remaining card on the arrangement
        Card[][] currentLayout = null;
        for(Card card : cards) {
            LinkedList<Card> cardsCopy = new LinkedList<>(cards);
            cardsCopy.remove(card);
            // Try each card rotated all four ways
            for(int k = 0; k < 4; k++) {
                Card[][] layoutCopy = CloneLayout(layout);
                place(card, layoutCopy);
                card.Rotate();
                // Recursive call
                if(isValid(layoutCopy)) {
                    currentLayout = findValid(cardsCopy, layoutCopy);
                }
                // Stop searching if a complete arrangement was found
                if(currentLayout != null && isComplete(currentLayout)) {
                    return currentLayout;
                }
            }
        }
        return currentLayout;
    }

    /**
     * Creates a clone of the card arrangement
     * @param other 2D Card array
     * @return deep copy of other 2D card array
     */
    private static Card[][] CloneLayout(Card[][] other) {
        int size = other.length;
        Card[][] layout = new Card[size][size];

        try {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(other[i][j] != null) {
                        layout[i][j] = (Card) other[i][j].clone();
                    }
                }
            }
        } catch(CloneNotSupportedException e) {
            exit(1);
        }

        return layout;
    }
}
