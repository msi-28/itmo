package commands;

import static runner.Runner.collectionManager;

public class Exit implements Command{
    @Override
    public void execute(String[] args){
        System.out.println("Завершение выполнения программы");
        collectionManager.exit();
    }

    @Override
    public String toString(){
        return "exit - завершить программу (без сохранения в файл)";
    }

}
