package manager;

import classes.*;

import java.util.Scanner;
import java.util.function.Function;

public class InputManager {
    private Scanner scanner;
    private boolean scriptMode = false;
    private String fileName = null;


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
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isScriptMode(){
        return scriptMode;
    }

    // базовое чтение строки
    public String readLine(){
        if (!scanner.hasNextLine()) return null;
        String line = scanner.nextLine().trim();
        if (scriptMode){
            System.out.println("[Script]: " + line);
        }
        return line.isEmpty() ? null : line;
    }

    // универсальное чтение значений
    public <T> T readValue(String message, Function<String, T> parser, boolean required, String errorMessage){
        while (true){
            System.out.print(message);
            String line = readLine();
            if (line == null){
                if (required){
                    System.out.println("Это поле обязательно для заполнения");
                    continue;
                }
                return null;
            }
            try {
                return parser.apply(line);
            }
            catch (Exception e){
                if (scriptMode) throw new RuntimeException();
                System.out.println(errorMessage +  ". Попробуйте еще раз");
            }

        }
    }

    // enum
    public <T extends Enum<T>> T readEnum(Class<T> enumClass, String message, boolean required){
        return readValue(message, s->Enum.valueOf(enumClass, s.toUpperCase()), required, "Такого элемента нет в списке");
    }

    // Coordinates
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

    // Person
    public Person readPerson(){
        System.out.println("Введите его характеристики:");
        int height = readValue("Рост: ", s->{
            int val = Integer.parseInt(s);
            if (val <= 0) throw new IllegalArgumentException();
            return val;
        }, true, "Значение должно быть числом больше 0");
        Color eyeColor = readEnum(Color.class, "Цвет глаз: ", false);
        Color hairColor = readEnum(Color.class, "Цвет волос: ", true);
        return new Person(height, eyeColor, hairColor);
    }

    // Worker
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
                "Введите его позицию (engineer, developer, lead_developer, baker): ", false);
        Status status = readEnum(Status.class,
                "Введите его статус (fired, hired, recommended_for_promotion): ", false);
        Person person = readPerson();
        return new Worker(name, coordinates, salary, position, status, person);
    }
}