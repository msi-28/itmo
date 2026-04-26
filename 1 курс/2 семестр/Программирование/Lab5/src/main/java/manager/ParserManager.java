package manager;

import commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParserManager {
    private HashMap<String, Command> commands;

    public ParserManager() {
        this.commands = new HashMap<String, Command>();
        this.commands.put("help", new Help());
        this.commands.put("info", new Info());
        this.commands.put("clear", new Clear());
        this.commands.put("add", new Add());
        this.commands.put("remove_head", new RemoveHead());
        this.commands.put("show", new Show());
        this.commands.put("exit", new Exit());
        this.commands.put("update", new Update());
        this.commands.put("remove_by_id", new RemoveById());
        this.commands.put("add_if_min", new AddIfMin());
        this.commands.put("remove_lower", new RemoveLower());
        this.commands.put("max_by_person", new MaxByPerson());
        this.commands.put("count_by_status", new CountByStatus());
        this.commands.put("print_field_ascending_salary", new PrintFieldAscendingSalary());
        this.commands.put("read_file", new ExecuteScript());
    }

    public void lineParser(String s) {
        String[] command = s.trim().replace("\\s", " ").split(" ");
        if (this.commands.containsKey(command[0])) {
            List<String> argsCommands = List.of("remove_by_id", "update", "execute_script", "count_by_status");
            Command cmd = this.commands.get(command[0]);
            if (argsCommands.contains(command[0]) && command.length == 1){
                System.out.println("для этой команды необходимо передать аргумент");
            }
            cmd.execute(command);
        }
    }

    public ArrayList<Command> getCommands() {
        return new ArrayList<Command>(this.commands.values());
    }
}