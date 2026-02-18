package environment;

import actoin.Heatable;
import person.Shorty;

public record Sun(String name) implements Heatable{
    @Override
    public void heatUp(Shorty shorty){
        System.out.printf("%s %s %s%n", this.name, "припекает со страшной силой персонажа:", shorty.getName());
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
