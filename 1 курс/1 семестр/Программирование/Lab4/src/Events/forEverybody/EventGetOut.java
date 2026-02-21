package Events.forEverybody;

import Events.Event;
import Events.EventType;
import person.interfaces.GettingOut;
import person.interfaces.Reactable;
import environment.Location;
import person.Shorty;

public class EventGetOut extends Event implements GettingOut, Reactable {
    public EventGetOut(){
        super(EventType.GET_OUT);
    }

    public String reactGetOutEvent(Shorty actor){
        String message = actor.getLocation().getName();
        if (canReact(actor)){
            return getOut(actor) +  message;
        }
        else{
            return "Персонаж находится снаружи";
        }
    }

    public String getOut(Shorty actor){
        actor.setLocation(Location.OUTSIDE);
        return actor.getName() + " " + EventType.GET_OUT.getText();
    }

    public boolean canReact(Shorty actor){
        return ! actor.getLocation().equals(Location.OUTSIDE);
    }


}
