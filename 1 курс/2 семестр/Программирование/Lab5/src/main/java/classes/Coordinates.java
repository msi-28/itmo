package classes;

import static runner.Runner.scanner;

public class Coordinates {
    private Integer x; //Максимальное значение поля: 638, Поле не может быть null
    private long y;

    public Coordinates(Integer x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "x: " + this.x +
                ", y: " + this.y;
    }



}
