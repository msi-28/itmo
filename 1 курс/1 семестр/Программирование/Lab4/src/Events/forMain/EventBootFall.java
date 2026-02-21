package Events.forMain;

import Events.Event;
import Events.EventType;
import person.enums.Emotions;
import items.Fallable;
import items.Boot;
import person.Shorty;

public class EventBootFall extends Event implements Fallable{
    public EventBootFall(){
        super(EventType.BOOT_FALL);
    }

    public String reactFallBootEvent(Shorty actor, Boot boot){
        if (boot.getIssOn()){
            return  (fallBoot(actor, boot));
        }
        else{
            return boot.getSide() + " уже упал с ноги персонажа " + actor.getName();
        }
    }

    public String fallBoot(Shorty actor, Boot boot){
        boot.setIsOn(false);
        actor.setEmotions(Emotions.JOYFUL);
        return (boot.getSide() + " " + EventType.BOOT_FALL.getText() + " "  + actor.getName());
    }


}
