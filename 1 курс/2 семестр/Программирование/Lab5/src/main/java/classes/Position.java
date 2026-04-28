package classes;

public enum Position implements Gettable<Position>, Comparable<Position>{
    ENGINEER,
    DEVELOPER,
    LEAD_DEVELOPER,
    BAKER;

    public static String getPositions(){
        return Gettable.getValues(Position.class);
    }
}