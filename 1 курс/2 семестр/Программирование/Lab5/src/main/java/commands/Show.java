package commands;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая выводит содержимое коллекции в консоль
 * @author vmn
 */
public class Show implements Command{
    /**
     * Основной метод, внутри которого подготавливаются данные, вызывается метод, отвечающий за вывод содержимого
     * коллекции и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        System.out.println("Коллекция:");
        if (collectionManager.getCollection().isEmpty()){
            System.out.println("empty");
        }
        else {
            collectionManager.showCollection();
        }
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "show - вывести в стандартный поток все элементы коллекции в строковом представлении";
    }
}
