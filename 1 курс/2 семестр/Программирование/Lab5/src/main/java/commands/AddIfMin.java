package commands;

import classes.Worker;

import static runner.Runner.*;

public class AddIfMin implements Command{
    @Override
    public void execute(String[] args){
        Worker worker = inputManager.readWorker();
        System.out.printf("%s%n", collectionManager.addIfMin(worker));
    }

    @Override
    public String toString(){
        return "add_if_min {element}- добавить новый элемент в коллекцию, если его значение меньше, " +
                "чем у наименьшего элемента этой коллекции";
    }
}