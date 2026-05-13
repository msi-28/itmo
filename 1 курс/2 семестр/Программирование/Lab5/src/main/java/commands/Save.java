package commands;

import static runner.Runner.collectionManager;

/**
 * Класс команды, которая сохраняет коллекцию в файл
 * @author vmn
 */

public class Save implements Command{
    /**
     * Основной метод, внутри которого проверяется, переданы ли все аргументы команды и вызывается метод, отвечающий за
     * сохранение коллекции в файл, название которого передается как аргумент
     * @param args
     */
    @Override
    public void execute(String[] args){
        if (checkArgs(args)) {
            collectionManager.saveFile(args[1]);
        }
    }

    /**
     * Метод, проверяющий правильность, переданного аргумента (расширение файла должно быть .csv)
     * @param args
     * @return
     */
    public boolean checkArgs(String[] args){
        if (args[1].contains(".csv")){
            return true;
        }
        else{
            System.out.println("Сохранить коллекцию можно только в файл формата .csv");
            return false;
        }
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "save - сохранить коллекцию в файл";
    }
}
