package runner;

import manager.CollectionManager;
import manager.ParserManager;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Runner {
    public static Scanner scanner = new Scanner(System.in);
    public static ParserManager parserManager = new ParserManager();
    public static CollectionManager collectionManager = new CollectionManager();
    public static Date collectionMadeDate;

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
