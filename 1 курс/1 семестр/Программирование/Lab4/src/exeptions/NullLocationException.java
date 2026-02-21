package exeptions;

import environment.Location;

public class NullLocationException extends Exception {
    private final String name;
    public NullLocationException(String name) {this.name = name;}
    @Override
    public String getMessage(){
        return "Локация персонажа " + name + " не может быть null";
    }
}