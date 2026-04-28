package commands;

import classes.Worker;

import static runner.Runner.*;

public class RemoveLower implements Command{
    @Override
    public void execute(String[] args){
        Worker worker = inputManager.readWorker();
        System.out.println(collectionManager.removeLower(worker));
        scanner.nextLine();
    }

    @Override
    public String toString(){
        return "remove_lower {element} - удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
