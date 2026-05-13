package commands;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая выводит зарплаты работников в порядке возрастания
 * @author vmn
 */
public class PrintFieldAscendingSalary implements Command{
    /**
     * Основной метод, внутри которого вызывается метод, отвечающий за вывод зарплат работников в порядке возрастания
     * @param args
     */
    @Override
    public void execute(String[] args){
        System.out.print("Зарплаты работников в порядке возрастания: ");
        System.out.println(collectionManager.printFieldSalary());
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString() {
        return "print_field_ascending_salary - вывести значения поля salary всех элементов в порядке возрастания";
    }
}
