package environment;

import person.Shorty;

public class Cave extends Place{
    private String name;
    public Cave(String name){
        super(name);
    }

    @Override
    public void goTo(Shorty shorty) {
        System.out.printf("%s %s%n", shorty.getName(), "забрался в пещеру");
    }

    @Override
    public void goOut(Shorty shorty){
        System.out.printf("%s %s%n", shorty.getName(), "выбрался из пещеры");
    }

}
