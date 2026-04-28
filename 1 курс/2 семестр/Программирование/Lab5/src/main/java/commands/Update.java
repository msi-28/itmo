package commands;

import classes.Worker;

import static runner.Runner.*;

public class Update implements Command{
    @Override
    public void execute(String[] args){
        long id = Long.parseLong(args[1]);
        System.out.printf("Введите новое значение элемента с id %d%n", id);
        Worker worker = inputManager.readWorker();
        collectionManager.update(id, worker);
        System.out.println("Элемент изменен");
    }

    @Override
    public String toString(){
        return "update id {element} - обновить значение элемента коллекции, id которого равен заданному";
    }
}