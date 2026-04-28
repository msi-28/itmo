package classes;

import static runner.Runner.scanner;

public class Coordinates implements Comparable<Coordinates>{
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

    public String toStringForFile(){
        return this.x + ";" + this.y;
    }


    @Override
    public int compareTo(Coordinates o) {
        int comparingX = this.x.compareTo(o.x);
        int comparingY = Long.compare(this.y, o.y);

        if (comparingX != 0) return comparingX;
        return comparingY;
    }
}
