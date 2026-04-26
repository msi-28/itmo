package commands;

import manager.FileManager;

public class ExecuteScript implements Command{
    @Override
    public void execute(String[] args){
        FileManager fileManager = new FileManager(args[1]);
        fileManager.readFile();
//        parserManager.lineParser(args[1]);
    }

}
