package commands;

import classes.Worker;

import static runner.Runner.collectionManager;
import static runner.Runner.scanner;

public class AddIfMin implements Command{
    @Override
    public void execute(String[] args){
        Worker worker = Worker.workerMaker();
        System.out.printf("%s%n", collectionManager.addIfMin(worker));
        scanner.nextLine();
    }

    @Override
    public String toString(){
        return "add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
