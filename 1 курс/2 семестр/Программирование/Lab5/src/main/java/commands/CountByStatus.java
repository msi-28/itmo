package commands;

import modules.Status;

import static modules.Status.getStatus;
import static runner.Runner.collectionManager;

/**
 * Класс команды, которая считает количество работников, имеющих статус, переданный в качестве аргумента
 * @author vmn
 */
public class CountByStatus implements Command {
    /**
     * Основной метод, внутри которого подготавливаются данные, вызывается метод, отвечающий за добавление элемента
     * и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
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

    //СДЕЛАТЬ CheckArgs()!!!!!!! ну это не супер обязательно, но стилистически наверное желательно

    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "count_by_status status - вывести количество элементов, значение поля status которых равно заданному";
    }
}
