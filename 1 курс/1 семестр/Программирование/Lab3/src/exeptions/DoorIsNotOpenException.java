package exeptions;

public class DoorIsNotOpenException extends RuntimeException {
    private static String message;
    public DoorIsNotOpenException(String message) {
        super(message);
    }
    @Override
    public String getMessage(){
        return message;
    }
}
