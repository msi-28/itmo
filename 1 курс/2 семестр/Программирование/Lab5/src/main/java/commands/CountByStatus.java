package commands;

import classes.Status;

import static classes.Status.getStatus;
import static runner.Runner.collectionManager;

public class CountByStatus implements Command {
    @Override
    public void execute(String[] args){
        try {
            Status status = Status.valueOf(args[1].toUpperCase());
            System.out.println(collectionManager.countByStatus(status));
        }
        catch (IllegalArgumentException e){
            System.out.println("Указан неверный статус! Вводите только статус из списка: " + getStatus());
        }
    }

    @Override
    public String toString(){
        return "count_by_status status - вывести количество элементов, значение поля status которых равно заданному";
    }
}
