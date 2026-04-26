package commands;

import manager.ParserManager;

import java.util.ArrayList;
import java.util.List;

import static runner.Runner.parserManager;

public class Help implements Command{
    @Override
    public void execute(String[] args){
        for (Command cmd : parserManager.getCommands()){
            System.out.println(cmd);
        }
    }

    @Override
    public String toString(){
        return "help - выводит информацию о командах";
    }
}
