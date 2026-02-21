package Events.forMain;

import Events.Event;
import Events.EventType;
import person.enums.Emotions;
import person.interfaces.Stressable;
import environment.Location;
import person.Shorty;

public class EventGetStressed extends Event implements Stressable {
    public EventGetStressed(){
        super(EventType.GET_STRESSED);
    }

    public String reactGetStressedEvent(Shorty actor, Shorty reactor){
        if ((! actor.getLocation().equals(reactor.getLocation())) && (actor.getLocation().equals(Location.ROCKET))){
            return getStressed(actor);
        }
        return "Персонаж не переживает";

    }

    public String getStressed(Shorty actor){
        actor.setEmotions(Emotions.STRESSED);
        return actor.getName() + " " + EventType.GET_STRESSED.getText();
    }

}