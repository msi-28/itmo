package models.places;

import interfaces.HasCases;

public class Rocket extends Place implements HasCases {
    public static final String DEFAULT_NAME = "ракета";

    public Rocket(String name){
        super(name);
    }
    @Override public String dativeCase(){
        return "космическому кораблю";
    }
    @Override public String accusativeCase(){
        return "ракеты";
    }
}
