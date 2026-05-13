package commands;

import modules.*;
import manager.InputManager;

import static runner.Runner.*;

/**
 * Комана {@code add} - добавляет новый элемент в коллекцию.
 * При выполнении команды у пользователя последовательно запрашиваются все поля
 * объекта {@link modules.Worker} кроме {@code id} и {@code creationDate} (они генерируются автоматически).
 * После успешного ввода объект добавляется в коллекцию с автоматическим присвоением ему id.
 * Выводится сообщение с присвоенным id.
 * При добавлении элементы автоматически сортируются в автоматическом порядке.
 * @author vmn
 */

public class Add implements Command{
    /**
     * Выполняет добавление нового работника.
     * Запрашивает поля работника через {@link InputManager#readWorker()}.
     * Добавляет созданного работника в коллекцию с помощью {@link manager.CollectionManager#addWorker(Worker)}
     * Выводит сообщение о завершении добавления элемента в коллекцию
     * @param args аргументы команды не используются
     */
    @Override
    public void execute(String[] args){
        Worker worker = inputManager.readWorker();
        collectionManager.addWorker(worker);
        System.out.printf("Объект с ID: %d добавлен в коллекцию%n", worker.getId());
    }

    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "add {element} - добавить новый элемент в коллекцию";
    }
}