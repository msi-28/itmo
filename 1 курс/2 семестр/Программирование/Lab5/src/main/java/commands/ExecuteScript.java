package commands;

import manager.FileManager;

/**
 * Класс команды, которая выполняет скрипт из файла
 * @author vmn
 */
public class ExecuteScript implements Command{
    /**
     * Основной метод, внутри которого вызывается метод, отвечающий за выполнение скрипта из файла
     * @param args
     */
    @Override
    public void execute(String[] args){
        FileManager fileManager = new FileManager(args[1]);
        fileManager.executeFile();
    }
    /**
     * Возвращает описание команды для справки
     * @return строковое представление описания того, что делает команда и какие параметры она принимает
     */
    @Override
    public String toString(){
        return "execute_script file_name- считать и исполнить скрипт из указанного файла";
    }
}
