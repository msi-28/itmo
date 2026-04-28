package commands;

import classes.*;
import manager.InputManager;

import static runner.Runner.*;

public class Add implements Command{
    @Override
    public void execute(String[] args){
        Worker worker = inputManager.readWorker();
        collectionManager.addWorker(worker);
        System.out.printf("Объект с ID: %d добавлен в коллекцию%n", worker.getId());
    }

    @Override
    public String toString(){
        return "add {element} - добавить новый элемент в коллекцию";
    }


}
