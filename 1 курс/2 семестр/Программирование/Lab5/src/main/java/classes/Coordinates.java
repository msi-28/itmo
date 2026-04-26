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

    public static Coordinates coordinatesMaker(){
        System.out.println("Введите его координаты: ");
        System.out.print("x: ");
        Integer x = scanner.nextInt();
        System.out.print("y: ");
        long y = scanner.nextLong();
        return new Coordinates(x, y);
    }


}
