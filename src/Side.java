/**
 * Represents a single side of a four-sided card
 */

public class Side implements Cloneable {
    /** Type of animal */
    private Animal animal;
    /** Face, head or tail */
    private Face face;

    /**
     * Constructor
     * @param animal type of animal
     * @param face head or tail
     */
    public Side(Animal animal, Face face) {
        this.animal = animal;
        this.face = face;
    }

    /**
     * Checks that this side can be paired with another side
     * @param other adjacent side
     * @return true if the match is valid
     */
    public boolean InvalidMatch(Side other) {
        return this.animal != other.animal || this.face == other.face;
    }

    /**
     * Overrides toString from Object
     * @return string
     */
    @Override
    public String toString() {
        return "{" + animal + ", " + face + "}";
    }

    /**
     * Creates a clone of this object
     * @return new Side(animal, face)
     * @throws CloneNotSupportedException e
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Side side = (Side) super.clone();

        side.animal = this.animal;
        side.face = this.face;

        return side;
    }
}
