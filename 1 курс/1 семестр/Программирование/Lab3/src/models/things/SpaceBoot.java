package models.things;
import interfaces.Throwable;

public class SpaceBoot implements Throwable {
    private String side;
    private boolean isOn;
    public SpaceBoot(String side, boolean isOn){
        this.side = side;
        this.isOn = isOn;
    }

    public String getSide(){
        return side;
    }
    public void setSide(){
        this.side = side;
    }

    public boolean getOn(){
        return isOn;
    }
    public void setOn(){
        this.isOn = isOn;
    }

    public void throw_boot(String side, boolean isOn){
        if (isOn){
            System.out.println(" выбросил сапог");
            isOn = false;
        }
        else{
            System.out.println(" уже выбросил сапог до этого");
        }
    }

}
