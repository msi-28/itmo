package classes;

public enum Status implements Gettable<Position>{
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION;

    public static String getStatus(){
        return Gettable.getValues(Status.class);
    }
}