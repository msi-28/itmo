package person;
import Events.forMain.EventBootFall;
import Events.forMain.EventCall;
import Events.forMain.EventGetStressed;
import Events.forMain.EventRun;
import exeptions.NullLocationException;
import items.Boot;
import person.enums.Emotions;
import environment.Location;
import person.enums.RunType;

public class MainShorty extends Shorty{
    private String name;
    private Location location;
    private Emotions emotions;
    private RunType runType;
    public MainShorty(String name, Location location, Emotions emotions, RunType runType) throws NullLocationException {
        super(name, location, emotions, runType);
    }
    
    private Boot leftBoot = new Boot("Левый", false, this);
    private Boot rightBoot = new Boot("Правый", true, this);
    
    public String fallBoot(){
        EventBootFall eventBootFall = new EventBootFall();
        return eventBootFall.reactFallBootEvent(this, rightBoot);
    }

    public String call(Shorty actor){
        EventCall eventCall = new EventCall(actor, this);
        return eventCall.reactCallEvent();
    }

    public String run(){
        EventRun eventRun = new EventRun();
        return eventRun.reactRunEvent(this);
    }
    public String getStressed(Shorty reactor){
        EventGetStressed eventGetStressed = new EventGetStressed();
        return eventGetStressed.reactGetStressedEvent(this, reactor);
    }
}
