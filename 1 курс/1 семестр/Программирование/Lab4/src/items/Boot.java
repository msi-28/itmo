package items;
import actoin.Fallable;
import person.Shorty;
import java.util.Objects;

import java.util.ArrayList;

public class Boot implements Fallable{
    private static ArrayList<String> boots =  new ArrayList<>();
    private String side;
    private boolean isOn;
    private final Shorty shorty;
    public Boot(String side, boolean isOn, Shorty shorty){
        if (boots.size() < 2){
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
    public void setSide(String side) {
        this.side = side;
    }

    public boolean getIssOn() {
        return isOn;
    }
    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void fallBoot(Shorty shorty){
        if (this.getIssOn()){
            System.out.printf("%s %s %s%n", this.getSide(), "ботинок свалился с ноги персонажа:", shorty.getName());
            setIsOn(false);
        }
        else{
            System.out.printf("%s %s %s%n", this.getSide(), "ботинок уже не на персонаже:", shorty.getName());
        }
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
                && this.shorty == boot.shorty   ;
    }
}
