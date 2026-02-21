package Events.forEverybody;

import Events.Event;
import Events.EventType;
import environment.enums.ButtonStatus;
import environment.enums.DoorStatus;
import person.interfaces.Reactable;
import environment.Location;
import person.Shorty;

public class EventOpenTheDoor extends Event implements Reactable {
    private DoorStatus doorStatus  = DoorStatus.CLOSED;
    public EventOpenTheDoor(){
        super(EventType.OPEN_THE_DOOR);
    }

    EventPressingButton eventPressingButton = new EventPressingButton();
    EventGetIn eventGetIn = new EventGetIn();

    public String reactOpenTheDoorEvent(Shorty actor){
        if (canReact(actor)){
            System.out.printf("%s %s%n", actor.getName(), EventType.OPEN_THE_DOOR.getText());
            doorStatus = DoorStatus.OPENED;
            eventGetIn.reactGetInEvent(actor, Location.ROCKET);
            EventPressingButton.buttonStatus = ButtonStatus.UNPRESSED;
            return "Дверь закрылась";
            }
        else if(! actor.getLocation().equals(Location.ROCKET)){
            return actor.getName() +  " сейчас находится в " +  actor.getLocation() +
                    " а не в " +  Location.ROCKET.getName();
        }
        else{
            return "Сначала нужно нажать кнопку";
        }

    }

    public boolean canReact(Shorty actor){
        return doorStatus.equals(DoorStatus.CLOSED) &&
                actor.getLocation().equals(Location.NEAR_ROCKET) &&
                EventPressingButton.buttonStatus.equals(ButtonStatus.PRESSED);
    }
}
