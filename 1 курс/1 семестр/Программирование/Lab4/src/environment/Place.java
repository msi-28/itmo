package environment;

import exeptions.DoorIsNotOpenException;
import person.Shorty;

public abstract class Place {
    private String name;

    public Place(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    abstract void goTo (Shorty shorty);
    abstract void goOut (Shorty shorty);

    @Override
    public String toString(){
        return "Place: " + this.getName();
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null || this.getClass() != otherObject.getClass()) return false;
        Place place = (Place) otherObject;
        return this.getName() == place.getName();
    }

}
