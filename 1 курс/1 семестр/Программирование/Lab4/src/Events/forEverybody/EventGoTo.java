package Events.forEverybody;

import Events.Event;
import Events.EventType;
import environment.Location;
import person.Shorty;

public class EventGoTo extends Event {
    public EventGoTo(){
        super(EventType.GO_TO);
    }

    public String reactGoToEvent(Shorty actor, Location location){
        if (! actor.getLocation().equals(location)){
            actor.setLocation(location);
            return  actor.getName() + " " +  EventType.GO_TO.getText() + " "  + location.getName();
        }
        else{
            return actor.getName() +  " уже в " +  location.getName();
        }
    }

}
