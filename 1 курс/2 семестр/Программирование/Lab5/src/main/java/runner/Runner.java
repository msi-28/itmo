package runner;

import manager.CollectionManager;
import manager.InputManager;
import manager.ParserManager;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Главный управляющий класс приложения. Реализует интерактивный режим работы с коллекцией.
 * Хранит общие для всего приложения ресурсы в виде статических полей.
 * @author vmn
 */
public class Runner {
    /**
     * Основной сканер приложения для чтения команд и данных с консоли.
     * В режиме выполнения скрипта заменяется на сканер, связанный с файлом скрипта.
     */
    public static Scanner scanner = new Scanner(System.in);
    /**
     * Менеджер парсинга и выполнения доступных команд.
     * Хранит описание всех доступных команд и передает им управление.
     */
    public static ParserManager parserManager = new ParserManager();
    /**
     * Менеджер коллекции, в которой хранятся объекты {@link modules.Worker}.
     * Обеспечивает все операции.
     */
    public static CollectionManager collectionManager = new CollectionManager();
    /**
     * Универсальный менеджер ввода.
     * Поддерживает чтение данных как из консоли, так и из файла.
     * Содержит методы для удобного чтения перечислений, составных объектов и остальных данных.
     */
    public static InputManager inputManager = new InputManager(scanner);
    /**
     * Дата инициализации коллекции.
     * Устанавливается в методе {@link #run()} перед началом интерактивного цикла.
     * Используется в {@link commands.Info}.
     */
    public static Date collectionMadeDate;

    /**
     * Запускает интерактивный цикл приложения.
     * Алгоритм работы:
     * 1. Фиксирует текущую дату для дальнейшего использования в {@link commands.Info}.
     * 2. В бесконечном цикле выводит приглашение для ввода и считывает строку из {@link #scanner}.
     * 3. Передает прочитанную строку в {@link ParserManager#lineParser(String)}, который определяет команду и выполняет ее.
     * 4. При возникновении {@link NoSuchElementException} (например при нажатии ctrl+D) выводит сообщение о завершении
     * ввода и корректно завершает метод.
     *
     * Выход осуществляется через команду {@code exit}, которая завершает выполнение программы.
     */
    public void run(){
        collectionMadeDate = new Date();
        try {
            while (true) {
                System.out.print("Введите команду: ");
                String line = scanner.nextLine();
                parserManager.lineParser(line);
            }
        }
        catch (NoSuchElementException e) {
            System.out.println("Недопустимое значение, завершение ввода");
        }
    }
}
