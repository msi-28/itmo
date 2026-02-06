package models.places;

import interfaces.HasCases;

public class Cave extends Place implements HasCases {
    public static final String DEFAULT_NAME = "Пещера";

    public Cave(String name){
        super(name);
    }

    @Override public String genitiveCase(){
        return "пещеры";
    }

    @Override
    public String toString() {
        return "Cave{" +
                "name='" + getName() + '\'' +
                '}';
    }
}
