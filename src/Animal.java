/**
 * Represents the type of animal on a side
 */
public enum Animal {
    SKUNK, FOX, PORCUPINE, RACCOON;

    /**
     * Overrides toString from Object
     * @return string
     */
    @Override
    public String toString() {
        switch(this) {
            case FOX: return "Fox";
            case SKUNK: return "Skunk";
            case RACCOON: return "Raccoon";
            case PORCUPINE: return "Porcupine";
            default: return "";
        }
    }
}