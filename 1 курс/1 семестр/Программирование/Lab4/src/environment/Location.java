package environment;

public enum Location {
    CAVE("пещера"),
    NEAR_CAVE("около пещеры"),
    ROCKET("ракета"),
    NEAR_ROCKET("около ракеты"),
    OUTSIDE("снаружи");
    private final String name;

    Location(String name) {this.name = name;}
    public String getName(){return this.name;}
}
