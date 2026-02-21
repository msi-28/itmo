package environment;

import Events.forSun.EventHeatUp;
import person.Shorty;

public record Sun(String name){

    public String heatUp(Shorty actor){
        EventHeatUp eventHeatUp = new EventHeatUp();
        return eventHeatUp.reactHeatUpEvent(actor,this);
    }

    @Override
    public String toString(){
        return "Sun: " + name;
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null || this.getClass() != otherObject.getClass()) return false;
        Sun sun = (Sun) otherObject;
        return name == sun.name;
    }
}
