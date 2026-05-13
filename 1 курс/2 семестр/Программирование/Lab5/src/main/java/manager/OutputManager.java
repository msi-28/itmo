package manager;

import modules.Worker;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс, отвечающий за запись коллекции в файл формата .csv
 * @param <T>
 * @author vmn
 */

public class OutputManager <T extends Worker> {
    private String fileName;
    private boolean append = false;

    /**
     * Конструктор
     * @param fileName
     */
    public OutputManager(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Запись коллекции в файл
     * @param elements
     */
    public void writeFile(String elements){
        try (FileOutputStream fos = new FileOutputStream(this.fileName, append)){
            fos.write(elements.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}