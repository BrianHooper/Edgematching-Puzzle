/**
 * Represents a single puzzle card with four sides
 */
public class Card implements Cloneable {
    /** Top side */
    private Side north;
    /** Left side */
    private Side west;
    /** Bottom side */
    private Side south;
    /** Right side */
    private Side east;

    /**
     * Constructor, creates a single four-sided card
     * @param north top side
     * @param west left side
     * @param south bottom side
     * @param east right side
     */
    public Card(Side north, Side west, Side south, Side east) {
        this.north = north;
        this.west = west;
        this.south = south;
        this.east = east;
    }

    /**
     * Gets the side to the top of the card
     * @return north
     */
    public Side getNorth() {
        return north;
    }

    /**
     * Gets the side to the left of the card
     * @return west
     */
    public Side getWest() {
        return west;
    }

    /**
     * Gets the side to the bottom of the card
     * @return south
     */
    public Side getSouth() {
        return south;
    }

    /**
     * Gets the side to the right of the card
     * @return east
     */
    public Side getEast() {
        return east;
    }

    /**
     * Rotates the card clockwise
     */
    public void Rotate() {
        Side temp = north;
        north = west;
        west = south;
        south = east;
        east = temp;
    }

    /**
     * Overrides toString from Object
     * @return string
     */
    @Override
    public String toString() {
        return "[N: " + north + ", W: " + west + ", S: " + south + ", E: " + east + "]";
    }

    /**
     * Creates a clone of this object
     * @return new Card with four sides
     * @throws CloneNotSupportedException e
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Card card = (Card) super.clone();

        card.north = (Side) this.north.clone();
        card.west = (Side) this.west.clone();
        card.south = (Side) this.south.clone();
        card.east = (Side) this.east.clone();

        return card;
    }
}
