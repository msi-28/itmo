package person;

public class SideShorty extends Shorty{
    private String name;
    public SideShorty(String name){
        super(name);
    }
    @Override
    public void call(Shorty shorty){
        System.out.printf("%s %s %s%n", this.getName(), "не ответил персонажу:", shorty.getName());
    }

}
