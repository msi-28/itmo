package commands;

import static runner.Runner.collectionManager;

public class Save implements Command{

    @Override
    public void execute(String[] args){
        collectionManager.saveFile(args[1]);
    }

    @Override
    public String toString(){
        return "save - сохранить коллекцию в файл";
    }
}
