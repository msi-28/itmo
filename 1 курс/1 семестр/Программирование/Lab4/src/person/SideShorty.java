package person;

import Events.forSide.EventNoAnswer;
import exeptions.NullLocationException;
import person.enums.Emotions;
import environment.Location;
import person.enums.RunType;

public class SideShorty extends Shorty{
    private String name;
    private Location location;
    private Emotions emotions;
    private RunType runType;
    public SideShorty(String name, Location location, Emotions emotions, RunType runType) throws NullLocationException {
        super(name, location, emotions, runType);
    }

    public String noAnswer(){
        EventNoAnswer eventAnswer = new EventNoAnswer();
        return eventAnswer.reactNoAnswer(this);
    }

}
