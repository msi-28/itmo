package commands;

import static runner.Runner.collectionManager;


public class Show implements Command{
    @Override
    public void execute(String[] args){
        System.out.println("Коллекция:");
        if (collectionManager.getCollection().isEmpty()){
            System.out.println("empty");
        }
        else {
            collectionManager.showCollection();
        }
    }

    @Override
    public String toString(){
        return "show - вывести в стандартный поток все элементы коллекции в строковом представлении";
    }
}
