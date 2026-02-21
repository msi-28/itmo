package Events.forSide;

import Events.Event;
import Events.EventType;
import person.Shorty;

public class EventNoAnswer extends Event {
    public EventNoAnswer(){
        super(EventType.NO_ANSWER);
    }

    public String reactNoAnswer(Shorty shorty){
        return shorty.getName() + " " +  EventType.NO_ANSWER.getText();
    }


}
