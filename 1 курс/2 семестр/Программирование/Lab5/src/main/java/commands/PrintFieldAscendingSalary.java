package commands;

import static runner.Runner.collectionManager;

public class PrintFieldAscendingSalary implements Command{
    @Override
    public void execute(String[] args){
        System.out.print("Зарплаты работников в порядке возрастания: ");
        System.out.println(collectionManager.printFieldSalary());
    }

    @Override
    public String toString() {
        return "print_field_ascending_salary - вывести значения поля salary всех элементов в порядке возрастания";
    }
}
