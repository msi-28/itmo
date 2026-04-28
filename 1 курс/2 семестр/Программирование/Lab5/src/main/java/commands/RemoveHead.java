package commands;

import static runner.Runner.collectionManager;


public class RemoveHead implements Command{
    @Override
    public void execute(String[] args){
        System.out.print("Первый элемент коллекции ");
        System.out.print((collectionManager.getCollection()).getFirst());
        collectionManager.removeHead();
        System.out.println(" удален");
    }

    @Override
    public String toString(){
        return "remove_head - вывести первый элемент коллекции и удалить его";
    }
}
