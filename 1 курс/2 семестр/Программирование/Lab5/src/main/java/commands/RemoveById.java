package commands;

import static runner.Runner.collectionManager;

public class RemoveById implements Command{
    @Override
    public void execute(String[] args){
        collectionManager.removeById(Long.parseLong(args[1]));
    }

    @Override
    public String toString(){
        return "remove_by_id {id} - удаляет элемент из коллекции по его id";
    }
}
