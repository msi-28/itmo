package Events.forEverybody;

import Events.Event;
import Events.EventType;
import person.interfaces.GettingIn;
import environment.Location;
import person.Shorty;

public class EventGetIn extends Event implements GettingIn {
    public EventGetIn(){
        super(EventType.GET_OUT);
    }

    public String reactGetInEvent(Shorty actor, Location location){
        String message = location.getName();
        if (! actor.getLocation().equals(location)){
            return getIn(actor, location);
        }
        else{
            return  "Персонаж неможет залезть в" + actor.getLocation().getName() +
                    "Он уже здесь";
        }
    }

    public String getIn(Shorty actor, Location location){
        actor.setLocation(location);
        return actor.getName() + " " + EventType.GET_IN.getText() + location.getName();
    }


}
