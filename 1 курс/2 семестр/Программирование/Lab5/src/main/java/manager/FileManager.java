package manager;

import classes.Worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import static runner.Runner.*;

public class FileManager {
    private String filename;

    public FileManager(String fileName) {
        this.filename = fileName;
    }

    public void readFile() {
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
            e.printStackTrace();
        }
    }
}
