package models.places;
import interfaces.HasCases;
import models.things.Sun;

public class Place {
    private String name;
    public Place(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
}
