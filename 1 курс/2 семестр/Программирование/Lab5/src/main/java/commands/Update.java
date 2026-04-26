package commands;

import static runner.Runner.collectionManager;
import static runner.Runner.scanner;

public class Update implements Command{
    @Override
    public void execute(String[] args){
        long oldId = Long.parseLong(args[1]);
        long newId = Long.parseLong(args[2]);
        collectionManager.updateId(oldId, newId);
        System.out.println("Id элемента коллекции изменен");
    }

    @Override
    public String toString(){
        return "update {old_id} {new_id} - обновляет значение элемента коллекции, id которого равен заданному";
    }
}