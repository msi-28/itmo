package commands;

import static runner.Runner.collectionManager;

public class RemoveById implements Command{
    @Override
    public void execute(String[] args){
        if (checkArgs(args)) {
            collectionManager.removeById(Long.parseLong(args[1]));
            System.out.printf("Элемент с id %s удален%n", args[1]);
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
        return "remove_by_id id - удалить элемент из коллекции по его id";
    }
}
