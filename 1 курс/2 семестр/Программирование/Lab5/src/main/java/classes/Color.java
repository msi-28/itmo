package classes;

public enum Color implements Validatable<Color>{
    RED,
    BLACK,
    BLUE,
    YELLOW,
    GREEN,
    BROWN;

    public static Color colorMaker(String message) {
        return Validatable.validate(message, Color.class);
    }
}
