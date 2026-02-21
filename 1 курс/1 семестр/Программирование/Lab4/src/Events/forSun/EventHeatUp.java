package Events.forSun;

import Events.Event;
import Events.EventType;
import Events.forMain.EventRun;
import environment.Interfaces.Heatable;
import person.interfaces.Reactable;
import person.enums.RunType;
import environment.Location;
import environment.Sun;
import person.Shorty;

public class EventHeatUp extends Event implements Heatable, Reactable {
    public EventHeatUp(){
        super(EventType.HEAT_UP);
    }

    public String reactHeatUpEvent(Shorty actor, Sun sun){
        if (canReact(actor)) {
            EventRun eventRun = new EventRun();
            eventRun.reactRunEvent(actor);
            return heatUp(actor, sun);
        }
        else{
            return actor.getName() + " не " + Location.OUTSIDE.getName();
        }
    }

    public String heatUp(Shorty actor, Sun sun){
        String message = EventType.HEAT_UP.getText();
        actor.setRunType(RunType.HEATED_UP);
        return sun.name() + " " + message + " " + actor.getName();
    }

    public boolean canReact(Shorty actor){
        return actor.getLocation().equals(Location.OUTSIDE);

    }
}
