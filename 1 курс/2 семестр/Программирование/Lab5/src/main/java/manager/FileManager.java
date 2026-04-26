package manager;

import classes.Worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import static runner.Runner.collectionManager;
import static runner.Runner.parserManager;

public class FileManager {
    private String filename;

    public FileManager(String fileName) {
        this.filename = fileName;
    }

    public void readFile() {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Scanner scanner1 = new Scanner(data);
                System.out.println(scanner1);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

//    public void readFile() {
//        File file = new File(filename);
//        try (Scanner scanner = new Scanner(file, "UTF-8")) {
//            scanner.nextLine();
//            while (scanner.hasNextLine()) {
//                String[] data = scanner.nextLine().split(";");
//                Worker worker = new Worker(Long.parseLong(data[0]), data[1]);
//                collectionManager.addWorker(worker);
//            }
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }

}
