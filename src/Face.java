/**
 * Represents either the head or tail of an animal on a side
 */
public enum Face {
    HEAD, TAIL;

    /**
     * Overrides toString from Object
     * @return string
     */
    @Override
    public String toString() {
        if(this == HEAD) {
            return "Head";
        } else {
            return "Tail";
        }
    }
}
