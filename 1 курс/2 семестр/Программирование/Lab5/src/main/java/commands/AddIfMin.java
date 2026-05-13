package commands;

import modules.Worker;

import static runner.Runner.*;

/**
 * Класс команды, которая добавляет в коллекцию элемент, если его значение меньше минимального элемента коллекции
 * @author vmn
 */
public class AddIfMin implements Command{
    /**
     * Основной метод, внутри которого вызывается метод, добавляющий в коллекцию работника, если его значение меньше
     * минимального
     * @param args
     */
    @Override
    public void execute(String[] args){
        Worker worker = inputManager.readWorker();
        System.out.printf("%s%n", collectionManager.addIfMin(worker));
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "add_if_min {element}- добавить новый элемент в коллекцию, если его значение меньше, " +
                "чем у наименьшего элемента этой коллекции";
    }
}