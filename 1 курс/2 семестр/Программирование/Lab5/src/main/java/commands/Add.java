package commands;

import classes.*;

import static runner.Runner.collectionManager;
import static runner.Runner.scanner;

public class Add implements Command{
    @Override
    public void execute(String[] args){
        Worker worker = Worker.workerMaker();
        collectionManager.addWorker(worker);
        System.out.println("Объект добавлен в коллекцию");
        scanner.nextLine();
    }

    @Override
    public String toString(){
        return "add - добавляет элемент в коллекцию";
    }


}
