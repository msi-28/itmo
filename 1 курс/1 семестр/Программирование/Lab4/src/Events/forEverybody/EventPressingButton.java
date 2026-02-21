package Events.forEverybody;

import Events.Event;
import Events.EventType;
import environment.enums.ButtonStatus;
import person.interfaces.Reactable;
import environment.Location;
import person.Shorty;

public class EventPressingButton extends Event implements Reactable {
    protected static ButtonStatus buttonStatus = ButtonStatus.UNPRESSED;
    public EventPressingButton(){
        super(EventType.PRESS_THE_BUTTON);
    }

    public String reactPressingButtonEvent(Shorty actor) {
        if (canReact(actor)) {
            buttonStatus = ButtonStatus.PRESSED;
            EventOpenTheDoor eventOpenTheDoor = new EventOpenTheDoor();
            eventOpenTheDoor.reactOpenTheDoorEvent(actor);
            return actor.getName() + " " + EventType.PRESS_THE_BUTTON.getText();
        }
        else if (! actor.getLocation().equals(Location.ROCKET)) {
             return "Персонаж " +  actor.getName() +  " не рядом с " +  Location.ROCKET.getName();
        }
        else{
            return "Кнопка уже нажата";
        }
    }

    public ButtonStatus getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(ButtonStatus buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

    public boolean canReact(Shorty actor){
        return buttonStatus.equals(ButtonStatus.UNPRESSED) &&
                actor.getLocation().equals(Location.NEAR_ROCKET);
    }

}
