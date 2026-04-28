package manager;

import classes.Worker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class OutputManager <T extends Worker> {
    private String fileName;
    private boolean append = false;

    public OutputManager(String fileName) {
        this.fileName = fileName;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    public void writeArrayFile(LinkedList<T> list){
        StringBuilder element = new StringBuilder();
        try (FileOutputStream fos = new FileOutputStream(this.fileName, append)){
            for (T t : list) {

                fos.write(t.toString().getBytes());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void writeFile(String elements){
        try (FileOutputStream fos = new FileOutputStream(this.fileName, append)){
            fos.write(elements.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}