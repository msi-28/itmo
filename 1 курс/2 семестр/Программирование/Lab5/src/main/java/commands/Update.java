package commands;

import modules.Worker;

import static runner.Runner.*;

/**
 * Класс команды, которая обновляет значение элемента коллекции по его id
 * @author vmn
 */
public class Update implements Command{
    /**
     * Основной метод, внутри которого подготавливаются данные, вызывается метод, отвечающий за обновление значения
     * элемента и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (checkArgs(args)) {
            long id = Long.parseLong(args[1]);
            if (collectionManager.findById(id) != null) {
                System.out.printf("Введите новое значение элемента с id %d%n", id);
                Worker worker = inputManager.readWorker();
                collectionManager.update(id, worker);
                System.out.println("Элемент изменен");
            }
        }

    }
    /**
     * Метод, проверяющий тип передаваемого аргумента
     * @param args
     * @return true, если класс аргумента long, false если класс аргумента иной
     */
    public boolean checkArgs(String[] args) {
        try{
            Long.parseLong(args[1]);
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("Не верный тип аргумента");
            return false;
        }
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "update id {element} - обновить значение элемента коллекции, id которого равен заданному";
    }
}