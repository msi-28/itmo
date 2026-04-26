package commands;

import classes.Worker;

import static runner.Runner.collectionManager;
import static runner.Runner.scanner;

public class RemoveLower implements Command{
    @Override
    public void execute(String[] args){
        Worker worker = Worker.workerMaker();
        System.out.println(collectionManager.removeLower(worker));
        scanner.nextLine();
    }

    @Override
    public String toString(){
        return "remove_lower {element} - удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
