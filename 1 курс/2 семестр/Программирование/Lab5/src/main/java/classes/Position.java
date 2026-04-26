package classes;

import static runner.Runner.scanner;

public enum Position implements Validatable<Position>{
    ENGINEER,
    DEVELOPER,
    LEAD_DEVELOPER,
    BAKER;

    public static Position positionMaker(){
        return Validatable.validate("Введите его позицию (engineer, developer, lead_developer, baker): ",
                Position.class);
    }
}
