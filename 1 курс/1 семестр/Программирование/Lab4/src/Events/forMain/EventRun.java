package Events.forMain;

import Events.Event;
import Events.EventType;
import person.interfaces.Reactable;
import person.interfaces.Runnable;
import environment.Location;
import person.Shorty;

public class EventRun extends Event implements Runnable, Reactable {
    public EventRun(){
        super(EventType.RUN);
    }

    public String reactRunEvent(Shorty actor){
        String message;
        if (canReact(actor)) {
            message = run(actor);
            return actor.getName() + " " + message;
        }
        else {
            return "Персонаж может бегать только снаружи";
        }
    }

    public String run(Shorty runer){
        switch (runer.getRunType()) {
            case TIRED: return "ковыляет";
            case CHEERFUL: return  "бежит";
            case HEATED_UP: return  "бежит вприпрыжку";
            default: return  "";
        }
    }
    public boolean canReact(Shorty actor){
        return actor.getLocation().equals(Location.OUTSIDE);
    }

}
