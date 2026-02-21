package items;
import person.Shorty;
import java.util.Objects;

import java.util.ArrayList;

public class Boot{
    private ArrayList<String> boots =  new ArrayList<>();
    private String side;
    private boolean isOn;
    private final Shorty shorty;
    public Boot(String side, boolean isOn, Shorty shorty){
        if (this.boots.size() < 2){
            boots.add(side);
            this.side = side;
            this.isOn = isOn;
            this.shorty = shorty;
            System.out.printf("Создан ботнок для персонажа: %s. Сторона: %s, На ноге: %b%n",shorty.getName(), side, isOn);
        }
        else{
            throw new IllegalArgumentException("Объект не создан: у персонажа уже есть 2 ботинка%n");
        }
    }

    public String getSide() {
        return side;
    }

    public boolean getIssOn() {
        return isOn;
    }
    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    @Override
    public String toString(){
        return "Boot: " + this.getSide() + " " + getIssOn();
    }
    @Override
    public int hashCode(){
        return Objects.hash(side, isOn, shorty);
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null || this.getClass() != otherObject.getClass()) return false;
        Boot boot = (Boot) otherObject;
        return this.getSide() == boot.getSide() &&  this.getIssOn() == boot.getIssOn()
                && this.shorty == boot.shorty;
    }
}
