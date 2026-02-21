package person;

import Events.forEverybody.*;
import exeptions.NullLocationException;
import person.enums.Emotions;
import environment.Location;
import person.enums.RunType;

import java.util.HashMap;

public abstract class Shorty {
    private String name;
    private Location location;
    private Emotions emotions;
    private RunType runType;
    public Shorty(String name, Location location, Emotions emotions, RunType runType) throws NullLocationException {
        if (location == null) {
            throw new NullLocationException(name);
        }
        this.name = name;
        this.location = location;
        this.emotions = emotions;
        this.runType = runType;
    }

    public String getName() {return name;}
    public Location getLocation(){return location;}
    public Emotions getEmotions(){return emotions;}
    public RunType getRunType(){return runType;}

    public void setLocation(Location location){this.location = location;}
    public void setRunType(RunType runType){this.runType = runType;}
    public void setEmotions(Emotions emotions){
        this.emotions = emotions;
        System.out.println(this.getName() + " сейчас чувствует себя: " + Emotions.getEmotion(this));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String goTo(Location location){
        EventGoTo eventGoTo = new EventGoTo();
        return eventGoTo.reactGoToEvent(this, location);
    }
    public String getOut(){
        EventGetOut eventGetOut = new EventGetOut();
        return eventGetOut.reactGetOutEvent(this);
    }
    public String getIn(Location location) {
        EventGetIn eventGetIn = new EventGetIn();
        return eventGetIn.reactGetInEvent(this, location);
    }

    public String openTheDoor(){
        EventPressingButton eventPressingButton = new EventPressingButton();
        return eventPressingButton.reactPressingButtonEvent(this);
    }

    public String getSafe(){
        EventGetSafe eventGetSafe = new EventGetSafe();
        return eventGetSafe.reactGetSafeEvent(this);
    }


    // переопределения Object
    @Override
    public String toString(){
        return "Shorty: " + this.getName();
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null || this.getClass() != otherObject.getClass()) return false;
        Shorty shorty = (Shorty) otherObject;
        return this.getName() == shorty.getName();
    }

}
