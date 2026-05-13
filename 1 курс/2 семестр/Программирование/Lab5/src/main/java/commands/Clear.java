package commands;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая отчищает коллекцию
 * @author vmn
 */
public class Clear implements Command{
    /**
     * Основной метод, внутри которого вызывается метод, отвечающий за отчистку коллекции
     * и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        collectionManager.clearWorker();
        System.out.println("Коллекция отчищена");
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "clear - очистить коллекцию";
    }

}
