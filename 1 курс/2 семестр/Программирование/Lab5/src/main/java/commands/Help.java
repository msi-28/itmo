package commands;

import static runner.Runner.parserManager;

/**
 * Класс команды, которая добавляет элемент в коллекцию
 * При добавлении элементы автоматически сортируются в автоматическом порядке
 * @author vmn
 */

public class Help implements Command{
    /**
     * Основной метод, внутри которого подготавливается и выводится информация обо всех командах
     * @param args
     */
    @Override
    public void execute(String[] args){
        for (Command cmd : parserManager.getCommands()){
            System.out.println(cmd);
        }
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "help - вывести справку по доступным командам";
    }
}
