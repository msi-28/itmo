package commands;

import modules.Worker;

import static runner.Runner.*;

/**
 * Класс команды, которая удаляет из коллекции все элементы, меньше заданного
 * @author vmn
 */

public class RemoveLower implements Command{
    /**
     * Основной метод, внутри которого подготавливаются данные, вызывается метод, отвечающий за добавление элемента
     * и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        Worker worker = inputManager.readWorker();
        System.out.println(collectionManager.removeLower(worker));
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "remove_lower {element} - удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
