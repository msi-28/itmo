package commands;

import classes.Worker;

import static runner.Runner.*;

public class Update implements Command{
    @Override
    public void execute(String[] args){
        if (checkArgs(args)) {
            long id = Long.parseLong(args[1]);
            if (collectionManager.findById(id) != null) {
                System.out.printf("Введите новое значение элемента с id %d%n", id);
                Worker worker = inputManager.readWorker();
                collectionManager.update(id, worker);
                System.out.println("Элемент изменен");
            }
        }

    }

    public boolean checkArgs(String[] args) {
        if (args[1].getClass().equals(long.class)) {
            return true;
        } else {
            System.out.println("Не верный тип аргумента");
            return false;
        }
    }

    @Override
    public String toString(){
        return "update id {element} - обновить значение элемента коллекции, id которого равен заданному";
    }
}