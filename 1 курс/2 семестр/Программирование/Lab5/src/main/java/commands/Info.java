package commands;

import java.util.Date;
import java.util.LinkedList;

import static runner.Runner.collectionMadeDate;
import static runner.Runner.collectionManager;

/**
 * Класс команды, которая выводит информацию о коллекции
 * @author vmn
 */
public class Info implements Command{
    /**
     * Основной метод, внутри которого происходит вывод информации о коллекции
     * В информацию о коллекции входит: тип коллекции, тип элементов коллекции, дата инициализации, количество элементов
     * @param args
     */
    @Override
    public void execute(String[] args) {
        Class<? extends LinkedList> collectionType = collectionManager.getCollection().getClass();
        int lenOfCollection = collectionManager.getCollection().size();
        Date date = collectionMadeDate;
        String elementsType;

        if (collectionManager.getCollection().isEmpty()){
            elementsType = "коллекция пока что пуста";
        }
        else {
            elementsType = collectionManager.getCollection().getFirst().getClass().toString();
        }
        System.out.printf("Тип коллекции: %s,%nТип элементов коллекции: %s,%nДата инициализации: %s,%nКоличество элементов: %s%n",
                collectionType, elementsType, date, lenOfCollection);
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString() {
        return "info - вывести в стандартный поток информацию о коллекции";
    }
}
