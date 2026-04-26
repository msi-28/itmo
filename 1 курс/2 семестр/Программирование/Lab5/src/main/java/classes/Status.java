package classes;

import static runner.Runner.scanner;

public enum Status implements Validatable<Status>{
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION;

    public static Status statusMaker(){
        return Validatable.validate("Введите его статус (fired, hired, recommended_for_promotion): ",
                Status.class);
    }
}