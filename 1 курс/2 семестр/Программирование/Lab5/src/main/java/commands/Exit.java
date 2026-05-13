package commands;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая завершает ввод без сохранения коллекции в файл
 * @author vmn
 */
public class Exit implements Command{
    /**
     * Основной метод, внутри которого вызывается метод, отвечающий за прекращение выполнения программы
     * и происходит вывод, означающий завершение выполнения действия
     * @param args
     */
    @Override
    public void execute(String[] args){
        System.out.println("Завершение выполнения программы");
        collectionManager.exit();
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "exit - завершить программу (без сохранения в файл)";
    }

}
