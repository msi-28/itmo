package classes;

import static runner.Runner.scanner;

public interface Validatable <T extends Enum<T>> {
    static <T extends Enum<T>> T validate(String message, Class<T> enumClass) {
        while (true) {
            System.out.print(message);
            String input = scanner.next().toUpperCase();
            try {
                return T.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Кажется вы допустили ошибку, попробуйте еще раз");
            }
        }
    }
}