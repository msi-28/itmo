package commands;

import classes.Worker;

import static runner.Runner.collectionManager;

public class MaxByPerson implements Command{
    @Override
    public void execute(String[] args){
        Worker worker =  collectionManager.maxByPerson();
        System.out.printf("Максимальный элемент по значению поля Person: %s%n", worker);
    }

    @Override
    public String toString(){
        return "max_by_person - вывести любой объект из коллекции, значение поля person которого является максимальным";
    }
}
