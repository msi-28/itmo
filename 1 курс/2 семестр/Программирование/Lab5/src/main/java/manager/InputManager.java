package manager;

import modules.*;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

import static modules.Color.getColors;
import static modules.Position.getPositions;
import static modules.Status.getStatus;
import static runner.Runner.collectionManager;

/**
 * Класс отвечающий за ввод данных с консоли и с файла
 * @author vmn
 */
public class InputManager {
    private Scanner scanner;
    private boolean scriptMode = false;
    private String fileName = null;

    /**
     * Конструктор
     * @param scanner
     */
    public InputManager(Scanner scanner){
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public void setScriptMode(boolean scriptMode) {
        System.out.printf("=============[SCRIPT MODE: %b]=============%n", scriptMode);
        this.scriptMode = scriptMode;
    }

    /**
     * Чтение строки
     * @return
     */
    public String readLine(){
        String line = scanner.nextLine().trim();
        if (scriptMode){
            System.out.println("[Script]: " + line);
        }
        return line.isEmpty() ? null : line;
    }

    /**
     * Универсальное чтение значений и их валидация
     * @param message
     * @param parser
     * @param required
     * @param errorMessage
     * @return Введенное в необходимом типе значение или null, если введено /n и это допустимо
     * @param <T>
     */
    public <T> T readValue(String message, Function<String, T> parser, boolean required, String errorMessage){
        try {
            while (true) {
                System.out.print(message);
                String line = readLine();
                if (line == null) {
                    if (required) {
                        System.out.println("Это поле обязательно для заполнения");
                        continue;
                    }
                    return null;
                }
                try {
                    return parser.apply(line);
                } catch (Exception e) {
                    if (scriptMode) throw new RuntimeException();
                    System.out.println(errorMessage + ". Попробуйте еще раз");
                }

            }
        }
        catch (NoSuchElementException e){
            System.out.println("Недопустимое значение, завершение ввода");
            collectionManager.exit();
            return null;
        }
    }

    /**
     * Чтение enum'ов
     * @param enumClass
     * @param message
     * @param required
     * @return Введенное с типом enum значение или null, если введено /n и это допустимо
     * @param <T>
     */
    public <T extends Enum<T>> T readEnum(Class<T> enumClass, String message, boolean required){
        return readValue(message, s->Enum.valueOf(enumClass, s.toUpperCase()), required, "Такого элемента нет в списке");
    }

    /**
     * Чтение полей Coordinates и их валидация
     * @return Объект типа Coordinates с введенными значениями
     */
    public Coordinates readCoordinates(){
        System.out.println("Введите его координаты: ");
        Integer x = readValue("x: ", s->{
            int val = Integer.parseInt(s);
            if (val > 638) throw new IllegalArgumentException();
            return val;
        }, true, "x должен быть числом <= 638");

        long y = readValue("y: ", s->{
            long val = Long.parseLong(s);
            if (val > 638) throw new IllegalArgumentException();
            return val;
        }, true, "y должен быть числом <= 638");

        return new Coordinates(x, y);
    }

    /**
     * Чтение полей Person и их валидация
     * @return Объект типа Person с введенными значениями
     */
    public Person readPerson(){
        System.out.println("Введите его характеристики:");
        int height = readValue("Рост: ", s->{
            int val = Integer.parseInt(s);
            if (val <= 0) throw new IllegalArgumentException();
            return val;
        }, true, "Значение должно быть числом больше 0");
        Color eyeColor = readEnum(Color.class, "Цвет глаз (" + getColors() + "): ", false);
        Color hairColor = readEnum(Color.class, "Цвет волос (" + getColors() + "): ", true);
        return new Person(height, eyeColor, hairColor);
    }

    /**
     * Чтение полей Worker
     * @return Объект типа Worker с введенными значениями
     */
    public Worker readWorker(){
        String name = readValue("Введите имя: ", s->{
            if(s.trim().isEmpty()) throw new IllegalArgumentException();
            return s.trim();
        }, true, "Имя не может быть null");

        Coordinates coordinates = readCoordinates();

        Integer salary = readValue("Введите его ЗП: ", s->{
            Integer val = Integer.parseInt(s);
            if (val <= 0) throw new IllegalArgumentException();
            return val;
        }, false, "Значение должно быть числом больше 0");

        Position position = readEnum(Position.class,
                "Введите его позицию (" + getPositions() +  "): ", false);
        Status status = readEnum(Status.class,
                "Введите его статус (" +  getStatus()+ "): ", false);
        Person person = readPerson();
        return new Worker(name, coordinates, salary, position, status, person);
    }
}