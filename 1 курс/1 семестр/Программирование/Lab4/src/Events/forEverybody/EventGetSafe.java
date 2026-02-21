package Events.forEverybody;

import Events.Event;
import Events.EventType;
import person.enums.Emotions;
import person.interfaces.Reactable;
import person.interfaces.Safeable;
import environment.Location;
import person.Shorty;

public class EventGetSafe extends Event implements Safeable, Reactable {
    public EventGetSafe(){
        super(EventType.GET_SAFE);
    }

    public String reactGetSafeEvent(Shorty actor){
        if (canReact(actor)){
            return getSafe(actor);
        }
        else{
            return "Персонаж не может успокоиться";
        }
    }

    public String getSafe(Shorty actor){
        actor.setEmotions(Emotions.RELIEF);
        return actor.getName() + " здесь в безопасности";
    }
    public boolean canReact(Shorty actor){
        return actor.getLocation().equals(Location.ROCKET);
    }
}
