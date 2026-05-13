package commands;

import modules.Worker;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая выводит максимальный элемент коллекции по значению поля Person
 * @author vmn
 */
public class MaxByPerson implements Command{
    /**
     * Основной метод, внутри которого вызывается метод, отвечающий вывод максимального
     * и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        Worker worker =  collectionManager.maxByPerson();
        System.out.printf("Максимальный элемент по значению поля Person: %s%n", worker);
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "max_by_person - вывести любой объект из коллекции, значение поля person которого является максимальным";
    }
}
