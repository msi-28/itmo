package commands;

import static runner.Runner.collectionManager;

public class Save implements Command{

    @Override
    public void execute(String[] args){
        if (checkArgs(args)) {
            collectionManager.saveFile(args[1]);
        }
    }

    public boolean checkArgs(String[] args){
        if (args[1].contains(".csv")){
            return true;
        }
        else{
            System.out.println("Сохранить коллекцию можно только в файл формата .csv");
            return false;
        }
    }

    @Override
    public String toString(){
        return "save - сохранить коллекцию в файл";
    }
}
