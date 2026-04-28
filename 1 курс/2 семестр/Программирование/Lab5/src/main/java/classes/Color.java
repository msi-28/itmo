package classes;

public enum Color implements Gettable<Position>{
    RED,
    BLACK,
    BLUE,
    YELLOW,
    GREEN,
    BROWN;

    public static String getColors(){
        return Gettable.getValues(Color.class);
    }
}
