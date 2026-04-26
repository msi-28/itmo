package commands;

import static runner.Runner.collectionManager;
public class Clear implements Command{
    @Override
    public void execute(String[] args){
        collectionManager.clearWorker();
        System.out.println("Коллекция отчищена");
    }

    @Override
    public String toString(){
        return "clear - отчистка коллекции";
    }

}
