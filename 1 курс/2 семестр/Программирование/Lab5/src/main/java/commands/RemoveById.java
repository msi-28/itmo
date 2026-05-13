package commands;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая удаляет элемент по его id
 * @author vmn
 */
public class RemoveById implements Command{
    /**
     * Основной метод, внутри которого подготавливаются данные, вызывается метод, отвечающий за добавление элемента
     * и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (checkArgs(args)) {
            collectionManager.removeById(Long.parseLong(args[1]));
            System.out.printf("Элемент с id %s удален%n", args[1]);
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
        return "remove_by_id id - удалить элемент из коллекции по его id";
    }
}
