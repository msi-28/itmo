package commands;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая удаляет первый элемент из коллекции
 * @author vmn
 */
public class RemoveHead implements Command{
    /**
     * Основной метод, внутри которого подготавливаются данные, вызывается метод, отвечающий за удаление первого элемента
     * из коллекции и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        System.out.print("Первый элемент коллекции ");
        System.out.print((collectionManager.getCollection()).getFirst());
        collectionManager.removeHead();
        System.out.println(" удален");
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "remove_head - вывести первый элемент коллекции и удалить его";
    }
}
