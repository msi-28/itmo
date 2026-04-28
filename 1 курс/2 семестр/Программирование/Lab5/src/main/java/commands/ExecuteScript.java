package commands;

import manager.FileManager;

import static runner.Runner.parserManager;

public class ExecuteScript implements Command{
    @Override
    public void execute(String[] args){
        FileManager fileManager = new FileManager(args[1]);
        fileManager.readFile();
    }

    @Override
    public String toString(){
        return "execute_script file_name- считать и исполнить скрипт из указанного файла";
    }
}
