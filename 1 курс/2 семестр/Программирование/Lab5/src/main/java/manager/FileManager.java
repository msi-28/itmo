package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static runner.Runner.*;

/**
 * Класс, отвечающий за выполнение скрипта из файла
 * @author vmn
 */
public class FileManager {
    private String filename;

    /**
     * Конструктор
     * @param fileName
     */
    public FileManager(String fileName) {
        this.filename = fileName;
    }

    /**
     * Чтение файла и выполнение скрипта из него
     */
    public void executeFile() {
        Scanner preScanner = inputManager.getScanner();
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            inputManager.setScanner(scanner);
            inputManager.setScriptMode(true);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine().trim();
                System.out.println(data);
                parserManager.lineParser(data);
            }
            inputManager.setScanner(preScanner);
            inputManager.setScriptMode(false);
        }
        catch (FileNotFoundException e){
            System.out.printf("Файл с именем \"%s\" не найден%n", filename);;
        }
    }
}
