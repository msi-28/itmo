package modules;

/**
 * Класс, с помощью которого записываются координаты работника.
 * Объекты {@code Coordinates} хранят информацию о координатах: координаты по ОХ, координаты по ОY.
 * Все поля обязательны для заполнения.
 *
 * Для задания координат используется конструктор, принимающий координаты {@code x} и {@code y}.
 *
 * Класс предоставляет методы для сериализации в формате .csv {@link #toStringCSV}
 * и подготовки к выводу коллекции в консоль {@link #toString()}.
 * @author vmn
 * @see Worker
 */

public class Coordinates implements Comparable<Coordinates>{
    private Integer x; //Максимальное значение поля: 638, Поле не может быть null
    private long y; //Максимальное значение поля: 638, Поле не может быть null

    /**
     * Конструктор. Задает координаты работника.
     * @param x координата по ОХ (не может быть {@code null}, максимальное значение: 638)
     * @param y координата по ОY (не может быть {@code null}, максимальное значение: 638)
     */
    public Coordinates(Integer x, long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает строковое представление объекта в формате
     * "x,y".
     * @return описание объекта для вывода в консоль
     */
    @Override
    public String toString(){
        return "x: " + this.x +
                ", y: " + this.y;
    }

    /**
     * Возвращает строковое представление объекта в формате
     * "x;y".
     * @return описание объекта для записи в файл
     */
    public String toStringCSV(){
        return this.x + ";" + this.y;
    }


    /**
     * Если в классе Worker в методе compareTo сравнение дошло до поля Coordinates,
     * то вызывается этот метод, который последовательно сравнивает координаты работников
     * @param otherCoordinates
     * @return 0 если координаты работников равны, 1 если координата текущего работника больше,
     * -1 если координата текущего работника меньше
     */
    @Override
    public int compareTo(Coordinates otherCoordinates) {
        int comparingX = this.x.compareTo(otherCoordinates.x);
        int comparingY = Long.compare(this.y, otherCoordinates.y);

        if (comparingX != 0) return comparingX;
        return comparingY;
    }
}
