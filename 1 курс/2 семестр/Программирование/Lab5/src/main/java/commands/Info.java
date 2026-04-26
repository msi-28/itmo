package commands;

import java.util.Date;
import java.util.LinkedList;

import static runner.Runner.collectionMadeDate;
import static runner.Runner.collectionManager;

public class Info implements Command{
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

    @Override
    public String toString() {
        return "info - выводит информацию о коллекции";
    }
}
